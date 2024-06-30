package br.com.chronicles.service;

import br.com.chronicles.interfaces.ChapterService;
import br.com.chronicles.model.entity.Chapter;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.repository.ChapterRepository;
import com.itextpdf.text.pdf.PdfReader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    public ChapterServiceImpl(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter save(FileWork fileWork, String title, String description) throws IOException {
        return chapterRepository.save(Chapter
                .builder()
                .withTitle(title)
                .withDescription(description)
                .withFile(fileWork)
                .withNumberPages(countNumberPages(fileWork.getData()))
                .build()
        );
    }

    private Integer countNumberPages(byte[] file) throws IOException {
        PdfReader reader = new PdfReader(file);
        return reader.getNumberOfPages();
    }
}
