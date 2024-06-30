package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.RecommendationMangaBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recommendation_manga")
@Entity(name = "recommendation_manga")
public class RecommendationManga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Set<String> genresManga;

    @OneToOne
    @JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
    private Reader reader;


    public static RecommendationMangaBuilder builder() {
        return new RecommendationMangaBuilderImpl(new RecommendationManga());
    }

    record RecommendationMangaBuilderImpl(
            RecommendationManga recommendationManga) implements RecommendationMangaBuilder {

        @Override
        public RecommendationMangaBuilder withGenresBook(Set<String> genresManga) {
            recommendationManga.genresManga = genresManga;
            return this;
        }

        @Override
        public RecommendationMangaBuilder withReader(Reader reader) {
            recommendationManga.reader = reader;
            return this;
        }

        @Override
        public RecommendationManga build() {
            return recommendationManga;
        }
    }

}
