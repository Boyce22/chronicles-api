package br.com.chronicles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.chronicles.interfaces.RecommentationServiceImpl;

@Service
public class RecommendationService implements RecommentationServiceImpl {

	@Override
	public void associateRecommendation(List<String> genres, Long readerId) {
		/*
		 * tenho que pegar as categorias do manga/livro, pegar os generos que já estão
		 * salvos na recomendação do usuário e comparar, se não houver o genero nas
		 * recomendações, tenho que adicionar, sendo que o limite de generso deve ser
		 * definido
		 */
	}
}
