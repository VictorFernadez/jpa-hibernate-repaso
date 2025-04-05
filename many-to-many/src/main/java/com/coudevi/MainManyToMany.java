package com.coudevi;

import com.coudevi.model.Curso;
import com.coudevi.model.Estudiante;
import com.coudevi.service.EstudianteService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.log4j.Log4j2;
import java.util.Date;
@Log4j2
public class MainManyToMany {
    public static void main(String[] args) {
        EstudianteService service = new EstudianteService();

        // Recuperar estudiantes existentes (si hay registros insertados previamente)
        var estudiantes = service.obtenerEstudiantesConCursos();
        log.info("Número de estudiantes recuperados: " + estudiantes.size());
        estudiantes.forEach(e -> {
            log.info("Estudiante: " + e.getNombre() + " (ID: " + e.getId() + ")");
            e.getCursos().forEach(c -> log.info("  Curso: " + c.getNombre() + ", Nivel: " + c.getNivel()));
        });

        // Ejemplo de inserción: Crear un nuevo estudiante y asignarle cursos
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Carlos Ramirez");

        // Crear cursos (estos cursos pueden ya existir en la BD; para el ejemplo, creamos nuevos)
        Curso curso1 = new Curso();
        curso1.setNombre("Biología");
        curso1.setNivel(NivelCurso.INTERMEDIO);
        curso1.setFechaInicio(new Date());

        Curso curso2 = new Curso();
        curso2.setNombre("Química");
        curso2.setNivel(NivelCurso.AVANZADO);
        curso2.setFechaInicio(new Date());

        // Inscribir el estudiante en los cursos
        nuevoEstudiante.inscribirCurso(curso1);
        nuevoEstudiante.inscribirCurso(curso2);

        // Persistir el nuevo estudiante (la tabla de unión se actualizará automáticamente)
        service.crearEstudiante(nuevoEstudiante);
        log.info("Nuevo estudiante persistido con id: " + nuevoEstudiante.getId());

        service.cerrar();
    }
}
