package br.com.chronicles.service;

import br.com.chronicles.interfaces.RecommentationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommentationServiceImpl implements RecommentationService {

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
