package com.example.storage4pratica2.service;

import com.example.storage4pratica2.data.ES.ProductRepository;
import com.example.storage4pratica2.domain.Product;
import com.example.storage4pratica2.dto.SearchDTO;
import com.example.storage4pratica2.utils.SearchUtil;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ElasticsearchOperations operations;

    public ProductService(ProductRepository productRepository, ElasticsearchOperations operations) {
        this.productRepository = productRepository;
        this.operations = operations;
    }

    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Product update(String id, Product product) {
        Product productToUpdate = findById(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStorage(product.getStorage());
        productToUpdate.setCategory(product.getCategory());
        return productRepository.save(productToUpdate);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> search(final SearchDTO searchDTO){
        Query query = new NativeSearchQueryBuilder()
                .withQuery(SearchUtil.builder(searchDTO))
                .build();

        SearchHits<Product> searchHits = operations.search(query, Product.class);

        return searchHits.get()
                .map(hit -> hit.getContent())
                .collect(Collectors.toList());
    }
}
