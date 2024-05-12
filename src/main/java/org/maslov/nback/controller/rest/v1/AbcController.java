package org.maslov.nback.controller.rest.v1;

import org.maslov.nback.model.dto.AbcDTO;
import org.maslov.nback.service.AbcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(RestApiNamesV1.API_V1_PUBLIC_ABC)
public class AbcController {

    private AbcService abcService;

    public AbcController(AbcService abcService) {
        this.abcService = abcService;
    }

    @GetMapping
    ResponseEntity<List<AbcDTO>> list() {
        return ResponseEntity.ok(abcService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<AbcDTO> get(@PathVariable UUID id) {
        return abcService.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    ResponseEntity<AbcDTO> create(@RequestBody AbcDTO dto) {
        return ResponseEntity.ok(abcService.create(dto));
    }

}
