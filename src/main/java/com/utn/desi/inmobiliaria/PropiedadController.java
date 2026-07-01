package com.utn.desi.inmobiliaria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.utn.desi.inmobiliaria.entity.Propiedad;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    // 1.4 LISTADO: Entrás a http://localhost:8080/propiedades/listar
    @GetMapping("/listar")
    public List<Propiedad> listarPropiedades() {
        return propiedadService.listarActivas();
    }

    // 1.1 ALTA: Para guardar una propiedad nueva
    @PostMapping("/guardar")
    public String guardarPropiedad(@RequestBody Propiedad propiedad) {
        propiedadService.guardar(propiedad);
        return "Propiedad guardada exitosamente en la base de datos.";
    }

    // 1.3 MODIFICACIÓN: Para buscar una propiedad específica por su ID
    @GetMapping("/buscar/{id}")
    public Propiedad buscarPorId(@PathVariable("id") Long id) {
        return propiedadService.buscarPorId(id);
    }

    // 1.2 ELIMINACIÓN (Baja Lógica): Entrás a http://localhost:8080/propiedades/eliminar/Acá_Va_El_ID
    @GetMapping("/eliminar/{id}")
    public String eliminarPropiedad(@PathVariable("id") Long id) {
        propiedadService.eliminarLogica(id);
        return "Propiedad con ID " + id + " marcada como eliminada (Baja Lógica).";
    }
}