package br.com.chronicles.model.entity;

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

    public static MangaGenre create() {
        return new MangaGenre();
    }

    @Override
    public MangaGenre register(String name, String description) {
        this.name = name;
        this.description = description;
        return this;
    }
}
