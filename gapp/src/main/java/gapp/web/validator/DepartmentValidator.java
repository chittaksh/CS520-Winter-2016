package gapp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import gapp.model.Department;

@Component
public class DepartmentValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz)
	{
		return Department.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmpty(errors, "strDepartment", "department.name.empty");
	}
}
