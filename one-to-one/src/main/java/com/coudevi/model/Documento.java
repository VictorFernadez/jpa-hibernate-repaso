package com.coudevi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo")
    private TipoDocumento tipoDocumento;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_expedicion")
    private LocalDate fechaExpedicion;
    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Documento(TipoDocumento tipoDocumento, LocalDate fechaExpedicion) {
        this.tipoDocumento = tipoDocumento;
        this.fechaExpedicion = fechaExpedicion;
    }
}
