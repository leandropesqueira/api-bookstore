package com.leandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.repositories.CategoriaRepository;
import com.leandro.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}

}
