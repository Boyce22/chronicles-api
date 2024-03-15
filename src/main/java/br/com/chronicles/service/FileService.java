package br.com.chronicles.service;

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
	public DefaultResponse save(MultipartFile file) {
		try {
			fileRepository.save(new File().create(file));
			return new DefaultResponse("Arquivo salvo com sucesso!");
		} catch (Exception e) {
			return new DefaultResponse("Erro ao salvar o arquivo! Motivo" + e.getCause());
		}
	}

}
