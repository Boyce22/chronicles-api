package br.com.chronicles.buillders;

import br.com.chronicles.model.entity.Collaborator;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.model.entity.Genre;
import br.com.chronicles.model.entity.Work;

import java.util.List;

public interface WorkBuilder {
    WorkBuilder withTitle(String title);

    WorkBuilder withDescription(String description);

    WorkBuilder withCover(byte[] cover);

    WorkBuilder withGenres(List<? extends Genre> genres);

    WorkBuilder withCollaborator(Collaborator collaborator);

    WorkBuilder withIsMature(boolean isMature);

    WorkBuilder withFile(FileWork fileWork);

    WorkBuilder withRating(Double rating);

    WorkBuilder active();

    WorkBuilder disable();

    Work build();

}
