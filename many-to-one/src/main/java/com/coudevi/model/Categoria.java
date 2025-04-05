package com.coudevi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCategoria tipo;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Producto> productos = new ArrayList<>();

    // Método de conveniencia para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        producto.setCategoria(this);
    }

    // Método de conveniencia para remover un producto
    public void removerProducto(Producto producto) {
        productos.remove(producto);
        producto.setCategoria(null);
    }

    public Categoria(TipoCategoria tipo) {
        this.tipo = tipo;
    }
}
