package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.RecommendationBook;

import java.util.Set;

public interface RecommendationBookBuilder {

    RecommendationBookBuilder withGenresBook(Set<String> genresBook);

    RecommendationBookBuilder withReader(Reader reader);

    RecommendationBook build();
}
