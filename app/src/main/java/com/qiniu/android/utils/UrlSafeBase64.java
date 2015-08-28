package com.qiniu.android.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

public final class UrlSafeBase64
{
  public static byte[] decode(String paramString)
  {
    return Base64.decode(paramString, 10);
  }
  
  public static String encodeToString(String paramString)
  {
    try
    {
      String str = encodeToString(paramString.getBytes("utf-8"));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 10);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.utils.UrlSafeBase64
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */