package com.google.zxing.datamatrix.encoder;

class C40Encoder
  implements Encoder
{
  private int a(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    int i = paramStringBuilder1.length();
    paramStringBuilder1.delete(i - paramInt, i);
    paramEncoderContext.a = (-1 + paramEncoderContext.a);
    int j = a(paramEncoderContext.b(), paramStringBuilder2);
    paramEncoderContext.k();
    return j;
  }
  
  private static String a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.charAt(paramInt);
    int j = paramCharSequence.charAt(paramInt + 1);
    int k = 1 + (paramCharSequence.charAt(paramInt + 2) + (i * 1600 + j * 40));
    return new String(new char[] { (char)(k / 256), (char)(k % 256) });
  }
  
  static void a(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder)
  {
    paramEncoderContext.a(a(paramStringBuilder, 0));
    paramStringBuilder.delete(0, 3);
  }
  
  public int a()
  {
    return 1;
  }
  
  int a(char paramChar, StringBuilder paramStringBuilder)
  {
    if (paramChar == ' ')
    {
      paramStringBuilder.append('\003');
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramStringBuilder.append((char)(4 + (paramChar - '0')));
      return 1;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      paramStringBuilder.append((char)(14 + (paramChar - 'A')));
      return 1;
    }
    if ((paramChar >= 0) && (paramChar <= '\037'))
    {
      paramStringBuilder.append('\000');
      paramStringBuilder.append(paramChar);
      return 2;
    }
    if ((paramChar >= '!') && (paramChar <= '/'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '!'));
      return 2;
    }
    if ((paramChar >= ':') && (paramChar <= '@'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(15 + (paramChar - ':')));
      return 2;
    }
    if ((paramChar >= '[') && (paramChar <= '_'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(22 + (paramChar - '[')));
      return 2;
    }
    if ((paramChar >= '`') && (paramChar <= ''))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '`'));
      return 2;
    }
    if (paramChar >= '')
    {
      paramStringBuilder.append("\001\036");
      return 2 + a((char)(paramChar - ''), paramStringBuilder);
    }
    throw new IllegalArgumentException("Illegal character: " + paramChar);
  }
  
  public void a(EncoderContext paramEncoderContext)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    while (paramEncoderContext.g())
    {
      char c = paramEncoderContext.b();
      paramEncoderContext.a = (1 + paramEncoderContext.a);
      int i = a(c, localStringBuilder1);
      int j = 2 * (localStringBuilder1.length() / 3) + paramEncoderContext.d();
      paramEncoderContext.c(j);
      int k = paramEncoderContext.i().h() - j;
      if (!paramEncoderContext.g())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        if ((localStringBuilder1.length() % 3 == 2) && ((k < 2) || (k > 2))) {}
        for (i = a(paramEncoderContext, localStringBuilder1, localStringBuilder2, i); (localStringBuilder1.length() % 3 == 1) && (((i <= 3) && (k != 1)) || (i > 3)); i = a(paramEncoderContext, localStringBuilder1, localStringBuilder2, i)) {}
      }
      if (localStringBuilder1.length() % 3 == 0)
      {
        int m = HighLevelEncoder.a(paramEncoderContext.a(), paramEncoderContext.a, a());
        if (m != a()) {
          paramEncoderContext.b(m);
        }
      }
    }
    b(paramEncoderContext, localStringBuilder1);
  }
  
  void b(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder)
  {
    int i = 2 * (paramStringBuilder.length() / 3);
    int j = paramStringBuilder.length() % 3;
    int k = i + paramEncoderContext.d();
    paramEncoderContext.c(k);
    int m = paramEncoderContext.i().h() - k;
    if (j == 2)
    {
      paramStringBuilder.append('\000');
      while (paramStringBuilder.length() >= 3) {
        a(paramEncoderContext, paramStringBuilder);
      }
      if (paramEncoderContext.g()) {
        paramEncoderContext.a('þ');
      }
    }
    for (;;)
    {
      paramEncoderContext.b(0);
      return;
      if ((m == 1) && (j == 1))
      {
        while (paramStringBuilder.length() >= 3) {
          a(paramEncoderContext, paramStringBuilder);
        }
        if (paramEncoderContext.g()) {
          paramEncoderContext.a('þ');
        }
        paramEncoderContext.a = (-1 + paramEncoderContext.a);
      }
      else
      {
        if (j != 0) {
          break;
        }
        while (paramStringBuilder.length() >= 3) {
          a(paramEncoderContext, paramStringBuilder);
        }
        if ((m > 0) || (paramEncoderContext.g())) {
          paramEncoderContext.a('þ');
        }
      }
    }
    throw new IllegalStateException("Unexpected case. Please report!");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.C40Encoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */