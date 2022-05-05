package com.example.lojagame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lojagame.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

	public List <Categoria> findAllByTipoContainingIgnoreCase(String tipo);

}
