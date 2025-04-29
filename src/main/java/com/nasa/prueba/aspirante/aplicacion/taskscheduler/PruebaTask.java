package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.infraestructura.client.NasaApiClient;
import com.nasa.prueba.aspirante.dominio.dto.NasaApiResponseDto;
import com.nasa.prueba.aspirante.infraestructura.services.NasaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component // Mark this class as a Spring component
@AllArgsConstructor
@Slf4j
public class PruebaTask {

    private NasaApiClient nasaApiClient;
    private NasaService nasaService;

    @Scheduled(fixedRate = 60000)
    public void fetchAndStoreNasaData() {
        log.info("Executing scheduled task to fetch NASA data at {}", LocalDateTime.now());

        // 1. Call NASA API
        // Using "apollo 11" as the default query based on README examples
        NasaApiResponseDto response = nasaApiClient.searchNasaImages("apollo 11");
        // 2. Process the response
        if (response != null && response.getCollection() != null && response.getCollection().getItems() != null) {
            // getCollection returns a Collection object. Works thanks to
            NasaApiResponseDto.NasaItemDto firstItem = response.getCollection().getItems().getFirst();
            if (firstItem.getData() != null && !firstItem.getData().isEmpty()) {
                NasaApiResponseDto.NasaDataDto dataElement = firstItem.getData().getFirst(); // Get only the first element from data array
                // 3. Extract required fields
                String href = firstItem.getHref();
                String center = dataElement.getCenter();
                String title = dataElement.getTitle();
                String nasaId = dataElement.getNasa_id();
                PruebaDto pruebaDto = new PruebaDto(href, center, title, nasaId, LocalDateTime.now());

                // 4. Save the entity
                nasaService.guardarTransaccion(pruebaDto);

                log.debug("Saved entity for nasa_id: {}", nasaId);
            } else {
                log.warn("Item with href {} has null or empty data array, skipping.", firstItem.getHref());
            }
            log.info("Successfully processed and saved item.");
        } else {
            log.warn("Received null or empty response from NASA API.");
        }
    }
}
