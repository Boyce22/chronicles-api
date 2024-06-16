package br.com.chronicles.model.entity;

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

    public static BookGenre create() {
        return new BookGenre();
    }

    @Override
    public BookGenre register(String name, String description) {
        this.name = name;
        this.description = description;
        return this;
    }
}
