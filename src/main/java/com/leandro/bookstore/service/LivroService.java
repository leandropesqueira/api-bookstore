package com.leandro.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.LivroRepository;
import com.leandro.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroReporitory;

	public Livro findById(Long id) {
		Optional<Livro> obj = livroReporitory.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Livro.class.getName()));
	}
}
