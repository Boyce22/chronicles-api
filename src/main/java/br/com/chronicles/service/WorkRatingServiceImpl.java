package br.com.chronicles.service;

import java.util.List;

import br.com.chronicles.interfaces.WorkRatingService;
import org.springframework.stereotype.Service;

import br.com.chronicles.interfaces.ReaderService;
import br.com.chronicles.interfaces.WorkService;
import br.com.chronicles.model.entity.Reader;
import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.entity.WorkReaderRating;
import br.com.chronicles.model.request.WorkRatingDTO;
import br.com.chronicles.model.response.WorkRatingDetailsDTO;
import br.com.chronicles.repository.WorkReaderRatingRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkRatingServiceImpl implements WorkRatingService {

	private final WorkReaderRatingRepository ratingRepository;

	private final ReaderService readerService;

	private final WorkService workService;

	public WorkRatingServiceImpl(WorkReaderRatingRepository ratingRepository, ReaderService readerService,
								 WorkService workService) {
		this.ratingRepository = ratingRepository;
		this.readerService = readerService;
		this.workService = workService;
	}

	@Override
	public WorkRatingDetailsDTO verifyIfExistsAndRateWork(WorkRatingDTO dto) {
		Long workReaderRatingId = ratingRepository.existsByReaderId(dto.readerId());
		return workReaderRatingId != null ? updateRating(dto, workReaderRatingId) : createRating(dto);
	}

	@Override
	public List<Double> getRating(Long workId) {
		return ratingRepository.getRating(workId);
	}

	private WorkRatingDetailsDTO createRating(WorkRatingDTO dto) {
		Reader reader = readerService.findById(dto.readerId());
		Work work = workService.findById(dto.workId());
		return new WorkRatingDetailsDTO(ratingRepository.save(WorkReaderRating.create().register(dto, reader, work)));
	}

	private WorkRatingDetailsDTO updateRating(WorkRatingDTO dto, Long id) {
		Reader reader = readerService.findById(dto.readerId());
		Work work = workService.findById(dto.workId());
		return new WorkRatingDetailsDTO(ratingRepository.save(findById(id).update(dto, reader, work)));
	}

	@Override
	public WorkReaderRating findById(Long id) {
		return ratingRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Rating not found with ID: " + id));
	}

}
