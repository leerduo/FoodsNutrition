package com.google.zxing.datamatrix.encoder;

final class Base256Encoder
  implements Encoder
{
  private static char a(char paramChar, int paramInt)
  {
    int i = paramChar + (1 + paramInt * 149 % 255);
    if (i <= 255) {
      return (char)i;
    }
    return (char)(i - 256);
  }
  
  public int a()
  {
    return 5;
  }
  
  public void a(EncoderContext paramEncoderContext)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\000');
    while (paramEncoderContext.g())
    {
      localStringBuilder.append(paramEncoderContext.b());
      paramEncoderContext.a = (1 + paramEncoderContext.a);
      int i1 = HighLevelEncoder.a(paramEncoderContext.a(), paramEncoderContext.a, a());
      if (i1 != a()) {
        paramEncoderContext.b(i1);
      }
    }
    int j = -1 + localStringBuilder.length();
    int k = 1 + (j + paramEncoderContext.d());
    paramEncoderContext.c(k);
    int m;
    if (paramEncoderContext.i().h() - k > 0)
    {
      m = 1;
      if ((paramEncoderContext.g()) || (m != 0))
      {
        if (j > 249) {
          break label185;
        }
        localStringBuilder.setCharAt(0, (char)j);
      }
    }
    for (;;)
    {
      int n = localStringBuilder.length();
      while (i < n)
      {
        paramEncoderContext.a(a(localStringBuilder.charAt(i), 1 + paramEncoderContext.d()));
        i++;
      }
      m = 0;
      break;
      label185:
      if ((j <= 249) || (j > 1555)) {
        break label233;
      }
      localStringBuilder.setCharAt(0, (char)(249 + j / 250));
      localStringBuilder.insert(1, (char)(j % 250));
    }
    label233:
    throw new IllegalStateException("Message length not in valid ranges: " + j);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.Base256Encoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */