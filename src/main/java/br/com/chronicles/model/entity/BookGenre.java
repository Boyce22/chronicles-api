package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.BookGenreBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "book_genre")
@Entity(name = "book_genre")
public class BookGenre extends Genre {

    public static BookGenreBuilder builder() {
        return new BookGenreBuilderImpl(new BookGenre());
    }

    private record BookGenreBuilderImpl(BookGenre bookGenre) implements BookGenreBuilder {

        @Override
        public BookGenreBuilderImpl withDescription(String description) {
            bookGenre.description = description;
            return this;
        }

        @Override
        public BookGenreBuilderImpl withName(String name) {
            bookGenre.name = name;
            return this;
        }

        @Override
        public BookGenre build() {
            return bookGenre;
        }
    }
}
