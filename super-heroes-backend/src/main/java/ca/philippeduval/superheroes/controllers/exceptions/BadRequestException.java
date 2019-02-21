package ca.philippeduval.superheroes.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BadRequestException
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@SuppressWarnings("serial")
public class BadRequestException extends Exception{

}