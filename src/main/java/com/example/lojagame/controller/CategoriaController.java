package com.example.lojagame.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.lojagame.Repository.CategoriaRepository;
import com.example.lojagame.model.Categoria;




@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*",allowedHeaders="*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public ResponseEntity <List<Categoria>> getALL(){
		   return ResponseEntity.ok(categoriaRepository.findAll());
		  
	   }
	 @GetMapping("/{id}")  
	   public ResponseEntity <Categoria> geybyid(@PathVariable Long id){  
		return categoriaRepository.findById(id) 
				.map(resposta -> ResponseEntity.ok(resposta))   
				.orElse(ResponseEntity.notFound().build());
	   }
	 @GetMapping ("/Jogo/{Jogo}")
	   public ResponseEntity<List<Categoria>> getBytipoJogo(@PathVariable String Jogo){
		   return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(Jogo));
		 
	   }
	 @PostMapping     
	  public ResponseEntity <Categoria>  PostCategoria(@Valid @RequestBody Categoria categoria)	 
	   {
		   return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));	
	   }
	  @PutMapping 
	  public ResponseEntity <Categoria> PutTema(@Valid @RequestBody Categoria categoria)	   
	    
	   {
		   return categoriaRepository.findById(categoria.getId())
		   .map(resposta ->ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria)))
		   .orElse(ResponseEntity.notFound().build());
		   
		   
	   }
	   @DeleteMapping("/{id}")     
	   @ResponseStatus(HttpStatus.NO_CONTENT)      
		public void deleteCategoria(@Valid@PathVariable Long id)
	   {
			Optional <Categoria>categoria=categoriaRepository.findById(id);
			if (categoria.isEmpty())   
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);   
				
				categoriaRepository.deleteById(id);    
				  
			}
	 
	 
	
	

}
