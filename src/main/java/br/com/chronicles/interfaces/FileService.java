package br.com.chronicles.interfaces;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.model.entity.FileWork;

public interface FileService {

	FileWork save(MultipartFile dto) throws IOException;

}
