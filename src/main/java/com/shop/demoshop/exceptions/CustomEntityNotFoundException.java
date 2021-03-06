package com.shop.demoshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason="Entity not found")
public class CustomEntityNotFoundException extends RuntimeException {
}
