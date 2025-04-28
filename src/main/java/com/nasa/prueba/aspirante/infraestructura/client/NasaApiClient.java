package com.nasa.prueba.aspirante.infraestructura.client;

import com.nasa.prueba.aspirante.infraestructura.client.dto.NasaApiResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NasaApiClient {

    private static final Logger logger = LoggerFactory.getLogger(NasaApiClient.class);
    private static final String NASA_API_URL = "https://images-api.nasa.gov/search";

    private final RestTemplate restTemplate;

    @Autowired
    public NasaApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Searches the NASA Image and Video Library API.
     *
     * @param query The search query (e.g., "apollo 11").
     * @return NasaApiResponseDto containing the search results, or null if an error occurs.
     */
    public NasaApiResponseDto searchNasaImages(String query) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(NASA_API_URL)
                .queryParam("q", query);

        String url = builder.build().toUriString();
        logger.info("Requesting NASA API: {}", url);

        try {
            logger.info(url);
            NasaApiResponseDto response = restTemplate.getForObject(url, NasaApiResponseDto.class);
            logger.info("Successfully received response from NASA API for query: {}", query);
            return response;
        } catch (HttpClientErrorException e) {
            logger.error("HTTP error fetching data from NASA API: {} - {}", e.getStatusCode(), e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            logger.error("Error fetching data from NASA API: {}", e.getMessage(), e);
        }
        return null; // Return null in case of errors
    }
}
