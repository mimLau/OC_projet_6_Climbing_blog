package org.oc.escalade.business;

import org.oc.escalade.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RegistrationForm  {

    private static final String USERNAME_FIELD = "username";
    private static final String EMAIL_FIELD = "email";
    private static final String PASS_FIELD = "password";
    private static final String CONF_PASS_FIELD = "confPass";
    private static final String FIRSTNAME_FIELD = "firstname";
    private static final String LASTNAME_FIELD = "lastname";

    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs(){
        return erreurs;
    }


    public User registerUser(HttpServletRequest req){
        String email = getFieldValue(req, EMAIL_FIELD );
        String username = getFieldValue(req, USERNAME_FIELD );
        String passsword = getFieldValue(req, PASS_FIELD );
        String confPass = getFieldValue(req, CONF_PASS_FIELD );
        String firstname = getFieldValue(req, FIRSTNAME_FIELD );
        String lastname = getFieldValue(req, LASTNAME_FIELD );


        User user = new User();


        return user;
    }

    private static String getFieldValue(HttpServletRequest req, String field ){
        String fieldValue = req.getParameter(field);
        return field;
    }

    private void emailValidation(String email){

    }
}
