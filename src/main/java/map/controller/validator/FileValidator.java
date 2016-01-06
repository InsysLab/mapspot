package map.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import map.domain.FileUpload;

/*
 * @author Mark Pit
 */
public class FileValidator implements Validator {
	public boolean supports(Class<?> paramClass) {
		return FileUpload.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		FileUpload file = (FileUpload) obj;

		String type = file.getFile().getContentType();
	    	type = type.split("/")[0];
        	if( ! type.equals("image") || file.getFile().getSize() == 0 ){
        		errors.rejectValue("file", "valid.file");
        	}
	}
}
