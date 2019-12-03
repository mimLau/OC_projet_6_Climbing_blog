package org.oc.escalade.business;

import org.oc.escalade.consumer.DaoFactory;
import org.oc.escalade.consumer.UserDao;
import org.oc.escalade.model.User;
import org.oc.escalade.utils.HashGenerator;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class LoginForm {

    private static final String IDENTIFIER_FIELD = "identifier";
    private static final String PASS_FIELD = "password";
    private static final String AUTH_MESS = "authMess";

    private Map<String, String> errors = new HashMap<String, String>();
    private UserDao userDao = DaoFactory.getUserDao();

    public Map<String, String> getErrors() {
        return errors;
    }

    public User logUser(HttpServletRequest req) {
        String identifier = getFieldValue(req, IDENTIFIER_FIELD );
        String passsword = getFieldValue(req, PASS_FIELD );
        User user = new User();
        boolean authenticationOk = false;
        user = retrieveUserByIdentifier(identifier);
        authenticationOk = authentication(user, passsword);

        if( authenticationOk == false ) {
            setError(AUTH_MESS, "Combinaison identifiant/mot de passe invalide.");
        }

        return user;
    }

    private User retrieveUserByIdentifier( String identifier ) {
            User user = new User();
        if( identifier.contains("@")) {
            try {
                user = userDao.findUserByEmail(identifier);
            } catch (NoResultException e) {
                setError(IDENTIFIER_FIELD, "Adresse e-mail non existante.");
                System.out.println("NoResultException email");
            }
        } else {
            try {
                user = userDao.findUserByUsername(identifier);
                System.out.println("finUserByEmail");
            } catch (NoResultException e) {
                setError(IDENTIFIER_FIELD, "Nom d'utilisateur non reconnu.");
            }
        }
        return user;
    }

    private boolean authentication( User user, String password ) {
        boolean authenticationOk = false;
        String retrievedPass = user.getPassword();
        if( HashGenerator.cryptoMD5( password ).equals( retrievedPass ) ) {
            authenticationOk = true;
        }
        return authenticationOk;
    }

    protected final static String getFieldValue( HttpServletRequest req, String field ){
        String fieldValue = req.getParameter( field );
        return fieldValue;
    }

    private void setError( String field, String message ) {
        errors.put( field, message );
    }
}
