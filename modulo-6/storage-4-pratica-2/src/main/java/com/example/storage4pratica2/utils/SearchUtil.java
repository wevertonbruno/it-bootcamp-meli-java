package com.example.storage4pratica2.utils;

import com.example.storage4pratica2.dto.SearchDTO;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

public final class SearchUtil {
    private SearchUtil() {}

    public static QueryBuilder builder(final SearchDTO searchDTO){
        if (searchDTO == null) {
            return null;
        }

        if(searchDTO.getFields().isEmpty()){
            return null;
        }

        if(searchDTO.getFields().size() > 1){
            MultiMatchQueryBuilder queryBuilder =
                    QueryBuilders.multiMatchQuery(searchDTO.getTerm())
                            .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                            .operator(Operator.AND);

            searchDTO.getFields().forEach(queryBuilder::field);
            return queryBuilder;
        }

        return searchDTO.getFields().stream()
                .findFirst()
                .map(field ->
                        QueryBuilders.matchQuery(field, searchDTO.getTerm())
                                .operator(Operator.AND))
                .orElse(null);
    }
}
