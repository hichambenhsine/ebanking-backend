package org.glsid.ebankingbackend.dto;

import java.util.Date;

public record ExceptionResponseDTO(String message, String details, Date timestamp) {}
