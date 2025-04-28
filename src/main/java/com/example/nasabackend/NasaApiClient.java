package com.example.nasabackend;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NasaApiClient {

    private final RestTemplate restTemplate;

    public NasaApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T fetchData(String url, Class<T> responseType) {
        // Use the URI directly without allowing RestTemplate to modify it
        return restTemplate.getForObject(url, responseType);
    }

    public String searchImages(String query) {
        // Build the URL with proper encoding using UriComponentsBuilder
        String baseUrl = "https://images-api.nasa.gov/search";
        
        // Use UriComponentsBuilder which handles encoding properly
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
            .queryParam("q", query)
            .build(false) // false means don't encode again
            .toUriString();
            
        // Call directly without further encoding
        return restTemplate.getForObject(url, String.class);
    }

    // ...existing code...
}
