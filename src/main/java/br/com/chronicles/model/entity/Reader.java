package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.ReaderBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reader")
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_cd_id")
    private Long id;

    @Column(name = "reader_tx_name")
    private String name;

    @Column(name = "reader_tx_lastName")
    private String lastName;

    @Column(name = "reader_tx_email")
    private String email;

    @Column(name = "reader_dt_birth_date")
    private LocalDate birthDate;

    @CreationTimestamp
    @Column(name = "reader_dt_createAt")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "reader_dt_updateAt")
    private LocalDateTime updatedAt;

    @Column(name = "reader_dt_disabledAt")
    private LocalDateTime disabledAt;

    @Column(name = "reader_dt_deletedAt")
    private LocalDateTime deletedAt;

    @Column(name = "reader_bl_is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToMany(mappedBy = "reader")
    private List<Commentary> comments;

    public static ReaderBuilder builder() {
        return new ReaderBuilderImpl(new Reader());
    }

    public static ReaderBuilder update(Reader reader) {
        return new ReaderBuilderImpl(reader);
    }

    private record ReaderBuilderImpl(Reader reader) implements ReaderBuilder {

        @Override
        public ReaderBuilder withName(String name) {
            reader.name = name;
            return this;
        }

        @Override
        public ReaderBuilder withLastName(String lastName) {
            reader.lastName = lastName;
            return this;
        }

        @Override
        public ReaderBuilder withEmail(String email) {
            reader.email = email;
            return this;
        }

        @Override
        public ReaderBuilder withBirthDate(LocalDate birthDate) {
            reader.birthDate = birthDate;
            return this;
        }

        @Override
        public ReaderBuilder active() {
            reader.isActive = true;
            reader.disabledAt = null;
            return this;
        }

        @Override
        public ReaderBuilder disable() {
            reader.isActive = false;
            reader.disabledAt = LocalDateTime.now();
            return this;
        }

        @Override
        public Reader build() {
            return reader;
        }
    }

}
