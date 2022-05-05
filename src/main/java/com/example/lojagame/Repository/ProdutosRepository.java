package com.example.lojagame.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lojagame.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos,Long>{
 // 
	public List <Produtos>  findAllByNomeContainingIgnoreCase(String nome);

	 
	public List <Produtos> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco); // <-- Contrutor do maior preço

	public List <Produtos> findByPrecoGreaterThanOrderByPreco(BigDecimal preco); // <-- contrutor do menor preço
	
   
	
}
