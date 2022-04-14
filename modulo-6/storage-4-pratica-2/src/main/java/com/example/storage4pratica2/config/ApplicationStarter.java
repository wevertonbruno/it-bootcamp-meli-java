package com.example.storage4pratica2.config;

import com.example.storage4pratica2.service.ElasticsearchIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ApplicationStarter {
    private final Logger LOGGER = LoggerFactory.getLogger(ApplicationStarter.class);

    private final ElasticsearchIndexService elasticsearchIndexService;

    public ApplicationStarter(ElasticsearchIndexService elasticsearchIndexService) {
        this.elasticsearchIndexService = elasticsearchIndexService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        LOGGER.info("Indexing indicies...");
        elasticsearchIndexService.createIndexes(false);
        LOGGER.info("Indicies have been indexed!");
    }
}
