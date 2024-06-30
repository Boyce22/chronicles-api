package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.RecommendationBookBuilder;
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
@Table(name = "recommendation_book")
@Entity(name = "recommendation_book")
public class RecommendationBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Set<String> genresBook;

    @OneToOne
    @JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
    private Reader reader;


    public RecommendationBookBuilder builder() {
        return new RecommendationBookBuilderImpl(new RecommendationBook());
    }

    private record RecommendationBookBuilderImpl(
            RecommendationBook recommendationBook) implements RecommendationBookBuilder {

        @Override
        public RecommendationBookBuilder withGenresBook(Set<String> genresBook) {
            recommendationBook.genresBook = genresBook;
            return this;
        }

        @Override
        public RecommendationBookBuilder withReader(Reader reader) {
            recommendationBook.reader = reader;
            return this;
        }

        @Override
        public RecommendationBook build() {
            return recommendationBook;
        }
    }

}
