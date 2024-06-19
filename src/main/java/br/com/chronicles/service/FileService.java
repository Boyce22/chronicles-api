package br.com.chronicles.service;

import br.com.chronicles.interfaces.FileServiceImpl;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.repository.FileRepository;
import com.itextpdf.text.pdf.PdfReader;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    private FileWork findById(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Arquivo não encontrado com o ID: " + id));
    }

    private Integer countNumberChapters(MultipartFile file) throws IOException {
        PdfReader reader = new PdfReader(file.getInputStream());
        return reader.getNumberOfPages();
    }

}