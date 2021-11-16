/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntt.desafiopatronclient;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Manuel
 */
public class Service {

    Logger logger = LoggerFactory.getLogger(Service.class);

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8888/";
    String open = "open";
    String halfOpen = "half-open";
    String close = "close";

    public String setToOpen() {
        String fooResourceUrl = url + open;
        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(fooResourceUrl), String.class);
        logger.info("Estado: " + open);
        return response.getBody();
    }

    public String setToHalfOpen() {
        String fooResourceUrl = url + halfOpen;
        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(fooResourceUrl), String.class);
        logger.info("Estado: " + halfOpen);
        return response.getBody();
    }

    public String setToClose() {
        String fooResourceUrl = url + close;
        ResponseEntity<String> response = restTemplate.getForEntity(URI.create(fooResourceUrl), String.class);
        logger.info("Estado: " + close);
        return response.getBody();
    }
}
