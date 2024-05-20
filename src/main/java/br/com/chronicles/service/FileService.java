package br.com.chronicles.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.PdfReader;

import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.repository.FileRepository;

@Service
public class FileService implements FileServiceImpl {

	private final FileRepository fileRepository;

	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	public FileWork save(MultipartFile file) throws IOException {
		return fileRepository.save(FileWork.create().register(file, countNumberChapters(file)));
	}

	private Integer countNumberChapters(MultipartFile file) throws IOException {
		PdfReader reader = new PdfReader(file.getInputStream());
		return reader.getNumberOfPages();
	}

}