package br.com.chronicles.model.entity;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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

	@Column(name = "file_nm_chapters")
	private Integer numberChapters;

	public static FileWork create() {
		return new FileWork();
	}

	public FileWork register(MultipartFile file, Integer numberChapters) throws IOException {
		this.name = file.getOriginalFilename();
		this.data = file.getBytes();
		this.numberChapters = numberChapters;
		return this;
	}

}
