package com.boohee.pictures.qiniu;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public abstract class Coder
{
  public static final String HMAC_SHA1 = "HmacSHA1";
  public static final String KEY_MD5 = "MD5";
  public static final String KEY_SHA = "SHA-1";
  
  public static byte[] decryptBASE64(String paramString)
  {
    return Base64.decodeBase64(paramString.getBytes());
  }
  
  public static byte[] encryptBASE64(byte[] paramArrayOfByte)
  {
    return Base64.encodeBase64(paramArrayOfByte);
  }
  
  public static byte[] encryptHMAC(byte[] paramArrayOfByte, String paramString)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "HmacSHA1");
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(localSecretKeySpec);
    return localMac.doFinal(paramArrayOfByte);
  }
  
  public static String encryptHMAC2String(String paramString1, String paramString2)
  {
    return getString(encryptHMAC(paramString1.getBytes(), paramString2));
  }
  
  public static String encryptMD5(String paramString)
  {
    MessageDigest localMessageDigest = null;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0;; i++)
      {
        if (i >= arrayOfByte.length) {
          break label133;
        }
        if (Integer.toHexString(0xFF & arrayOfByte[i]).length() != 1) {
          break;
        }
        localStringBuffer.append("0").append(Integer.toHexString(0xFF & arrayOfByte[i]));
      }
      return localStringBuffer.toString();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        System.out.println("NoSuchAlgorithmException caught!");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
        localStringBuffer.append(Integer.toHexString(0xFF & arrayOfByte[i]));
      }
    }
  }
  
  public static byte[] encryptMD5(byte[] paramArrayOfByte)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static byte[] encryptSHA(byte[] paramArrayOfByte)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static String getString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      localStringBuffer.append(paramArrayOfByte[i]);
    }
    return localStringBuffer.toString();
  }
  
  public static String initMacKey()
  {
    return getString(encryptBASE64(KeyGenerator.getInstance("HmacSHA1").generateKey().getEncoded()));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.qiniu.Coder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */