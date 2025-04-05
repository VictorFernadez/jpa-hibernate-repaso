package com.coudevi;

import com.coudevi.model.Documento;
import com.coudevi.model.Persona;
import com.coudevi.model.TipoDocumento;
import com.coudevi.service.PersonaService;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Log4j2
public class MainOneToOne {
    public static void main(String[] args) {
        PersonaService service = new PersonaService();

        Persona persona = new Persona("Victor");

        Documento documento = new Documento(TipoDocumento.DNI, LocalDate.of(2028,10,12));
        persona.asignarDocumento(documento);

        service.crearPersona(persona);
        log.info("******************** LISTADO DE PERSONAS ********************");

        service.obtenerPersonas().forEach(p -> {
            log.info("Persona " + p.getNombre());
            if (p.getDocumento() != null){
                log.info("Documento tipo: " + p.getDocumento().getTipoDocumento());
                log.info("Fecha Expedición" + p.getDocumento().getFechaExpedicion());
            }else {
                log.info("Sin documento asignado");
            }
        });
        service.cerrar();
    }
}
