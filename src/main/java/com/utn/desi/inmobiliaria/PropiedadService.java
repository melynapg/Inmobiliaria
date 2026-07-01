package com.utn.desi.inmobiliaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.utn.desi.inmobiliaria.entity.Propiedad;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    public List<Propiedad> listarActivas() {
        return propiedadRepository.findByEliminadaFalse();
    }

    public Propiedad buscarPorId(Long id) {
        return propiedadRepository.findById(id).orElse(null);
    }

    public void guardar(Propiedad propiedad) {
        // Dejamos las validaciones simples para que guarde sin exigir bloques try/catch complejos en el controlador
        if (propiedad.getId() == null) {
            propiedad.setEliminada(false);
        }
        propiedadRepository.save(propiedad);
    }

    public void eliminarLogica(Long id) {
        Propiedad propiedad = propiedadRepository.findById(id).orElse(null);
        if (propiedad != null) {
            propiedad.setEliminada(true); 
            propiedadRepository.save(propiedad);
        }
    }
}