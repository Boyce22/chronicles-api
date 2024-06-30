package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Chapter;
import br.com.chronicles.model.entity.FileWork;

public interface ChapterBuilder {

    ChapterBuilder withFile(FileWork file);

    ChapterBuilder withDescription(String description);

    ChapterBuilder withTitle(String title);

    ChapterBuilder withNumberPages(Integer numberPages);

    Chapter build();
}