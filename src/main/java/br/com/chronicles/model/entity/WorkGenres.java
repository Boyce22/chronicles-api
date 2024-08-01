package br.com.chronicles.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_genres")
public class WorkGenres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_genres_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_book_genre_cd_id")
    private BookGenre bookGenre;

    @ManyToOne
    @JoinColumn(name = "fk_manga_genre_cd_id")
    private MangaGenre mangaGenre;
}



