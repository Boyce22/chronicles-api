package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.WorkBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(name = "work_tx_cover")
    private byte[] cover;

    @Column(name = "work_dt_releasedAt")
    private LocalDateTime releasedAt;

    @Column(name = "work_nm_rating")
    private Double rating;

    @CreationTimestamp
    @Column(name = "work_dt_createdAt")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "work_dt_updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "work_bl_is_active")
    private Boolean isActive;

    @Column(name = "work_bl_is_mature_content")
    private Boolean isMature;

    @OneToMany(mappedBy = "work")
    private List<Commentary> comments;

    @OneToOne
    @JoinColumn(name = "fk_file_cd_id", referencedColumnName = "file_cd_id")
    private FileWork file;

    @ManyToMany
    @JoinTable(
            name = "work_genres",
            joinColumns = @JoinColumn(name = "work_cd_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_book_genre_cd_id", referencedColumnName = "genre_cd_id::uuid")
    )
    private List<BookGenre> bookGenres;

    @ManyToMany
    @JoinTable(
            name = "work_genres",
            joinColumns = @JoinColumn(name = "work_cd_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_manga_genre_cd_id", referencedColumnName = "genre_cd_id::uuid")
    )
    private List<MangaGenre> mangaGenres;

    @ManyToOne
    @JoinColumn(name = "fk_collaborator_cd_id", referencedColumnName = "collaborator_cd_id")
    private Collaborator collaborator;

    public static WorkBuilder builder() {
        return new WorkBuilderImpl(new Work());
    }

    private record WorkBuilderImpl(Work work) implements WorkBuilder {

        @Override
        public WorkBuilder withTitle(String title) {
            work.title = title;
            return this;
        }

        @Override
        public WorkBuilder withDescription(String description) {
            work.description = description;
            return this;
        }

        @Override
        public WorkBuilder withCover(byte[] cover) {
            work.cover = cover;
            return this;
        }

        @Override
        public WorkBuilder withGenres(List<? extends Genre> genres) {
            work.bookGenres = areAllBookGenres(genres) ? convertToBookGenreList(genres) : null;
            work.mangaGenres = areAllMangaGenres(genres) ? convertToMangaGenreList(genres) : null;
            return this;
        }

        @Override
        public WorkBuilder withCollaborator(Collaborator collaborator) {
            work.collaborator = collaborator;
            return this;
        }

        @Override
        public WorkBuilder withIsMature(boolean isMature) {
            work.isMature = isMature;
            return this;
        }

        @Override
        public WorkBuilder withFile(FileWork fileWork) {
            work.file = fileWork;
            return this;
        }

        @Override
        public WorkBuilder withRating(Double rating) {
            work.rating = rating;
            return this;
        }

        @Override
        public WorkBuilder active() {
            work.isActive = true;
            return this;
        }

        @Override
        public WorkBuilder disable() {
            work.isActive = false;
            return this;
        }

        @Override
        public Work build() {
            return work;
        }

        private boolean areAllMangaGenres(List<? extends Genre> genres) {
            return !genres.isEmpty() && genres.stream().anyMatch(genre -> genre instanceof MangaGenre);
        }

        private boolean areAllBookGenres(List<? extends Genre> genres) {
            return !genres.isEmpty() && genres.stream().anyMatch(genre -> genre instanceof BookGenre);
        }

        private List<MangaGenre> convertToMangaGenreList(List<? extends Genre> genres) {
            return genres.stream()
                    .map(genre -> (MangaGenre) genre)
                    .toList();
        }

        private List<BookGenre> convertToBookGenreList(List<? extends Genre> genres) {
            return genres.stream()
                    .map(genre -> (BookGenre) genre)
                    .toList();
        }
    }

    public List<String> getGenres() {
        return (this.bookGenres != null && !this.bookGenres.isEmpty()) ?
                this.bookGenres.stream().map(Genre::getName).toList() :
                ((this.mangaGenres != null && !this.mangaGenres.isEmpty()) ?
                        this.mangaGenres.stream().map(Genre::getName).toList() : Collections.emptyList());
    }

}
