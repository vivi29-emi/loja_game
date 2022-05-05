package com.example.lojagame.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lojagame.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

	public List <Categoria> findAllByTipoContainingIgnoreCase(String tipo);

}
