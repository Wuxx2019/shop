package com.shop.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName：shop
 * @ClassName：MD5Util
 * @Description：MD5工具类
 * @Author：wuxingxing
 * @Date：2019/10/14 15:16
 */
public class MD5Util {

    //加密算法
    private static final String TYPE = "MD5";
    //编码字符集
    private static final String CODE = "UTF-8";


    /**
     *MD5加码 生成32位md5码
     * @param plainText 加密的字符
     * @return String
     */
    public static String stringToMD5(String plainText) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(TYPE);
            messageDigest.reset();
            messageDigest.update(plainText.getBytes(CODE));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5实例获取异常");
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            }else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString();
    }


    /**
     * 加密解密算法 执行一次加密，两次解密
     * @param inStr 解密的字符串
     * @return String
     */
    public static String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    // 测试主函数
     public static void main(String args[]) {
        String s = new String("456");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + stringToMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));

   }
}