package org.apache.commons.codec.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class DigestUtils
{
  static MessageDigest getDigest(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException.getMessage());
    }
  }
  
  private static MessageDigest getMd5Digest()
  {
    return getDigest("MD5");
  }
  
  private static MessageDigest getShaDigest()
  {
    return getDigest("SHA");
  }
  
  public static byte[] md5(String paramString)
  {
    return md5(paramString.getBytes());
  }
  
  public static byte[] md5(byte[] paramArrayOfByte)
  {
    return getMd5Digest().digest(paramArrayOfByte);
  }
  
  public static String md5Hex(String paramString)
  {
    return new String(Hex.encodeHex(md5(paramString)));
  }
  
  public static String md5Hex(byte[] paramArrayOfByte)
  {
    return new String(Hex.encodeHex(md5(paramArrayOfByte)));
  }
  
  public static byte[] sha(String paramString)
  {
    return sha(paramString.getBytes());
  }
  
  public static byte[] sha(byte[] paramArrayOfByte)
  {
    return getShaDigest().digest(paramArrayOfByte);
  }
  
  public static String shaHex(String paramString)
  {
    return new String(Hex.encodeHex(sha(paramString)));
  }
  
  public static String shaHex(byte[] paramArrayOfByte)
  {
    return new String(Hex.encodeHex(sha(paramArrayOfByte)));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.digest.DigestUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */