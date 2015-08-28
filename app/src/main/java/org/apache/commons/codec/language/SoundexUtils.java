package org.apache.commons.codec.language;

import org.apache.commons.codec.StringEncoder;

final class SoundexUtils
{
  static String clean(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    int i = paramString.length();
    char[] arrayOfChar = new char[i];
    int j = 0;
    int k = 0;
    int m;
    if (j < i)
    {
      if (!Character.isLetter(paramString.charAt(j))) {
        break label94;
      }
      m = k + 1;
      arrayOfChar[k] = paramString.charAt(j);
    }
    for (;;)
    {
      j++;
      k = m;
      break;
      if (k == i) {
        return paramString.toUpperCase();
      }
      return new String(arrayOfChar, 0, k).toUpperCase();
      label94:
      m = k;
    }
  }
  
  static int difference(StringEncoder paramStringEncoder, String paramString1, String paramString2)
  {
    return differenceEncoded(paramStringEncoder.encode(paramString1), paramStringEncoder.encode(paramString2));
  }
  
  static int differenceEncoded(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1 != null)
    {
      i = 0;
      if (paramString2 != null) {
        break label14;
      }
    }
    for (;;)
    {
      return i;
      label14:
      int j = Math.min(paramString1.length(), paramString2.length());
      for (int k = 0; k < j; k++) {
        if (paramString1.charAt(k) == paramString2.charAt(k)) {
          i++;
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.language.SoundexUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */