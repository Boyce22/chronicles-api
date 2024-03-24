package br.com.chronicles.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.interfaces.ReaderServiceImpl;
import br.com.chronicles.interfaces.WorkServiceImpl;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.entity.WorkReaderRating;
import br.com.chronicles.model.request.WorkRating;
import br.com.chronicles.repository.WorkReaderRatingRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkReaderRatingService {

	private final WorkReaderRatingRepository ratingRepository;

	private final ReaderServiceImpl readerService;

	private final WorkServiceImpl workService;

	public WorkReaderRatingService(WorkReaderRatingRepository ratingRepository, ReaderServiceImpl readerService,
			WorkServiceImpl workService) {
		this.ratingRepository = ratingRepository;
		this.readerService = readerService;
		this.workService = workService;
	}

	public WorkReaderRating verifyIfExists(WorkRating dto) {
		Long workReaderRatingId = ratingRepository.existsByAuthorId(dto.authorId());
		return workReaderRatingId != null ? updateRating(dto, workReaderRatingId) : createRating(dto);
	}

	private WorkReaderRating createRating(WorkRating dto) {
		Reader reader = readerService.findById(dto.authorId());
		Work work = workService.findById(dto.workId());
		return ratingRepository.save(WorkReaderRating.create(dto, reader, work));
	}

	private WorkReaderRating updateRating(WorkRating dto, Long id) {
		Reader reader = readerService.findById(dto.authorId());
		Work work = workService.findById(dto.workId());
		return ratingRepository.save(findById(id).update(dto, reader, work));
	}

	public WorkReaderRating findById(Long id) {
		return ratingRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Rating not found with ID: " + id));
	}

}
