package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.MangaGenre;

public interface MangaGenreBuilder {

    MangaGenreBuilder withName(String name);

    MangaGenreBuilder withDescription(String description);

    MangaGenre build();
}
