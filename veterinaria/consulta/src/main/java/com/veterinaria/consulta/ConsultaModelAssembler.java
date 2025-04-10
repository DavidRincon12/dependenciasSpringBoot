package com.veterinaria.consulta;

import org.springframework.hateoas.*;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ConsultaModelAssembler implements RepresentationModelAssembler<Consulta, EntityModel<Consulta>> {

    @Override
    public EntityModel<Consulta> toModel(Consulta consulta) {
        return EntityModel.of(consulta,
                linkTo(methodOn(ConsultaController.class).one(consulta.getId())).withSelfRel(),
                linkTo(methodOn(ConsultaController.class).all()).withRel("consultas"));
    }
}
