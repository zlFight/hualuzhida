package zhida.business.domain.util;

import zhida.business.domain.model.UserInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 3DES加密工具类
 */
public class UserInfoUtils {

	//密钥，加密解密的凭据，3des加密长度为24.key1=key2=key3 加密解密加密，向下兼容des.不相等耗时但安全性高
	public static final String SECRET_KEY = "123456781234567812345678";
	
	/** 单点登录标记 */
	public static Map<String, UserInfo> authTokens = new ConcurrentHashMap<String, UserInfo>();
	
}
