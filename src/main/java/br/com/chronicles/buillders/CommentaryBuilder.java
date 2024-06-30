package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Commentary;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.Work;

public interface CommentaryBuilder {

    CommentaryBuilder withContent(String content);

    CommentaryBuilder withWork(Work work);

    CommentaryBuilder withReader(Reader reader);

    Commentary build();

}
