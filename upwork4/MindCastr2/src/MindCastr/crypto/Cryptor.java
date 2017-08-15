package MindCastr.crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Cryptor {

	public static void doEncrypt(String input, String output) {
		try {
                        String key = MindCastr.constants.Constants.CRYPTO_KEY;
			FileInputStream fis = new FileInputStream(input);
			FileOutputStream fos = new FileOutputStream(output);
			encrypt(key, fis, fos);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
        
        public static void doDecrypt(String input, String output){
		try {
			String key = MindCastr.constants.Constants.CRYPTO_KEY;
			FileInputStream fis2 = new FileInputStream(input);
			FileOutputStream fos2 = new FileOutputStream(output);
			decrypt(key, fis2, fos2);
		} catch (Throwable e) {
			e.printStackTrace();
		}

        }

	private static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	}

	private static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	}

	private static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES"); 

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	}

	private static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}

}