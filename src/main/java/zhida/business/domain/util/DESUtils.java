package zhida.business.domain.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 3DES加密工具类
 */
public class DESUtils {
	
	/**
	 * 加密
	 * @param inStr 需要加密的内容
	 * @param secretKey 密钥
	 * @return 加密后的数据
	 */
	public static String encrypt(String inStr, String secretKey) {
		SecretKey deskey = new SecretKeySpec(secretKey.getBytes(), "DESede");
		Cipher cipher;
		String outStr = null;
		try {
			cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, deskey);
			outStr = byte2hex(cipher.doFinal(inStr.getBytes()));
		} catch (Exception e) {
			outStr = "default";
			System.err.println("3DES加密失败！加密内容[" + inStr + "]");
			e.printStackTrace();
		}
		return outStr;
	}
	
	/**
	 * 解密
	 * @param inStr 需要解密的内容
	 * @param secretKey 密钥
	 * @return 解密后的数据
	 */
	public static String decrypt(String inStr, String secretKey) {
		SecretKey deskey = new SecretKeySpec(secretKey.getBytes(), "DESede");
		Cipher cipher;
		String outStr = null;
		try {
			cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, deskey);
			outStr = new String(cipher.doFinal(hex2byte(inStr)));
		} catch (Exception e) {
			outStr = "default";
			System.err.println("3DES解密失败！解密内容[" + inStr + "]");
			e.printStackTrace();
		}
		return outStr;
	}
	
	/**
	 * 转化为16进制字符串方法
	 * @param digest 需要转换的字节组
	 * @return 转换后的字符串
	 */
	public static String byte2hex(byte[] digest) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < digest.length; n++) {
			stmp = Integer.toHexString(digest[n] & 0XFF);
			if (stmp.length() == 1) {
				hs.append("0" + stmp);
			} else {
				hs.append(stmp);
			}
		}
		return hs.toString().toUpperCase();
	}
	
	/**
	 * 十六进转二进制
	 * @param hexStr 待转换16进制字符串
	 * @return 二进制字节组
	 */
	public static byte[] hex2byte(String hexStr){
		if (hexStr == null)
			return null;
		hexStr = hexStr.trim();
		int len = hexStr.length();
		if (len == 0 || len % 2 == 1)
			return null;
		byte[] digest = new byte[len / 2];
		try {
			for (int i = 0; i < hexStr.length(); i += 2) {
				digest[i / 2] = (byte) Integer.decode("0x" + hexStr.substring(i, i + 2)).intValue();
			}
			return digest;
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		// 加解密得key最后一位改成9能解。。。别的不行
		System.out.println("12321317398173913");
		System.out.println(encrypt("12321317398173913","123456781234567812345678"));
		System.out.println(decrypt(encrypt("12321317398173913","123456781234567812345678"),"123456781234567812345679"));
	}

}
