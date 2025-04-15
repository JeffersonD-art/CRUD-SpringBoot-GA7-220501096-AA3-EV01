package com.hellocode.crudspring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellocode.crudspring.Entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
