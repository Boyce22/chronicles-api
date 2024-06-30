package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.BookGenre;

public interface BookGenreBuilder {

    BookGenreBuilder withDescription(String description);

    BookGenreBuilder withName(String name);

    BookGenre build();
}
