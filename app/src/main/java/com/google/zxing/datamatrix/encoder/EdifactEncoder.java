package com.google.zxing.datamatrix.encoder;

final class EdifactEncoder
  implements Encoder
{
  private static String a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length() - paramInt;
    if (i == 0) {
      throw new IllegalStateException("StringBuilder must not be empty");
    }
    int j = paramCharSequence.charAt(paramInt);
    int k;
    if (i >= 2)
    {
      k = paramCharSequence.charAt(paramInt + 1);
      if (i < 3) {
        break label192;
      }
    }
    label192:
    for (int m = paramCharSequence.charAt(paramInt + 2);; m = 0)
    {
      int n = 0;
      if (i >= 4) {
        n = paramCharSequence.charAt(paramInt + 3);
      }
      int i1 = n + ((j << 18) + (k << 12) + (m << 6));
      char c1 = (char)(0xFF & i1 >> 16);
      char c2 = (char)(0xFF & i1 >> 8);
      char c3 = (char)(i1 & 0xFF);
      StringBuilder localStringBuilder = new StringBuilder(3);
      localStringBuilder.append(c1);
      if (i >= 2) {
        localStringBuilder.append(c2);
      }
      if (i >= 3) {
        localStringBuilder.append(c3);
      }
      return localStringBuilder.toString();
      k = 0;
      break;
    }
  }
  
  private static void a(char paramChar, StringBuilder paramStringBuilder)
  {
    if ((paramChar >= ' ') && (paramChar <= '?'))
    {
      paramStringBuilder.append(paramChar);
      return;
    }
    if ((paramChar >= '@') && (paramChar <= '^'))
    {
      paramStringBuilder.append((char)(paramChar - '@'));
      return;
    }
    HighLevelEncoder.c(paramChar);
  }
  
  private static void a(EncoderContext paramEncoderContext, CharSequence paramCharSequence)
  {
    int i = 1;
    int j;
    try
    {
      j = paramCharSequence.length();
      if (j == 0) {
        return;
      }
      if (j == i)
      {
        paramEncoderContext.j();
        int n = paramEncoderContext.i().h() - paramEncoderContext.d();
        int i1 = paramEncoderContext.h();
        if ((i1 == 0) && (n <= 2)) {
          return;
        }
      }
      if (j > 4) {
        throw new IllegalStateException("Count must not exceed 4");
      }
    }
    finally
    {
      paramEncoderContext.b(0);
    }
    int k = j - 1;
    String str = a(paramCharSequence, 0);
    int m;
    if (!paramEncoderContext.g()) {
      m = i;
    }
    for (;;)
    {
      if (k <= 2)
      {
        paramEncoderContext.c(k + paramEncoderContext.d());
        if (paramEncoderContext.i().h() - paramEncoderContext.d() >= 3)
        {
          paramEncoderContext.c(paramEncoderContext.d() + str.length());
          i = 0;
        }
      }
      if (i != 0)
      {
        paramEncoderContext.k();
        paramEncoderContext.a -= k;
        label186:
        paramEncoderContext.b(0);
        return;
        m = 0;
      }
      while ((m == 0) || (k > 2))
      {
        i = 0;
        break;
        paramEncoderContext.a(str);
        break label186;
      }
    }
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(EncoderContext paramEncoderContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramEncoderContext.g())
    {
      a(paramEncoderContext.b(), localStringBuilder);
      paramEncoderContext.a = (1 + paramEncoderContext.a);
      if (localStringBuilder.length() >= 4)
      {
        paramEncoderContext.a(a(localStringBuilder, 0));
        localStringBuilder.delete(0, 4);
        if (HighLevelEncoder.a(paramEncoderContext.a(), paramEncoderContext.a, a()) != a()) {
          paramEncoderContext.b(0);
        }
      }
    }
    localStringBuilder.append('\037');
    a(paramEncoderContext, localStringBuilder);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.EdifactEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */