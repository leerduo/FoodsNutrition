package com.boohee.food.cache;

class FileCache$Utils
{
  private static int a(byte[] paramArrayOfByte, char paramChar)
  {
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      if (paramArrayOfByte[i] == paramChar) {
        return i;
      }
    }
    return -1;
  }
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    String[] arrayOfString = c(paramArrayOfByte);
    if ((arrayOfString != null) && (arrayOfString.length == 2))
    {
      for (String str = arrayOfString[0]; str.startsWith("0"); str = str.substring(1, str.length())) {}
      long l1 = Long.valueOf(str).longValue();
      long l2 = Long.valueOf(arrayOfString[1]).longValue();
      if (System.currentTimeMillis() > l1 + l2 * 1000L) {
        return true;
      }
    }
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i < 0) {
      throw new IllegalArgumentException(paramInt1 + " > " + paramInt2);
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
    return arrayOfByte;
  }
  
  private static boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (a(paramArrayOfByte, ' ') > 14);
  }
  
  private static boolean c(String paramString)
  {
    return a(paramString.getBytes());
  }
  
  private static String[] c(byte[] paramArrayOfByte)
  {
    if (b(paramArrayOfByte)) {
      return new String[] { new String(a(paramArrayOfByte, 0, 13)), new String(a(paramArrayOfByte, 14, a(paramArrayOfByte, ' '))) };
    }
    return null;
  }
  
  private static String d(String paramString)
  {
    if ((paramString != null) && (b(paramString.getBytes()))) {
      paramString = paramString.substring(1 + paramString.indexOf(' '), paramString.length());
    }
    return paramString;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.cache.FileCache.Utils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */