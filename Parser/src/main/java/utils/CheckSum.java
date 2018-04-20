package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

@SuppressWarnings("restriction")
public class CheckSum {

	public static String calculateMD5(File file){
		byte[] b = null;
		byte[] hash = null;
		try {
			b = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
			hash = MessageDigest.getInstance("MD5").digest(b);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return DatatypeConverter.printHexBinary(hash).toLowerCase();
	}

}
