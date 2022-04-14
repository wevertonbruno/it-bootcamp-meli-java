package com.example.storage4pratica2.service;

import com.example.storage4pratica2.domain.Indicies;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Service
public class ElasticsearchIndexService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchIndexService.class);
    private static final List<String> INDICES = List.of(Indicies.EMPLOYEE_INDEX, Indicies.PRODUCT_INDEX);
    private final RestHighLevelClient elasticsearchClient;

    public ElasticsearchIndexService(RestHighLevelClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public void createIndexes(final Boolean deleteIfExists){
        final String settings = loadFileAsString("static/es-config.json");

        if(settings == null){
            LOGGER.error("Failed to load index config");
            return;
        }

        for (String indexName: INDICES){
            try{
                Boolean hasIndex = elasticsearchClient
                        .indices()
                        .exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);

                if(hasIndex){
                    if(!deleteIfExists) continue;

                    elasticsearchClient
                            .indices()
                            .delete(new DeleteIndexRequest(indexName), RequestOptions.DEFAULT);
                }

                CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
                createIndexRequest.settings(settings, XContentType.JSON);

                String mappings = loadMappings(indexName);
                if(mappings != null){
                    createIndexRequest.mapping(mappings, XContentType.JSON);
                }

                elasticsearchClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            }catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                return;
            }
        }
    }

    private String loadMappings(String indexName) {
        final String mappings = loadFileAsString("static/mappings/" + indexName + ".json");
        if (mappings == null) {
            LOGGER.error("Failed to load mappings for index with name '{}'", indexName);
            return null;
        }

        return mappings;
    }

    private String loadFileAsString(final String path){
        try {
            final File resource = new ClassPathResource(path).getFile();
            return new String(Files.readAllBytes(resource.toPath()));
        } catch (final Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
