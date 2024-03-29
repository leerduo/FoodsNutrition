package android.support.v4.text;

class BidiFormatter$DirectionalityEstimator
{
  private static final byte[] DIR_TYPE_CACHE = new byte[1792];
  private static final int DIR_TYPE_CACHE_SIZE = 1792;
  private int charIndex;
  private final boolean isHtml;
  private char lastChar;
  private final int length;
  private final String text;
  
  static
  {
    for (int i = 0; i < 1792; i++) {
      DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
    }
  }
  
  BidiFormatter$DirectionalityEstimator(String paramString, boolean paramBoolean)
  {
    this.text = paramString;
    this.isHtml = paramBoolean;
    this.length = paramString.length();
  }
  
  private static byte getCachedDirectionality(char paramChar)
  {
    if (paramChar < '܀') {
      return DIR_TYPE_CACHE[paramChar];
    }
    return Character.getDirectionality(paramChar);
  }
  
  private byte skipEntityBackward()
  {
    int i = this.charIndex;
    do
    {
      if (this.charIndex <= 0) {
        break;
      }
      String str = this.text;
      int j = -1 + this.charIndex;
      this.charIndex = j;
      this.lastChar = str.charAt(j);
      if (this.lastChar == '&') {
        return 12;
      }
    } while (this.lastChar != ';');
    this.charIndex = i;
    this.lastChar = ';';
    return 13;
  }
  
  private byte skipEntityForward()
  {
    char c;
    do
    {
      if (this.charIndex >= this.length) {
        break;
      }
      String str = this.text;
      int i = this.charIndex;
      this.charIndex = (i + 1);
      c = str.charAt(i);
      this.lastChar = c;
    } while (c != ';');
    return 12;
  }
  
  private byte skipTagBackward()
  {
    int i = this.charIndex;
    label147:
    for (;;)
    {
      if (this.charIndex > 0)
      {
        String str1 = this.text;
        int j = -1 + this.charIndex;
        this.charIndex = j;
        this.lastChar = str1.charAt(j);
        if (this.lastChar == '<') {
          return 12;
        }
        if (this.lastChar != '>') {}
      }
      else
      {
        this.charIndex = i;
        this.lastChar = '>';
        return 13;
      }
      if ((this.lastChar == '"') || (this.lastChar == '\''))
      {
        int k = this.lastChar;
        for (;;)
        {
          if (this.charIndex <= 0) {
            break label147;
          }
          String str2 = this.text;
          int m = -1 + this.charIndex;
          this.charIndex = m;
          char c = str2.charAt(m);
          this.lastChar = c;
          if (c == k) {
            break;
          }
        }
      }
    }
  }
  
  private byte skipTagForward()
  {
    int i = this.charIndex;
    label132:
    while (this.charIndex < this.length)
    {
      String str1 = this.text;
      int j = this.charIndex;
      this.charIndex = (j + 1);
      this.lastChar = str1.charAt(j);
      if (this.lastChar == '>') {
        return 12;
      }
      if ((this.lastChar == '"') || (this.lastChar == '\''))
      {
        int k = this.lastChar;
        for (;;)
        {
          if (this.charIndex >= this.length) {
            break label132;
          }
          String str2 = this.text;
          int m = this.charIndex;
          this.charIndex = (m + 1);
          char c = str2.charAt(m);
          this.lastChar = c;
          if (c == k) {
            break;
          }
        }
      }
    }
    this.charIndex = i;
    this.lastChar = '<';
    return 13;
  }
  
  byte dirTypeBackward()
  {
    this.lastChar = this.text.charAt(-1 + this.charIndex);
    byte b;
    if (Character.isLowSurrogate(this.lastChar))
    {
      int i = Character.codePointBefore(this.text, this.charIndex);
      this.charIndex -= Character.charCount(i);
      b = Character.getDirectionality(i);
    }
    do
    {
      do
      {
        return b;
        this.charIndex = (-1 + this.charIndex);
        b = getCachedDirectionality(this.lastChar);
      } while (!this.isHtml);
      if (this.lastChar == '>') {
        return skipTagBackward();
      }
    } while (this.lastChar != ';');
    return skipEntityBackward();
  }
  
  byte dirTypeForward()
  {
    this.lastChar = this.text.charAt(this.charIndex);
    byte b;
    if (Character.isHighSurrogate(this.lastChar))
    {
      int i = Character.codePointAt(this.text, this.charIndex);
      this.charIndex += Character.charCount(i);
      b = Character.getDirectionality(i);
    }
    do
    {
      do
      {
        return b;
        this.charIndex = (1 + this.charIndex);
        b = getCachedDirectionality(this.lastChar);
      } while (!this.isHtml);
      if (this.lastChar == '<') {
        return skipTagForward();
      }
    } while (this.lastChar != '&');
    return skipEntityForward();
  }
  
  int getEntryDir()
  {
    this.charIndex = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    while ((this.charIndex < this.length) && (i == 0)) {
      switch (dirTypeForward())
      {
      case 9: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        i = k;
        break;
      case 14: 
      case 15: 
        k++;
        j = -1;
        break;
      case 16: 
      case 17: 
        k++;
        j = 1;
        break;
      case 18: 
        k--;
        j = 0;
        break;
      case 0: 
        if (k == 0) {
          return -1;
        }
        i = k;
        break;
      case 1: 
      case 2: 
        if (k == 0) {
          return 1;
        }
        i = k;
      }
    }
    if (i == 0) {
      return 0;
    }
    if (j != 0) {
      return j;
    }
    for (;;)
    {
      if (this.charIndex <= 0) {
        break label261;
      }
      switch (dirTypeBackward())
      {
      default: 
        break;
      case 14: 
      case 15: 
        if (i == k) {
          break;
        }
        k--;
        break;
      case 16: 
      case 17: 
        if (i == k) {
          return 1;
        }
        k--;
        break;
      case 18: 
        k++;
      }
    }
    label261:
    return 0;
  }
  
  int getExitDir()
  {
    this.charIndex = this.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k = this.charIndex;
      int m = 0;
      if (k > 0) {}
      switch (dirTypeBackward())
      {
      case 9: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        if (i == 0) {
          i = j;
        }
        break;
      case 0: 
        if (j == 0)
        {
          m = -1;
          return m;
        }
        if (i == 0) {
          i = j;
        }
        break;
      case 14: 
      case 15: 
        if (i == j) {
          return -1;
        }
        j--;
        break;
      case 1: 
      case 2: 
        if (j == 0) {
          return 1;
        }
        if (i == 0) {
          i = j;
        }
        break;
      case 16: 
      case 17: 
        if (i == j) {
          return 1;
        }
        j--;
        break;
      case 18: 
        j++;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter.DirectionalityEstimator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */