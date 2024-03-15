package br.com.chronicles.interfaces;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import br.com.chronicles.model.response.DefaultResponse;

public interface FileServiceImpl {

	DefaultResponse save(MultipartFile dto) throws FileUploadException;

}
