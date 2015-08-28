package cn.sharesdk.framework.utils;

class l
  implements Appendable
{
  int a = -1;
  char[] b = new char[2];
  
  l(k paramk, Appendable paramAppendable) {}
  
  private void a(char[] paramArrayOfChar, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      this.c.append(paramArrayOfChar[i]);
    }
  }
  
  public Appendable append(char paramChar)
  {
    if (this.a != -1)
    {
      if (!Character.isLowSurrogate(paramChar)) {
        throw new IllegalArgumentException("Expected low surrogate character but got '" + paramChar + "' with value " + paramChar);
      }
      char[] arrayOfChar2 = this.d.a(Character.toCodePoint((char)this.a, paramChar));
      if (arrayOfChar2 != null) {
        a(arrayOfChar2, arrayOfChar2.length);
      }
      for (;;)
      {
        this.a = -1;
        return this;
        this.c.append((char)this.a);
        this.c.append(paramChar);
      }
    }
    if (Character.isHighSurrogate(paramChar))
    {
      this.a = paramChar;
      return this;
    }
    if (Character.isLowSurrogate(paramChar)) {
      throw new IllegalArgumentException("Unexpected low surrogate character '" + paramChar + "' with value " + paramChar);
    }
    char[] arrayOfChar1 = this.d.a(paramChar);
    if (arrayOfChar1 != null)
    {
      a(arrayOfChar1, arrayOfChar1.length);
      return this;
    }
    this.c.append(paramChar);
    return this;
  }
  
  public Appendable append(CharSequence paramCharSequence)
  {
    return append(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
    {
      if (this.a == -1) {
        break label265;
      }
      i = paramInt1 + 1;
      char c1 = paramCharSequence.charAt(paramInt1);
      if (!Character.isLowSurrogate(c1)) {
        throw new IllegalArgumentException("Expected low surrogate character but got " + c1);
      }
      char[] arrayOfChar2 = this.d.a(Character.toCodePoint((char)this.a, c1));
      if (arrayOfChar2 == null) {
        break label145;
      }
      a(arrayOfChar2, arrayOfChar2.length);
      paramInt1++;
      this.a = -1;
    }
    for (;;)
    {
      int j = this.d.a(paramCharSequence, i, paramInt2);
      if (j > paramInt1) {
        this.c.append(paramCharSequence, paramInt1, j);
      }
      if (j == paramInt2)
      {
        return this;
        label145:
        this.c.append((char)this.a);
        break;
      }
      int k = k.b(paramCharSequence, j, paramInt2);
      if (k < 0)
      {
        this.a = (-k);
        return this;
      }
      char[] arrayOfChar1 = this.d.a(k);
      if (arrayOfChar1 != null)
      {
        a(arrayOfChar1, arrayOfChar1.length);
        label211:
        if (!Character.isSupplementaryCodePoint(k)) {
          break label259;
        }
      }
      label259:
      for (int n = 2;; n = 1)
      {
        paramInt1 = j + n;
        i = paramInt1;
        break;
        int m = Character.toChars(k, this.b, 0);
        a(this.b, m);
        break label211;
      }
      label265:
      i = paramInt1;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */