package visual.cryptography.technique.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class ImageEncDec {
	
	public static byte[] encryptFile(SecretKey secretKey, byte[] simage) {
        Cipher cipher;
        byte[] encrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            //encrypted = Base64.getEncoder().encode((cipher.doFinal(simage)));
            encrypted = cipher.doFinal(simage);
            

        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Error while encrypting: " + e.toString());
        }
        return encrypted;
    }
	
	public static byte[] decryptFile(SecretKey secretKey, byte[] seimage) {
        Cipher cipher;
        byte[] decrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //decrypted = cipher.doFinal(Base64.getDecoder().decode(seimage));
            decrypted = cipher.doFinal(seimage);
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Error while decrypting: " + e.toString());
        }
        return decrypted;
    }
}
