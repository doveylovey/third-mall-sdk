package com.sdk.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESUtil {
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS5Padding";
    /**
     * 生成key
     */
    private static SecretKeySpec key = null;

    public static String IV = "JCdfeCpxtAw2RPMf";

    private static void createKey(String _key) {
        if (key == null) {
            key = new SecretKeySpec(_key.getBytes(), ALGORITHM);
        }
    }

    /**
     * AES加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptData(String data, String _key) throws Exception {
        createKey(_key);
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    /**
     * AES解密
     *
     * @param base64Data
     * @return
     * @throws Exception
     */
    public static String decryptData(String base64Data, String _key) throws Exception {
        createKey(_key);
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decodeBase64(base64Data)));
    }
}
