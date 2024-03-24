package br.com.chronicles.interfaces;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;

public interface WorkServiceImpl {

	WorkDetailsDTO create(WorkCreateDTO dto, MultipartFile pdf) throws IOException;

	Work findById(Long id);

}