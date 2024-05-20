package br.com.chronicles.interfaces;

import java.util.List;

import br.com.chronicles.model.entity.WorkReaderRating;
import br.com.chronicles.model.request.WorkRatingDTO;
import br.com.chronicles.model.response.WorkRatingDetailsDTO;

public interface WorkRatingServiceImpl {

	WorkRatingDetailsDTO verifyIfExists(WorkRatingDTO dto);

	WorkReaderRating findById(Long id);

	List<Double> getRating(Long workId);

}
