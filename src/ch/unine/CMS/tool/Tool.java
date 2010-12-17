package ch.unine.CMS.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Tool {
	/**
	 * Fonction de hashage en SHA-256
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String SHA2(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		byte[] hash;
		md.update(text.getBytes("UTF-8"), 0, text.length());
		hash = md.digest();
		BASE64Encoder encoder = new BASE64Encoder(); 
		return encoder.encode(hash);
		//return hash.toString();
    }
}
