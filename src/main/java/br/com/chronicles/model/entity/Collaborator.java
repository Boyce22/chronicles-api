package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.CollaboratorBuilder;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "collaborator")
@Entity(name = "collaborator")
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collaborator_cd_id")
    private Long id;

    @Column(name = "collaborator_tx_name")
    private String name;

    @Column(name = "collaborator_tx_lastName")
    private String lastName;

    @Column(name = "collaborator_tx_reference")
    private String reference;

    @Column(name = "collaborator_tx_cpf")
    private String cpf;

    @Column(name = "collaborator_tx_email")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "collaborator_dt_birth_data")
    private LocalDate birthDate;

    @CreationTimestamp
    @Column(name = "collaborator_dt_createAt")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "collaborator_dt_updateAt")
    private LocalDateTime updatedAt;

    @Column(name = "collaborator_dt_disable_date")
    private LocalDateTime disableDate;

    @Column(name = "collaborator_bl_is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "collaborator")
    private List<Work> work;

    public static CollaboratorBuilder builder() {
        return new CollaboratorBuilderImpl(new Collaborator());
    }


    public static CollaboratorBuilder update(Collaborator collaborator) {
        return new CollaboratorBuilderImpl(collaborator);
    }

    private record CollaboratorBuilderImpl(Collaborator collaborator) implements CollaboratorBuilder {

        @Override
        public CollaboratorBuilder withName(String name) {
            collaborator.name = name;
            return this;
        }

        @Override
        public CollaboratorBuilder withLastName(String lastName) {
            collaborator.lastName = lastName;
            return this;
        }

        @Override
        public CollaboratorBuilder withReference(String reference) {
            collaborator.reference = reference;
            return this;
        }

        @Override
        public CollaboratorBuilder withCpf(String cpf) {
            collaborator.cpf = cpf;
            return this;
        }

        @Override
        public CollaboratorBuilder withEmail(String email) {
            collaborator.email = email;
            return this;
        }

        @Override
        public CollaboratorBuilder withBirthDate(LocalDate birthDate) {
            collaborator.birthDate = birthDate;
            return this;
        }

        @Override
        public CollaboratorBuilder disable() {
            collaborator.isActive = false;
            collaborator.disableDate = LocalDateTime.now();
            return this;
        }

        @Override
        public CollaboratorBuilder active() {
            collaborator.isActive = true;
            collaborator.disableDate = null;
            return this;
        }

        @Override
        public Collaborator build() {
            return collaborator;
        }
    }
}
