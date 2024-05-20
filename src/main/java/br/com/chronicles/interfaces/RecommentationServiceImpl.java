package br.com.chronicles.interfaces;

import java.util.List;

public interface RecommentationServiceImpl {

	void associateRecommendation(List<String> genres, Long readerId);

}
