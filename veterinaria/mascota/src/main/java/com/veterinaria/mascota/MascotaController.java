package com.veterinaria.mascota;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService service;
    private final MascotaModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Mascota>> all() {
        var mascotas = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(mascotas,
                linkTo(methodOn(MascotaController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Mascota> one(@PathVariable Long id) {
        var mascota = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        return assembler.toModel(mascota);
    }

    @PostMapping
    public EntityModel<Mascota> create(@RequestBody Mascota mascota) {
        var nueva = service.save(mascota);
        return assembler.toModel(nueva);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
