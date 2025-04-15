package com.hellocode.crudspring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellocode.crudspring.Entities.Libro;
import com.hellocode.crudspring.Repositories.LibroRepository;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorID(@PathVariable Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el libro con el ID: " + id));
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {

        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el libro con el ID: " + id));

        libro.setAuthor(libroActualizado.getAuthor());
        libro.setTitle(libroActualizado.getTitle());
        libro.setYear(libroActualizado.getYear());

        return libroRepository.save(libro);
    }

    @DeleteMapping("/{id}")
    public String borrarLibro(@PathVariable Long id) {

        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el libro con el ID: " + id));

        libroRepository.delete(libro);
        return "El libro con el ID: " + id + " fue eliminado correctamente";

    }

}
