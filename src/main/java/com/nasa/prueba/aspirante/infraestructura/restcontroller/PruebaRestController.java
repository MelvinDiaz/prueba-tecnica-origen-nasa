package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import com.nasa.prueba.aspirante.handlers.response.GeneralResponse;
import com.nasa.prueba.aspirante.handlers.response.GeneralResponseBuilder;
import com.nasa.prueba.aspirante.infraestructura.services.PruebaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PruebaRestController {
    private final PruebaService pruebaService;
    private final GeneralResponseBuilder generalResponse;

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getPruebasOrderedByNasaIdDesc() {
        return generalResponse.setHttpStatus(HttpStatus.OK).setObj(pruebaService.getAllOrderedByNasaIdDesc()).build();
    }

    @GetMapping("/paginated/")
    public ResponseEntity<GeneralResponse> getPruebasPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        return generalResponse.setHttpStatus(HttpStatus.OK).setObj(pruebaService.getAllPaginated(pageable)).build();
    }
}
