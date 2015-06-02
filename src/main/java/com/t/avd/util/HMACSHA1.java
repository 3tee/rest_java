package com.t.avd.util;

import java.security.InvalidKeyException;  
import java.security.NoSuchAlgorithmException;  
import javax.crypto.Mac;  
import javax.crypto.spec.SecretKeySpec; 

/** 
 * 1. hmac_sha1��������Ҫת����hex��ʽ 
 *  
 * 2. java��base64��ʵ�ֺ�php��һ��,����java���������ַ���ĩβ�=���԰��ֽ�������Ϊ8������ 
 *  
 * 3. hmac_sha1����sha1, hmac_sha1����Ҫ������Կ�� 
 *  
 * @author LEI 
 *  
 */  
public class HMACSHA1 {  
  
    private static final String HMAC_SHA1 = "HmacSHA1";  
  
    /** 
     * ����ǩ������_HmacSHA1���� 
     *  
     * @param data 
     *            �����ܵ����� 
     * @param key 
     *            ����ʹ�õ�key 
     * @throws InvalidKeyException 
     * @throws NoSuchAlgorithmException 
     */  
    public static String getSignature(String data, String key) throws Exception {  
  
        byte[] keyBytes = key.getBytes();  
        // ���ݸ������ֽ����鹹��һ����Կ��  
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, HMAC_SHA1);  
        Mac mac = Mac.getInstance(HMAC_SHA1);  
        mac.init(signingKey);  
  
        byte[] rawHmac = mac.doFinal(data.getBytes());  
  
        String hexBytes = byte2hex(rawHmac);  
        return hexBytes;  
    }  
  
    private static String byte2hex(final byte[] b) {  
        String hs = "";  
        String stmp = "";  
        for (int n = 0; n < b.length; n++) {  
            // ��ʮ�����ƣ����� 16���޷���������ʽ����һ�������������ַ�����ʾ��ʽ��  
            stmp = (java.lang.Integer.toHexString(b[n] & 0xFF));  
            if (stmp.length() == 1) {  
                hs = hs + "0" + stmp;  
            } else {  
                hs = hs + stmp;  
            }  
        }  
        return hs;  
    }  
  
     /**  
     * @param args  
     */  
     public static void main(String[] args) {  
	     try {  
	        System.out.println(HMACSHA1.getSignature("abc", "abc"));  
	     } catch (Exception e) {  
	        e.printStackTrace();  
	     }  
     }  
  
}  
