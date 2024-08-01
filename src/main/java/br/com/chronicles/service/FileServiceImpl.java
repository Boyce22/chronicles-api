package br.com.chronicles.service;

import br.com.chronicles.interfaces.FileService;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.repository.FileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public FileWork save(MultipartFile file) throws IOException {
        FileWork fileWork = FileWork
                .builder()
                .withData(file.getBytes())
                .withName(file.getOriginalFilename())
                .build();

        return fileRepository.save(fileWork);
    }

    private FileWork findById(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Arquivo não encontrado com o ID: %d".formatted(id)));
    }

}