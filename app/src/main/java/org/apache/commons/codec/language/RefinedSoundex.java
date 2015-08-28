package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class RefinedSoundex
  implements StringEncoder
{
  public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
  public static final char[] US_ENGLISH_MAPPING = "01360240043788015936020505".toCharArray();
  private char[] soundexMapping;
  
  public RefinedSoundex()
  {
    this(US_ENGLISH_MAPPING);
  }
  
  public RefinedSoundex(char[] paramArrayOfChar)
  {
    this.soundexMapping = paramArrayOfChar;
  }
  
  public int difference(String paramString1, String paramString2)
  {
    return SoundexUtils.difference(this, paramString1, paramString2);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }
    return soundex((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return soundex(paramString);
  }
  
  char getMappingCode(char paramChar)
  {
    if (!Character.isLetter(paramChar)) {
      return '\000';
    }
    return this.soundexMapping[('﾿' + Character.toUpperCase(paramChar))];
  }
  
  public String soundex(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    String str = SoundexUtils.clean(paramString);
    if (str.length() == 0) {
      return str;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(str.charAt(0));
    int j = 42;
    if (i < str.length())
    {
      char c = getMappingCode(str.charAt(i));
      if (c == j) {}
      for (;;)
      {
        i++;
        break;
        if (c != 0) {
          localStringBuffer.append(c);
        }
        j = c;
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.language.RefinedSoundex
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */