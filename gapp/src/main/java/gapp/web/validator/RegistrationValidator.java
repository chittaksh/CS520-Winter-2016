package gapp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import gapp.model.User;

@Component
public class RegistrationValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strEmail", "user.username.empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strPassword", "user.password.empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strFName", "user.firstname.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strLName", "user.lastname.empty");
	}

}
