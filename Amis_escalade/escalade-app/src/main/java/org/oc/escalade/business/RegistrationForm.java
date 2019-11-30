package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.UserDao;
import org.oc.escalade.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class RegistrationForm  {

    private static final String USERNAME_FIELD = "username";
    private static final String EMAIL_FIELD = "email";
    private static final String PASS_FIELD = "password";
    private static final String PASS_CONF_FIELD = "passConf";
    private static final String FIRSTNAME_FIELD = "firstname";
    private static final String LASTNAME_FIELD = "lastname";

    private Map<String, String> errors = new HashMap<String, String>();
    private UserDao userDao;

    public Map<String, String> getErrors(){
        return errors;
    }

    public User registerUser(HttpServletRequest req){
        String email = getFieldValue(req, EMAIL_FIELD );
        String username = getFieldValue(req, USERNAME_FIELD );
        String passsword = getFieldValue(req, PASS_FIELD );
        String passConf = getFieldValue(req, PASS_CONF_FIELD );
        String firstname = getFieldValue(req, FIRSTNAME_FIELD );
        String lastname = getFieldValue(req, LASTNAME_FIELD );

        User user = new User();
        emailValidation( email );
        user.setEmail( email );
        usernameValidation( username );
        user.setUsername(username);
        passValidation( passsword, passConf );
        user.setPassword( passsword );
        firstnameValidation( firstname );
        user.setFirstname( firstname );
        lastnameValidation( lastname );
        user.setLastname( lastname );

        return user;
    }

    private static String getFieldValue(HttpServletRequest req, String field ){
        String fieldValue = req.getParameter(field);
        return fieldValue;
    }


    private void usernameValidation(String username) {
        userDao = DaoFactory.getUserDao();
        boolean usernameExists = userDao.usernameExists(username);

        if ( !username.isEmpty()) {
            if ( usernameExists == true ) {
                setError(USERNAME_FIELD, "Nom d'utilisateur est déjà pris.");
                //throw new Exception( "Nom d'utilisateur est déjà pris." );
            }
        } else {
            //throw new Exception("Saisissez votre nom d'utilisateur.");
            setError(USERNAME_FIELD, "Saisissez votre nom d'utilisateur.");
        }
    }

    private void emailValidation( String email ) {
        if( !email.isEmpty()) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                //throw new Exception( "Adresse e-mail non valide." );
                setError(EMAIL_FIELD, "Adresse e-mail non valide.");
            }
        }else {
            //throw new Exception( "Saisissez votre adresse e-mail." );
            setError(EMAIL_FIELD, "Saisissez votre adresse e-mail.");
        }
    }

    private void passValidation( String password, String confPass ) {
        if ( !password.isEmpty()) {
            if( !confPass.isEmpty() ) {
                if ( !password.equals( confPass ) ) {
                    //throw new Exception( "Les mots de passe ne correspondent pas." );
                    setError(PASS_FIELD, "Les mots de passe ne correspondent pas.");
                } else if ( password.length() < 3 ) {
                    //throw new Exception( "Les mots de passe doivent contenir au moins 6 caractères." );
                    setError(PASS_FIELD, "Les mots de passe doivent contenir au moins 6 caractères.");
                }
            } else {
                 //throw new Exception( "Saisissez à nouveau votre mot de passe." );
                setError(PASS_CONF_FIELD, "Saisissez à nouveau votre mot de passe.");
            }
        } //throw new Exception( "Entrez votre mot de passe." );
            setError(PASS_FIELD, "Entrez votre mot de passe.");
    }

    private void lastnameValidation( String lastname ) {
        if ( !lastname.isEmpty()) {
            if ( lastname.length() < 3 ) {
            //throw new Exception( "Le prénom doit contenir au moins 3 caractères." );
                setError(LASTNAME_FIELD, "Le prénom doit contenir au moins 3 caractères.");
             }
        } else {
                //throw new Exception( "Saisissez votre prénom." );
            setError(LASTNAME_FIELD, "Saisissez votre prénom.");
        }
    }

    private void firstnameValidation(String firstname) {
        if ( !firstname.isEmpty()) {
            if(firstname.length() < 3 ) {
            //throw new Exception( "Le nom doit contenir au moins 3 caractères." );
                setError(FIRSTNAME_FIELD, "Le nom doit contenir au moins 3 caractères.");
            }
        } else {
            //throw new Exception("Saisissez votre nom.");
            setError(FIRSTNAME_FIELD, "Saisissez votre nom.");
        }
    }

    private void setError( String field, String message ) {
        errors.put( field, message );
    }
}
