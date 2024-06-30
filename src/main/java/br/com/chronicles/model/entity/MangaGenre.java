package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.MangaGenreBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "manga_genre")
@Entity(name = "manga_genre")
public class MangaGenre extends Genre {

    public static MangaGenreBuilder builder() {
        return new MangaGenreBuilderImpl(new MangaGenre());
    }

    private record MangaGenreBuilderImpl(MangaGenre mangaGenre) implements MangaGenreBuilder {

        @Override
        public MangaGenreBuilderImpl withName(String name) {
            mangaGenre.name = name;
            return this;
        }

        @Override
        public MangaGenreBuilderImpl withDescription(String description) {
            mangaGenre.description = description;
            return this;
        }

        @Override
        public MangaGenre build() {
            return mangaGenre;
        }
    }
}
