package com.coudevi;

import com.coudevi.model.Categoria;
import com.coudevi.model.Producto;
import com.coudevi.model.TipoCategoria;
import com.coudevi.service.CategoriaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MainManyToOne {
    public static void main(String[] args) {
        CategoriaService service = new CategoriaService();

        // Recuperar las categorías existentes (las 10 insertadas mediante el script SQL)
        var categorias = service.obtenerCategoriasConProductos();
        log.info("Número de categorías recuperadas: " + categorias.size());
        categorias.forEach(c -> {
            log.info("Categoría: " + c.getTipo() + " (ID: " + c.getId() + ")");
            c.getProductos().forEach(p -> log.info("  Producto: " + p.getNombre() + " (ID: " + p.getId() + ")"));
        });

        // Ejemplo de inserción: crear una nueva categoría con 5 productos nuevos
        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setTipo(TipoCategoria.AUTOMOVILES);
        for (int i = 1; i <= 5; i++) {
            Producto prod = new Producto();
            prod.setNombre("Auto " + i);
            nuevaCategoria.agregarProducto(prod);
        }
        service.crearCategoria(nuevaCategoria);
        log.info("Nueva categoría creada con id: " + nuevaCategoria.getId());

        service.cerrar();
    }
}
