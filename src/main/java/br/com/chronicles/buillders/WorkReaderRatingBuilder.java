package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.entity.WorkReaderRating;

public interface WorkReaderRatingBuilder {

    WorkReaderRatingBuilder withRating(Double rating);

    WorkReaderRatingBuilder withReader(Reader reader);

    WorkReaderRatingBuilder withWork(Work work);

    WorkReaderRating build();
}
