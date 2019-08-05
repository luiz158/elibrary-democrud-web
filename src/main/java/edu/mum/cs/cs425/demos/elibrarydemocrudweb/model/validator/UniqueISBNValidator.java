package edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.BookService;

public class UniqueISBNValidator implements ConstraintValidator<UniqueISBN, String> {
	private BookService bookService;

	public UniqueISBNValidator() {
	}

	@Autowired
	public UniqueISBNValidator(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void initialize(UniqueISBN constraintAnnotation) {
	}

	@Override
	public boolean isValid(String isbn, ConstraintValidatorContext context) {
		boolean valid;
		if (bookService != null) {
			valid = (isbn != null && !bookService.findByISBN(isbn).isPresent());
		} else {
			valid = true;
		}
		return valid;
	}

}
