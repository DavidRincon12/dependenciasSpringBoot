package com.veterinaria.mascota;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository repository;

    public List<Mascota> findAll() {
        return repository.findAll();
    }

    public Optional<Mascota> findById(Long id) {
        return repository.findById(id);
    }

    public Mascota save(Mascota mascota) {
        return repository.save(mascota);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
