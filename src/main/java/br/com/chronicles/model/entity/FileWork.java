package br.com.chronicles.model.entity;

import br.com.chronicles.buillders.FileWorkBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
@Entity(name = "file")
public class FileWork {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "file_cd_id")
    private Long id;

    @Column(name = "file_tx_name")
    private String name;

    @Lob
    @Column(name = "file_bytes_data")
    private byte[] data;

    public static FileWorkBuilder builder() {
        return new FileWorkBuilderImpl(new FileWork());
    }

    private record FileWorkBuilderImpl(FileWork fileWork) implements FileWorkBuilder {
        @Override
        public FileWorkBuilder withName(String name) {
            fileWork.name = name;
            return this;
        }

        @Override
        public FileWorkBuilder withData(byte[] data) {
            fileWork.data = data;
            return this;
        }

        @Override
        public FileWork build() {
            return fileWork;
        }
    }

}
