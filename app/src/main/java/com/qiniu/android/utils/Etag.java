package com.qiniu.android.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Etag
{
  public static String data(byte[] paramArrayOfByte)
  {
    return data(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String data(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      String str = stream(new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2), paramInt2);
      return str;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  public static String file(File paramFile)
  {
    return stream(new FileInputStream(paramFile), paramFile.length());
  }
  
  public static String file(String paramString)
  {
    return file(new File(paramString));
  }
  
  private static byte[] oneBlock(byte[] paramArrayOfByte, InputStream paramInputStream, int paramInt)
  {
    MessageDigest localMessageDigest;
    for (;;)
    {
      try
      {
        localMessageDigest = MessageDigest.getInstance("sha-1");
        int i = paramArrayOfByte.length;
        int j = paramInt;
        if (j == 0) {
          break;
        }
        int k;
        if (i > j)
        {
          k = j;
          paramInputStream.read(paramArrayOfByte, 0, k);
          localMessageDigest.update(paramArrayOfByte, 0, k);
          j -= k;
        }
        else
        {
          k = i;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        localNoSuchAlgorithmException.printStackTrace();
        return null;
      }
    }
    return localMessageDigest.digest();
  }
  
  private static String resultEncode(byte[][] paramArrayOfByte)
  {
    int i = 22;
    byte[] arrayOfByte1 = paramArrayOfByte[0];
    int j = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[j + 1];
    if (paramArrayOfByte.length != 1)
    {
      i = -106;
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("sha-1");
        int k = paramArrayOfByte.length;
        for (int m = 0; m < k; m++) {
          localMessageDigest.update(paramArrayOfByte[m]);
        }
        arrayOfByte1 = localMessageDigest.digest();
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        localNoSuchAlgorithmException.printStackTrace();
        return null;
      }
    }
    arrayOfByte2[0] = i;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, j);
    return UrlSafeBase64.encodeToString(arrayOfByte2);
  }
  
  public static String stream(InputStream paramInputStream, long paramLong)
  {
    if (paramLong == 0L) {
      return "Fto5o-5ea0sNMlW_75VgGJCv2AcJ";
    }
    byte[] arrayOfByte = new byte[65536];
    byte[][] arrayOfByte1 = new byte[(int)(paramLong + 4194304L - 1L) / 4194304][];
    for (int i = 0; i < arrayOfByte1.length; i++)
    {
      long l = paramLong - 4194304L * i;
      if (l > 4194304L) {
        l = 4194304L;
      }
      arrayOfByte1[i] = oneBlock(arrayOfByte, paramInputStream, (int)l);
    }
    return resultEncode(arrayOfByte1);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.utils.Etag
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */