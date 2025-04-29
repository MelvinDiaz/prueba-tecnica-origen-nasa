package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.handlers.response.GeneralResponse;
import com.nasa.prueba.aspirante.handlers.response.GeneralResponseBuilder;
import com.nasa.prueba.aspirante.infraestructura.services.PruebaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PruebaRestControllerTest {

    @Mock
    private PruebaService pruebaService;

    @Mock
    private GeneralResponseBuilder generalResponseBuilder;

    @Mock
    private GeneralResponse generalResponse;

    @InjectMocks
    private PruebaRestController pruebaRestController;

    @BeforeEach
    void setUp() {
        // Setup builder to return itself for chaining and finally build the response
        when(generalResponseBuilder.setHttpStatus(any(HttpStatus.class))).thenReturn(generalResponseBuilder);
        when(generalResponseBuilder.setObj(any())).thenReturn(generalResponseBuilder);
        when(generalResponseBuilder.build()).thenReturn(ResponseEntity.ok(generalResponse));
    }

    @Test
    void getPruebasOrderedByNasaIdDesc_ShouldReturnOrderedData() {
        // Arrange
        List<PruebaEntity> mockData = Arrays.asList(new PruebaEntity(), new PruebaEntity());
        when(pruebaService.getAllOrderedByNasaIdDesc()).thenReturn(mockData);

        // Act
        ResponseEntity<GeneralResponse> response = pruebaRestController.getPruebasOrderedByNasaIdDesc();

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify service was called
        verify(pruebaService, times(1)).getAllOrderedByNasaIdDesc();

        // Verify response builder was used correctly
        verify(generalResponseBuilder, times(1)).setHttpStatus(HttpStatus.OK);
        verify(generalResponseBuilder, times(1)).setObj(mockData);
        verify(generalResponseBuilder, times(1)).build();
    }

    @Test
    void getPruebasPaginated_WithDefaultValues_ShouldUseDefaultPageAndSize() {
        // Arrange
        int defaultPage = 0;
        int defaultSize = 10;
        Pageable expectedPageable = PageRequest.of(defaultPage, defaultSize);

        Page<PruebaEntity> mockPageData = new PageImpl<>(Arrays.asList(new PruebaEntity(), new PruebaEntity()));
        when(pruebaService.getAllPaginated(eq(expectedPageable))).thenReturn(mockPageData);

        // Act
        ResponseEntity<GeneralResponse> response = pruebaRestController.getPruebasPaginated(defaultPage, defaultSize);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify service was called with correct pageable
        verify(pruebaService, times(1)).getAllPaginated(eq(expectedPageable));

        // Verify response builder was used correctly
        verify(generalResponseBuilder, times(1)).setHttpStatus(HttpStatus.OK);
        verify(generalResponseBuilder, times(1)).setObj(mockPageData);
        verify(generalResponseBuilder, times(1)).build();
    }

    @Test
    void getPruebasPaginated_WithCustomValues_ShouldUseProvidedPageAndSize() {
        // Arrange
        int customPage = 2;
        int customSize = 5;
        Pageable expectedPageable = PageRequest.of(customPage, customSize);

        Page<PruebaEntity> mockPageData = new PageImpl<>(Arrays.asList(new PruebaEntity(), new PruebaEntity()));
        when(pruebaService.getAllPaginated(eq(expectedPageable))).thenReturn(mockPageData);

        // Act
        ResponseEntity<GeneralResponse> response = pruebaRestController.getPruebasPaginated(customPage, customSize);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify service was called with correct pageable
        verify(pruebaService, times(1)).getAllPaginated(eq(expectedPageable));

        // Verify response builder was used correctly
        verify(generalResponseBuilder, times(1)).setHttpStatus(HttpStatus.OK);
        verify(generalResponseBuilder, times(1)).setObj(mockPageData);
        verify(generalResponseBuilder, times(1)).build();
    }
}
