package com.jere.ejerciciobiblioteca.repositorios;

import com.jere.ejerciciobiblioteca.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {

}
