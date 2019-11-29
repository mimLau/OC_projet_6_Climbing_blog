package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.UserDao;
import org.oc.escalade.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RegistrationForm  {

    private static final String USERNAME_FIELD = "username";
    private static final String EMAIL_FIELD = "email";
    private static final String PASS_FIELD = "password";
    private static final String PASS_CONF_FIELD = "passConf";
    private static final String FIRSTNAME_FIELD = "firstname";
    private static final String LASTNAME_FIELD = "lastname";

    private Map<String, String> erreurs = new HashMap<String, String>();
    private UserDao userDao;



    public Map<String, String> getErreurs(){
        return erreurs;
    }


    public User registerUser(HttpServletRequest req){
        String email = getFieldValue(req, EMAIL_FIELD );
        String username = getFieldValue(req, USERNAME_FIELD );
        String passsword = getFieldValue(req, PASS_FIELD );
        String passConf = getFieldValue(req, PASS_CONF_FIELD );
        String firstname = getFieldValue(req, FIRSTNAME_FIELD );
        String lastname = getFieldValue(req, LASTNAME_FIELD );


        User user = new User();

        try {
            emailValidation( email );
        } catch ( Exception e ) {
            setErreur( EMAIL_FIELD, e.getMessage() );
        }
        user.setEmail( email );

        try {
            usernameValidation( username );
        } catch ( Exception e ) {
            setErreur( USERNAME_FIELD, e.getMessage() );
        }
        user.setUsername(username);

        try {
            passValidation( passsword, passConf );
        } catch ( Exception e ) {
            setErreur( PASS_FIELD, e.getMessage() );
            setErreur( PASS_CONF_FIELD, null );
        }
        user.setPassword( passsword );

        try {
            firstnameValidation( firstname );
        } catch ( Exception e ) {
            setErreur( FIRSTNAME_FIELD, e.getMessage() );
        }
        user.setFirstname( firstname );

        try {
            lastnameValidation( lastname );
        } catch ( Exception e ) {
            setErreur( LASTNAME_FIELD, e.getMessage() );
        }
        user.setLastname( lastname );

        return user;
    }

    private static String getFieldValue(HttpServletRequest req, String field ){
        String fieldValue = req.getParameter(field);
        return field;
    }


    private void usernameValidation(String username) throws Exception {
        userDao = DaoFactory.getUserDao();
        User user = userDao.findUserByUsername(username);

        if ( username != null) {
            if ( username != user.getUsername() ) {
                throw new Exception( "Nom d'utilisateur est déjà pris." );
            } else {
                throw new Exception( "Saisissez votre prénom." );
            }
        }
    }

    private void emailValidation( String email ) throws Exception {
        if( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Adresse e-mail non valide." );
            }
        }else {
            throw new Exception( "Saisissez votre adresse e-mail." );
        }
    }

    private void passValidation( String password, String confPass ) throws Exception {
        if ( password != null) {
            if( confPass != null ) {
                if ( !password.equals( confPass ) ) {
                    throw new Exception( "Les mots de passe ne correspondent pas." );
                } else if ( password.length() < 3 ) {
                    throw new Exception( "Les mots de passe doivent contenir au moins 6 caractères." );
                }
            } else {
                 throw new Exception( "Saisissez à nouveau votre mot de passe." );
            }
        } throw new Exception( "Entrez votre mot de passe." );
    }

    private void lastnameValidation( String lastname ) throws Exception {
        if ( lastname != null) {
            if ( lastname.length() < 3 ) {
            throw new Exception( "Le prénom doit contenir au moins 3 caractères." );
        } else {
                throw new Exception( "Saisissez votre prénom." );
            }
        }
    }

    private void firstnameValidation(String firstname) throws Exception{
        if ( firstname != null && firstname.length() < 3 ) {
            throw new Exception( "Le nom doit contenir au moins 3 caractères." );
        } else {
               throw new Exception( "Saisissez votre nom de famille." );
        }
    }

    private void setErreur( String field, String message ) {
        erreurs.put( field, message );
    }
}
