package com.qiniu.android.utils;

public final class StringUtils
{
  public static String join(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    if (paramArrayOfString == null) {
      return null;
    }
    int j = paramArrayOfString.length;
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (int k = paramString.length();; k = 0)
    {
      int n;
      StringBuilder localStringBuilder;
      if (j == 0)
      {
        n = 0;
        localStringBuilder = new StringBuilder(n);
        while (i < j)
        {
          if (i > 0) {
            localStringBuilder.append(paramString);
          }
          if (paramArrayOfString[i] != null) {
            localStringBuilder.append(paramArrayOfString[i]);
          }
          i++;
        }
      }
      if (paramArrayOfString[0] == null) {}
      for (int m = 16;; m = paramArrayOfString[0].length())
      {
        n = j * (m + k);
        break;
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String jsonJoin(String[] paramArrayOfString)
  {
    int i = 0;
    int j = paramArrayOfString.length;
    StringBuilder localStringBuilder = new StringBuilder(j * (3 + paramArrayOfString[0].length()));
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append('"');
      localStringBuilder.append(paramArrayOfString[i]);
      localStringBuilder.append('"');
      i++;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.utils.StringUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */