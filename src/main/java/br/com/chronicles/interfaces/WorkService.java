package br.com.chronicles.interfaces;

import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.request.WorkCreateDTO;
import br.com.chronicles.model.response.WorkDetailsDTO;
import br.com.chronicles.model.response.WorkNonWithChapters;
import br.com.chronicles.model.response.WorkRegisterDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface WorkService {

    WorkRegisterDetails create(WorkCreateDTO dto, MultipartFile pdf, MultipartFile cover) throws IOException;

    Work findById(Long id);

    WorkDetailsDTO findWorkDetailsById(Long id);

    List<WorkNonWithChapters> findAll();
}