package web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import service.auth.AuthService;
import service.auth.AuthServiceFactory;

@Component
public class UsersValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UsersForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	UsersForm form = (UsersForm) target;

    	// 認証
    	AuthService authService = AuthServiceFactory.getInstance();
    	if(!authService.authentication(form.getUserid(), form.getPassword())) {
    		// 認証NG
            // メッセージを埋め込み
	        errors.rejectValue("userid", "UsersValidator.authenticationFailed", "ユーザIDまたはパスワードに誤りがあります");
    	}
    }
}