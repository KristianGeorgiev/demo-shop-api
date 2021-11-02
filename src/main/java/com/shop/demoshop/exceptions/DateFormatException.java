package com.shop.demoshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Wrong date format")
public class DateFormatException extends RuntimeException{
}
