package br.com.chronicles.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

	@ExceptionHandler(FileUploadException.class)
	public ResponseEntity<ErrorResponse> fileUploadException(FileUploadException exception) {
		String error = "Error when trying to save the PDF.";
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
				.body(new ErrorResponse(error, exception.getMessage(), formatTime(LocalDateTime.now())));
	}

	private static String formatTime(LocalDateTime time) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
				.withResolverStyle(ResolverStyle.STRICT);

		return time.format(dateTimeFormatter);
	}

	private record ErrorResponse(String erro, String message, String time) {

	}
}
