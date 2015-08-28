package com.xiaomi.channel.commonutils.string;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class d
{
  public static String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramInt; i++) {
      localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length())));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      localMessageDigest.update(b(paramString));
      String str = String.format("%1$032X", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
    return paramString;
  }
  
  public static String a(Collection<?> paramCollection, String paramString)
  {
    if (paramCollection == null) {
      return null;
    }
    return a(paramCollection.iterator(), paramString);
  }
  
  public static String a(Iterator<?> paramIterator, String paramString)
  {
    if (paramIterator == null) {
      return null;
    }
    if (!paramIterator.hasNext()) {
      return "";
    }
    Object localObject1 = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return localObject1.toString();
    }
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (localObject1 != null) {
      localStringBuffer.append(localObject1);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      Object localObject2 = paramIterator.next();
      if (localObject2 != null) {
        localStringBuffer.append(localObject2);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString.getBytes();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.string.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */