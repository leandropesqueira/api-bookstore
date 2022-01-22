package com.leandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.LivroRepository;
import com.leandro.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroReporitory;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {
		Optional<Livro> obj = livroReporitory.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {
		categoriaService.findById(id_cat);
		return livroReporitory.findAllByCategoria(id_cat);
	}

	public Livro update(Long id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroReporitory.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTexto(obj.getTexto());
		
	}

	public Livro create(Long id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return livroReporitory.save(obj);
	}

	public void delete(Long id) {
		Livro obj = findById(id);
		livroReporitory.delete(obj);		
	}
}
