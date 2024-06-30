package br.com.chronicles.interfaces;

import java.util.List;

public interface RecommentationService {

	void associateRecommendation(List<String> genres, Long readerId);

}
