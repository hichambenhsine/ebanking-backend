package org.glsid.ebankingbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.glsid.ebankingbackend.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCustomerNotFound(CustomerNotFoundException ex, WebRequest request) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleBankAccountNotFound(BankAccountNotFoundException ex, WebRequest request) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BalanceNotSufficientException.class)
    public ResponseEntity<ExceptionResponseDTO> handleBalanceNotSufficient(BalanceNotSufficientException ex, WebRequest request) {
        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<ExceptionResponseDTO> buildResponse(String message, HttpStatus status, WebRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                message,
                request.getDescription(false).replace("uri=", ""),
                new Date()
        );
        return new ResponseEntity<>(response, status);
    }
}