package com.google.zxing.datamatrix.encoder;

final class X12Encoder
  extends C40Encoder
{
  public int a()
  {
    return 3;
  }
  
  int a(char paramChar, StringBuilder paramStringBuilder)
  {
    if (paramChar == '\r')
    {
      paramStringBuilder.append('\000');
      return 1;
    }
    if (paramChar == '*')
    {
      paramStringBuilder.append('\001');
      return 1;
    }
    if (paramChar == '>')
    {
      paramStringBuilder.append('\002');
      return 1;
    }
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
    HighLevelEncoder.c(paramChar);
    return 1;
  }
  
  public void a(EncoderContext paramEncoderContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramEncoderContext.g())
    {
      char c = paramEncoderContext.b();
      paramEncoderContext.a = (1 + paramEncoderContext.a);
      a(c, localStringBuilder);
      if (localStringBuilder.length() % 3 == 0)
      {
        a(paramEncoderContext, localStringBuilder);
        int i = HighLevelEncoder.a(paramEncoderContext.a(), paramEncoderContext.a, a());
        if (i != a()) {
          paramEncoderContext.b(i);
        }
      }
    }
    b(paramEncoderContext, localStringBuilder);
  }
  
  void b(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder)
  {
    paramEncoderContext.j();
    int i = paramEncoderContext.i().h() - paramEncoderContext.d();
    int j = paramStringBuilder.length();
    if (j == 2)
    {
      paramEncoderContext.a('þ');
      paramEncoderContext.a = (-2 + paramEncoderContext.a);
      paramEncoderContext.b(0);
    }
    while (j != 1) {
      return;
    }
    paramEncoderContext.a = (-1 + paramEncoderContext.a);
    if (i > 1) {
      paramEncoderContext.a('þ');
    }
    paramEncoderContext.b(0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.X12Encoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */