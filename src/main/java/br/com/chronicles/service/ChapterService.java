package br.com.chronicles.service;

import br.com.chronicles.interfaces.ChapterServiceImpl;
import br.com.chronicles.model.entity.Chapter;
import br.com.chronicles.model.entity.FileWork;
import br.com.chronicles.repository.ChapterRepository;
import com.itextpdf.text.pdf.PdfReader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChapterService implements ChapterServiceImpl {

    private final ChapterRepository chapterRepository;

    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter save(FileWork fileWork, String title, String description) throws IOException {
        return chapterRepository.save(Chapter.create().register(fileWork, countNumberPages(fileWork.getData()), description, title));
    }

    private Integer countNumberPages(byte[] file) throws IOException {
        PdfReader reader = new PdfReader(file);
        return reader.getNumberOfPages();
    }
}
