package com.google.zxing.datamatrix.encoder;

final class ASCIIEncoder
  implements Encoder
{
  private static char a(char paramChar1, char paramChar2)
  {
    if ((HighLevelEncoder.a(paramChar1)) && (HighLevelEncoder.a(paramChar2))) {
      return (char)(130 + (10 * (paramChar1 - '0') + (paramChar2 - '0')));
    }
    throw new IllegalArgumentException("not digits: " + paramChar1 + paramChar2);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(EncoderContext paramEncoderContext)
  {
    if (HighLevelEncoder.a(paramEncoderContext.a(), paramEncoderContext.a) >= 2)
    {
      paramEncoderContext.a(a(paramEncoderContext.a().charAt(paramEncoderContext.a), paramEncoderContext.a().charAt(1 + paramEncoderContext.a)));
      paramEncoderContext.a = (2 + paramEncoderContext.a);
      return;
    }
    char c = paramEncoderContext.b();
    int i = HighLevelEncoder.a(paramEncoderContext.a(), paramEncoderContext.a, a());
    if (i != a())
    {
      switch (i)
      {
      default: 
        throw new IllegalStateException("Illegal mode: " + i);
      case 5: 
        paramEncoderContext.a('ç');
        paramEncoderContext.b(5);
        return;
      case 1: 
        paramEncoderContext.a('æ');
        paramEncoderContext.b(1);
        return;
      case 3: 
        paramEncoderContext.a('î');
        paramEncoderContext.b(3);
        return;
      case 2: 
        paramEncoderContext.a('ï');
        paramEncoderContext.b(2);
        return;
      }
      paramEncoderContext.a('ð');
      paramEncoderContext.b(4);
      return;
    }
    if (HighLevelEncoder.b(c))
    {
      paramEncoderContext.a('ë');
      paramEncoderContext.a((char)(1 + (c - '')));
      paramEncoderContext.a = (1 + paramEncoderContext.a);
      return;
    }
    paramEncoderContext.a((char)(c + '\001'));
    paramEncoderContext.a = (1 + paramEncoderContext.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.ASCIIEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */