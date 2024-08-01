package br.com.chronicles.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "genre_cd_id::uuid")
    protected UUID id;

    @Column(name = "genre_tx_name")
    protected String name;

    @Column(name = "genre_tx_description")
    protected String description;

    @Column(name = "genre_bl_is_active")
    protected boolean isActive;

    @Column(name = "genre_bl_is_mature")
    protected boolean isMature;

    @Column(name = "dt_createdAt")
    protected LocalDate createdAt;

    @Column(name = "dt_updatedAt")
    protected LocalDateTime updatedAt;

    @Column(name = "dt_disabled_date")
    protected LocalDateTime disableDate;

}
