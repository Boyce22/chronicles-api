package br.com.chronicles.interfaces;

import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.model.response.DefaultResponse;

public interface FileServiceImpl {

	DefaultResponse save(MultipartFile dto);

}
