package app;

import java.io.IOException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import sun.misc.BASE64Decoder;

public class EncryptedDataSource extends DriverManagerDataSource {

	@Override
	public String getPassword() {
		String password = super.getPassword();
		return decode(password);
	}

	/***
	 * Decode Password
	 */
	private String decode(String decode) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			decode = new String(decoder.decodeBuffer(decode));
			System.out.println("decode = " + decode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return decode;
	}

}