package com.veterinaria.consulta;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository repository;
    private final ConsultaModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Consulta>> all() {
        List<EntityModel<Consulta>> consultas = repository.findAll().stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(consultas,
                linkTo(methodOn(ConsultaController.class).all()).withSelfRel());
    }

    @PostMapping
    public EntityModel<Consulta> create(@RequestBody Consulta consulta) {
        return assembler.toModel(repository.save(consulta));
    }

    @GetMapping("/{id}")
    public EntityModel<Consulta> one(@PathVariable Long id) {
        return repository.findById(id)
                .map(assembler::toModel)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));
    }
}
