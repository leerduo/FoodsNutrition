package cn.sharesdk.framework.utils;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static d a = new d();
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramInt1 < paramInt2)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Byte.valueOf(paramArrayOfByte[paramInt1]);
      localStringBuffer.append(String.format("%02x", arrayOfObject));
      paramInt1++;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (int i = paramInputStream.read(arrayOfByte1); i != -1; i = paramInputStream.read(arrayOfByte1)) {
        localMessageDigest.update(arrayOfByte1, 0, i);
      }
      byte[] arrayOfByte2 = localMessageDigest.digest();
      return arrayOfByte2;
    }
    catch (Throwable localThrowable)
    {
      e.b(localThrowable);
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString.getBytes("utf-8"));
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    byte[] arrayOfByte1 = paramString1.getBytes("UTF-8");
    byte[] arrayOfByte2 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, Math.min(arrayOfByte1.length, 16));
    byte[] arrayOfByte3 = paramString2.getBytes("UTF-8");
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte2, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    localCipher.init(1, localSecretKeySpec);
    byte[] arrayOfByte4 = new byte[localCipher.getOutputSize(arrayOfByte3.length)];
    localCipher.doFinal(arrayOfByte4, localCipher.update(arrayOfByte3, 0, arrayOfByte3.length, arrayOfByte4, 0));
    return arrayOfByte4;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    localCipher.init(1, localSecretKeySpec);
    byte[] arrayOfByte2 = new byte[localCipher.getOutputSize(arrayOfByte1.length)];
    localCipher.doFinal(arrayOfByte2, localCipher.update(arrayOfByte1, 0, arrayOfByte1.length, arrayOfByte2, 0));
    return arrayOfByte2;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte1 = new byte[16];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, 0, Math.min(paramArrayOfByte1.length, 16));
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
    localCipher.init(2, localSecretKeySpec);
    byte[] arrayOfByte2 = new byte[localCipher.getOutputSize(paramArrayOfByte2.length)];
    int i = localCipher.update(paramArrayOfByte2, 0, paramArrayOfByte2.length, arrayOfByte2, 0);
    (i + localCipher.doFinal(arrayOfByte2, i));
    return arrayOfByte2;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    byte[] arrayOfByte;
    do
    {
      return null;
      arrayOfByte = c(paramString);
    } while (arrayOfByte == null);
    return c.a(arrayOfByte);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      String str1 = Base64.encodeToString(a(paramString2, paramString1), 0);
      localObject = str1;
      String str2;
      Throwable localThrowable2;
      e.c(localThrowable2);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (((String)localObject).contains("\n"))
        {
          str2 = ((String)localObject).replace("\n", "");
          localObject = str2;
        }
        return localObject;
      }
      catch (Throwable localThrowable3)
      {
        Object localObject;
        break label44;
      }
      localThrowable1 = localThrowable1;
      localObject = null;
      localThrowable2 = localThrowable1;
    }
    label44:
    return localObject;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String c(String paramString1, String paramString2)
  {
    return URLEncoder.encode(paramString1, paramString2).replace("+", "%20");
  }
  
  public static byte[] c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = c(paramString.getBytes("utf-8"));
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      e.c(localException);
    }
    return null;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      arrayOfByte = a(localByteArrayInputStream);
      localByteArrayInputStream.close();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        e.c(localException);
        byte[] arrayOfByte = null;
      }
    }
  }
  
  public static String d(String paramString)
  {
    try
    {
      String str = c(paramString, "utf-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */