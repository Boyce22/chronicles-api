package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.ChapterBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter")
@Entity(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_file_cd_id", referencedColumnName = "file_cd_id")
    private FileWork file;

    @Column(name = "char_tx_title")
    private String title;

    @Column(name = "char_tx_description")
    private String description;

    @Column(name = "char_nm_pages")
    private Integer numberPages;

    public static ChapterBuilder builder() {
        return new ChapterBuilderImpl(new Chapter());
    }

    private record ChapterBuilderImpl(Chapter chapter) implements ChapterBuilder {

        @Override
        public ChapterBuilderImpl withFile(FileWork file) {
            chapter.file = file;
            return this;
        }

        @Override
        public ChapterBuilderImpl withDescription(String description) {
            chapter.description = description;
            return this;
        }

        @Override
        public ChapterBuilderImpl withTitle(String title) {
            chapter.title = title;
            return this;
        }

        @Override
        public ChapterBuilderImpl withNumberPages(Integer numberPages) {
            chapter.numberPages = numberPages;
            return this;
        }

        @Override
        public Chapter build() {
            return chapter;
        }
    }

}



