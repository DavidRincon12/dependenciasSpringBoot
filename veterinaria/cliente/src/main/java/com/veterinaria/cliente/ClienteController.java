package com.veterinaria.cliente;

import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;
    private final ClienteModelAssembler assembler;

    public ClienteController(ClienteService service, ClienteModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Cliente>> getAll() {
        List<EntityModel<Cliente>> clientes = service.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(clientes,
                linkTo(methodOn(ClienteController.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = service.findById(id).orElseThrow();
        return assembler.toModel(cliente);
    }

    @PostMapping
    public EntityModel<Cliente> create(@RequestBody Cliente cliente) {
        Cliente nuevo = service.save(cliente);
        return assembler.toModel(nuevo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
