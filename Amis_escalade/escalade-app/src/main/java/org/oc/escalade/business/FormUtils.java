package org.oc.escalade.business;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class FormUtils {
    private static Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    protected final static String getFieldValue( HttpServletRequest req, String field ){
        String fieldValue = req.getParameter( field );
        return fieldValue;
    }

    public final static void setError( String field, String message ) {
        errors.put( field, message );
    }

    protected final static String cryptoMD5( String cryptoText ) {
        byte[] defaultBytes = null;
        defaultBytes = cryptoText.getBytes();

        try{
            MessageDigest algorithm = MessageDigest.getInstance( "MD5" );
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<messageDigest.length;i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            cryptoText = hexString.toString();

        }catch( NoSuchAlgorithmException nsae ){

        }
        return cryptoText;
    }
}
