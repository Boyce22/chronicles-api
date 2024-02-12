package br.com.chronicles.api.security.entity;

import java.util.HashSet;
import java.util.Set;

import br.com.chronicles.api.entity.Author;
import br.com.chronicles.api.entity.Reader;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity(name = "users")
public class User {
	
    @Id
    @Column(name = "user_cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "user_tx_email", nullable = false)
    private String email;

    @Column(name = "user_tx_password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_cd_id"), inverseJoinColumns = @JoinColumn(name = "role_cd_id"))
    private Set<Role> roles = new HashSet<>();
    
    @OneToOne
    @JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
    private Reader reader;
    
    @OneToOne
    @JoinColumn(name = "fk_author_cd_id", referencedColumnName = "author_cd_id")
    private Author author;

}
