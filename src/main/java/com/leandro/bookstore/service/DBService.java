package com.leandro.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.CategoriaRepository;
import com.leandro.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografias");
		Categoria cat4 = new Categoria(null, "Banco de Dados", "Livro de DB");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
		Livro l6 = new Livro(null, "Life of Author", "H.G. Wells", "Lorem ipsum", cat3);
		Livro l7 = new Livro(null, "PostgreSQL Guia Fundamental", "Carlos Pampulim Caldeira", "Lorem ipsum", cat4);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		cat3.getLivros().addAll(Arrays.asList(l6));
		cat4.getLivros().addAll(Arrays.asList(l7));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6,l7));
	}
	
}
