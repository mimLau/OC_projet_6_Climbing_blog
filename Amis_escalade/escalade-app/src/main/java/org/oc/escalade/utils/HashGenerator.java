package org.oc.escalade.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    public final static String cryptoMD5(String cryptoText) {
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
