package com.coudevi.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos = new ArrayList<>();

    // Método de conveniencia para inscribir en un curso
    public void inscribirCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            curso.getEstudiantes().add(this);
        }
    }

    // Método de conveniencia para abandonar un curso
    public void abandonarCurso(Curso curso) {
        if (cursos.contains(curso)) {
            cursos.remove(curso);
            curso.getEstudiantes().remove(this);
        }
    }
}
