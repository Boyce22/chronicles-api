package br.com.chronicles.exception;

public class FileUploadException extends RuntimeException {

	private static final long serialVersionUID = 6681868560968065805L;

	public FileUploadException(String message) {
		super(message);
	}

}
