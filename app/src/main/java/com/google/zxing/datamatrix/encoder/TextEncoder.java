package com.google.zxing.datamatrix.encoder;

final class TextEncoder
  extends C40Encoder
{
  public int a()
  {
    return 2;
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
    if ((paramChar >= 'a') && (paramChar <= 'z'))
    {
      paramStringBuilder.append((char)(14 + (paramChar - 'a')));
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
    if (paramChar == '`')
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '`'));
      return 2;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(1 + (paramChar - 'A')));
      return 2;
    }
    if ((paramChar >= '{') && (paramChar <= ''))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(27 + (paramChar - '{')));
      return 2;
    }
    if (paramChar >= '')
    {
      paramStringBuilder.append("\001\036");
      return 2 + a((char)(paramChar - ''), paramStringBuilder);
    }
    HighLevelEncoder.c(paramChar);
    return -1;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.encoder.TextEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */