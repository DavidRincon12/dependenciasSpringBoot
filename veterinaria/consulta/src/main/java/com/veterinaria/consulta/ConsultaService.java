package com.veterinaria.consulta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public List<Consulta> obtenerTodas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> obtenerPorId(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta crear(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Optional<Consulta> actualizar(Long id, Consulta nuevaConsulta) {
        return consultaRepository.findById(id)
                .map(consulta -> {
                    consulta.setMotivo(nuevaConsulta.getMotivo());
                    consulta.setDiagnostico(nuevaConsulta.getDiagnostico());
                    consulta.setTratamiento(nuevaConsulta.getTratamiento());
                    consulta.setIdMascota(nuevaConsulta.getIdMascota());
                    return consultaRepository.save(consulta);
                });
    }

    public void eliminar(Long id) {
        consultaRepository.deleteById(id);
    }
}
