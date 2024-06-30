package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.RecommendationManga;

import java.util.Set;

public interface RecommendationMangaBuilder {

    RecommendationMangaBuilder withGenresBook(Set<String> genresManga);

    RecommendationMangaBuilder withReader(Reader reader);

    RecommendationManga build();
}
