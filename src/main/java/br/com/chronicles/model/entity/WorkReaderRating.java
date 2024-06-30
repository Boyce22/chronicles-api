package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.WorkReaderRatingBuilder;
import br.com.chronicles.model.request.WorkRatingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_reader_rating")
@Entity(name = "work_reader_rating")
public class WorkReaderRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_reader_rating_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "fk_work_cd_id", referencedColumnName = "work_cd_id")
    private Work work;

    @Column(name = "work_rating")
    private Double rating;

    public WorkReaderRating update(WorkRatingDTO dto, Reader reader, Work work) {
        this.rating = dto.rating();
        this.reader = reader;
        this.work = work;
        return this;
    }

    public static WorkReaderRatingBuilder build() {
        return new WorkReaderRatingImpl(new WorkReaderRating());
    }

    private record WorkReaderRatingImpl(WorkReaderRating workReaderRating) implements WorkReaderRatingBuilder {

        @Override
        public WorkReaderRatingBuilder withRating(Double rating) {
            workReaderRating.rating = rating;
            return this;
        }

        @Override
        public WorkReaderRatingBuilder withReader(Reader reader) {
            workReaderRating.reader = reader;
            return this;
        }

        @Override
        public WorkReaderRatingBuilder withWork(Work work) {
            workReaderRating.work = work;
            return this;
        }

        @Override
        public WorkReaderRating build() {
            return workReaderRating;
        }
    }

}
