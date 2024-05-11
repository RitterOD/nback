package org.maslov.nback.controller.rest.v1;

import org.maslov.nback.model.dto.AbcDTO;
import org.maslov.nback.service.AbcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestApiNamesV1.API_V1_PUBLIC_ABC)
public class AbcController {

    private AbcService abcService;

    public AbcController(AbcService abcService) {
        this.abcService = abcService;
    }

    @GetMapping
    List<AbcDTO> getAll() {
        return abcService.getAll();
    }

}
