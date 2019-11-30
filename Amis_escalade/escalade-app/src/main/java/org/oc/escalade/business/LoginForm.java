package org.oc.escalade.business;

import org.oc.escalade.consumer.UserDao;
import org.oc.escalade.model.User;

import javax.servlet.http.HttpServletRequest;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class LoginForm {

    private static final String USERNAME_FIELD = "username";
    private static final String EMAIL_FIELD = "email";
    private static final String PASS_FIELD = "password";

    private Map<String, String> errors = new HashMap<String, String>();
    private UserDao userDao;



    public User logUser(HttpServletRequest req) {
        String email = FormUtils.getFieldValue(req, EMAIL_FIELD );
        String username = FormUtils.getFieldValue(req, USERNAME_FIELD );
        String passsword = FormUtils.getFieldValue(req, PASS_FIELD );

        User user = new User();

        emailValidation( email );
        user.setEmail( email );

        user.setUsername(username);
        passValidation( passsword );

        return user;
    }

    private void emailValidation( String email ) {

    }

    private void passValidation( String password) {

    }


}
