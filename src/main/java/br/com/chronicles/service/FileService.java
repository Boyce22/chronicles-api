package br.com.chronicles.service;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.model.entity.File;
import br.com.chronicles.model.response.DefaultResponse;
import br.com.chronicles.repository.FileRepository;

@Service
public class FileService implements FileServiceImpl {

	private final FileRepository fileRepository;

	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	public DefaultResponse save(MultipartFile file) throws FileUploadException {
		try {
			fileRepository.save(new File().create(file));
			return new DefaultResponse("Arquivo salvo com sucesso!");
		} catch (Exception e) {
			throw new FileUploadException("Erro ao salvar o arquivo! Motivo");
		}
	}

}
