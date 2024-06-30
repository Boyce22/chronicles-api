package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.CommentaryBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commentary")
@Entity(name = "commentary")
public class Commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "com_tx_content")
    private String content;

    @CreationTimestamp
    @Column(name = "com_dt_createdAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "com_dt_updatedAt")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "fk_work_cd_id")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "fk_reader_cd_id")
    private Reader reader;

    public static CommentaryBuilder builder() {
        return new CommentaryBuilderImpl(new Commentary());
    }

    private record CommentaryBuilderImpl(Commentary commentary) implements CommentaryBuilder {

        @Override
        public CommentaryBuilder withContent(String content) {
            commentary.content = content;
            return this;
        }

        @Override
        public CommentaryBuilder withWork(Work work) {
            commentary.work = work;
            return this;
        }

        @Override
        public CommentaryBuilder withReader(Reader reader) {
            commentary.reader = reader;
            return this;
        }

        @Override
        public Commentary build() {
            return commentary;
        }
    }
}
