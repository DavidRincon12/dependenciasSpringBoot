package com.veterinaria.mascota;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class MascotaModelAssembler implements RepresentationModelAssembler<Mascota, EntityModel<Mascota>> {

    @Override
    public EntityModel<Mascota> toModel(Mascota mascota) {
        return EntityModel.of(mascota,
                linkTo(methodOn(MascotaController.class).one(mascota.getId())).withSelfRel(),
                linkTo(methodOn(MascotaController.class).all()).withRel("mascotas"));
    }
}
