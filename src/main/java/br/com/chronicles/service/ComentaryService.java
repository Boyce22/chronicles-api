package br.com.chronicles.service;

import br.com.chronicles.interfaces.ComentaryServiceImpl;
import br.com.chronicles.model.entity.Comentary;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.response.ComentaryDetailsDTO;
import br.com.chronicles.repository.ComentaryRepository;
import org.springframework.stereotype.Service;

@Service
public class ComentaryService implements ComentaryServiceImpl {

    private final ComentaryRepository comentaryRepository;

    private final WorkService workService;

    private final ReaderService readerService;

    public ComentaryService(ComentaryRepository comentaryRepository, WorkService workService,
                            ReaderService readerService) {
        this.comentaryRepository = comentaryRepository;
        this.workService = workService;
        this.readerService = readerService;
    }

    @Override
    public ComentaryDetailsDTO create(String content, Long workId, Long readerId) {
        Work work = workService.findById(workId);
        Reader reader = readerService.findById(readerId);
        return new ComentaryDetailsDTO(comentaryRepository.save(Comentary.create().register(content, work, reader)));
    }
}
