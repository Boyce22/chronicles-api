package br.com.chronicles.model.entity;

import br.com.chronicles.model.request.WorkCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work")
@Entity(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_cd_id")
    private Long id;

    @Column(name = "work_tx_title")
    private String title;

    @Column(name = "work_tx_description")
    private String description;

    @Column(name = "work_dt_releasedAt")
    private LocalDateTime releasedAt;

    @Column(name = "work_nm_rating")
    private Double rating;

    @Column(name = "work_dt_createdAt")
    private LocalDate createdAt;

    @Column(name = "work_dt_updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "work_bl_is_active")
    private Boolean isActive;

    @Column(name = "work_bl_is_mature_content")
    private Boolean isMature;

    @OneToMany(mappedBy = "work")
    private List<Comentary> comments;

    @OneToOne
    @JoinColumn(name = "fk_file_cd_id", referencedColumnName = "file_cd_id")
    private FileWork file;

    @ManyToMany
    @JoinTable(
            name = "work_genres",
            joinColumns = @JoinColumn(name = "work_cd_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_book_genre_cd_id", referencedColumnName = "genre_cd_id::uuid")
    )
    List<BookGenre> bookGenres;

    @ManyToMany
    @JoinTable(
            name = "work_genres",
            joinColumns = @JoinColumn(name = "work_cd_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_manga_genre_cd_id", referencedColumnName = "genre_cd_id::uuid")
    )
    List<MangaGenre> mangaGenres;

    @ManyToOne
    @JoinColumn(name = "fk_author_cd_id", referencedColumnName = "author_cd_id")
    private Author author;

    @PrePersist
    void prePersist() {
        this.isActive = true;
        this.releasedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDate.now();
    }

    public static Work create() {
        return new Work();
    }

    public Work register(WorkCreateDTO dto, List<? extends Genre> genres, Author author, FileWork file, boolean isMature) {
        this.title = dto.title();
        this.description = dto.description();
        this.bookGenres = areAllBookGenres(genres) ? (List<BookGenre>) genres : null;
        this.mangaGenres = areAllMangaGenres(genres) ? (List<MangaGenre>) genres : null;
        this.author = author;
        this.isMature = isMature;
        this.file = file;
        return this;
    }

    public Work rating(Double rating) {
        this.rating = rating + rating;
        return this;
    }

    public List<String> getGenres() {
        return this.bookGenres != null ? this.bookGenres.stream().map(Genre::getName).toList() :
                this.mangaGenres != null ? this.mangaGenres.stream().map(Genre::getName).toList() :
                        Collections.emptyList();
    }

    private boolean areAllMangaGenres(List<? extends Genre> genres) {
        return genres.stream().allMatch(genre -> genre instanceof MangaGenre);
    }

    private boolean areAllBookGenres(List<? extends Genre> genres) {
        return genres.stream().allMatch(genre -> genre instanceof BookGenre);
    }

}
