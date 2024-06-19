package br.com.chronicles.model.entity;

import br.com.chronicles.model.request.CollaboratorRegisterDTO;
import br.com.chronicles.model.request.CollaboratorUpdateDTO;
import br.com.chronicles.model.request.ReaderChangeRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "collaborator_dt_createAt")
    private LocalDate createdAt;

    @Column(name = "collaborator_dt_updateAt")
    private LocalDateTime updatedAt;

    @Column(name = "collaborator_dt_disable_date")
    private LocalDateTime disableDate;

    @Column(name = "collaborator_bl_is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "collaborator")
    private List<Work> work;

    @PrePersist
    void prePersist() {
        this.isActive = true;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static Collaborator create() {
        return new Collaborator();
    }

    public Collaborator registrar(CollaboratorRegisterDTO dto) {
        this.name = dto.name();
        this.lastName = dto.lastName();
        this.reference = dto.reference();
        this.cpf = dto.cpf();
        this.birthDate = dto.birthDate();
        return this;
    }

    public Collaborator update(CollaboratorUpdateDTO dto) {
        this.name = dto.name();
        this.lastName = dto.lastName();
        this.cpf = dto.cpf();
        this.birthDate = dto.birthDate();
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public Collaborator disable() {
        this.isActive = false;
        this.disableDate = LocalDateTime.now();
        return this;
    }

    public Collaborator active() {
        this.isActive = true;
        this.updatedAt = LocalDateTime.now();
        this.disableDate = null;
        return this;
    }

    public Collaborator grantAuthorAccessToReader(Reader reader, ReaderChangeRequestDTO dto) {
        this.name = reader.getName();
        this.lastName = reader.getLastName();
        this.birthDate = reader.getBirthDate();
        this.createdAt = reader.getCreatedAt();
        this.cpf = dto.cpf();
        return this;
    }

}
