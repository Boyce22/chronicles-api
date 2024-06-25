package br.com.chronicles.model.entity;

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

    public static Chapter create() {
        return new Chapter();
    }

    public Chapter register(FileWork file, Integer numberPages, String description, String title) {
        this.file = file;
        this.description = description;
        this.title = title;
        this.numberPages = numberPages;
        return this;
    }

}



