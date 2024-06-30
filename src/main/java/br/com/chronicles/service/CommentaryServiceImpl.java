package br.com.chronicles.service;

import br.com.chronicles.interfaces.CommentaryService;
import br.com.chronicles.interfaces.WorkService;
import br.com.chronicles.model.entity.Commentary;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.response.CommentaryDetailsDTO;
import br.com.chronicles.repository.CommentaryRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentaryServiceImpl implements CommentaryService {

    private final CommentaryRepository commentaryRepository;

    private final WorkService workService;

    private final ReaderServiceImpl readerService;

    public CommentaryServiceImpl(CommentaryRepository commentaryRepository, WorkService workService,
                                 ReaderServiceImpl readerService) {
        this.commentaryRepository = commentaryRepository;
        this.workService = workService;
        this.readerService = readerService;
    }

    @Override
    public CommentaryDetailsDTO create(String content, Long workId, Long readerId) {
        Work work = workService.findById(workId);
        Reader reader = readerService.findById(readerId);

        return new CommentaryDetailsDTO(commentaryRepository.save(Commentary
                .builder()
                .withContent(content)
                .withReader(reader)
                .withWork(work)
                .build()
        ));
    }
}
