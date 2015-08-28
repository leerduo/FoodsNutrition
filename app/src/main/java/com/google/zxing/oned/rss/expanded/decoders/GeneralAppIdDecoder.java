package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitArray;

final class GeneralAppIdDecoder
{
  private final BitArray a;
  private final CurrentParsingState b = new CurrentParsingState();
  private final StringBuilder c = new StringBuilder();
  
  GeneralAppIdDecoder(BitArray paramBitArray)
  {
    this.a = paramBitArray;
  }
  
  static int a(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (int j = 0; j < paramInt2; j++) {
      if (paramBitArray.a(paramInt1 + j)) {
        i |= 1 << -1 + (paramInt2 - j);
      }
    }
    return i;
  }
  
  private DecodedInformation a()
  {
    int i = this.b.a();
    BlockParsedResult localBlockParsedResult;
    boolean bool;
    label28:
    int j;
    if (this.b.b())
    {
      localBlockParsedResult = d();
      bool = localBlockParsedResult.b();
      if (i == this.b.a()) {
        break label92;
      }
      j = 1;
      label42:
      if ((j != 0) || (bool)) {
        break label98;
      }
    }
    for (;;)
    {
      return localBlockParsedResult.a();
      if (this.b.c())
      {
        localBlockParsedResult = c();
        bool = localBlockParsedResult.b();
        break label28;
      }
      localBlockParsedResult = b();
      bool = localBlockParsedResult.b();
      break label28;
      label92:
      j = 0;
      break label42;
      label98:
      if (!bool) {
        break;
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt + 7 > this.a.a()) {
      return paramInt + 4 <= this.a.a();
    }
    for (int i = paramInt;; i++)
    {
      if (i >= paramInt + 3) {
        break label57;
      }
      if (this.a.a(i)) {
        break;
      }
    }
    label57:
    return this.a.a(paramInt + 3);
  }
  
  private BlockParsedResult b()
  {
    while (a(this.b.a()))
    {
      DecodedNumeric localDecodedNumeric = b(this.b.a());
      this.b.a(localDecodedNumeric.e());
      if (localDecodedNumeric.c())
      {
        if (localDecodedNumeric.d()) {}
        for (DecodedInformation localDecodedInformation = new DecodedInformation(this.b.a(), this.c.toString());; localDecodedInformation = new DecodedInformation(this.b.a(), this.c.toString(), localDecodedNumeric.b())) {
          return new BlockParsedResult(localDecodedInformation, true);
        }
      }
      this.c.append(localDecodedNumeric.a());
      if (localDecodedNumeric.d()) {
        return new BlockParsedResult(new DecodedInformation(this.b.a(), this.c.toString()), true);
      }
      this.c.append(localDecodedNumeric.b());
    }
    if (i(this.b.a()))
    {
      this.b.e();
      this.b.b(4);
    }
    return new BlockParsedResult(false);
  }
  
  private DecodedNumeric b(int paramInt)
  {
    if (paramInt + 7 > this.a.a())
    {
      int m = a(paramInt, 4);
      if (m == 0) {
        return new DecodedNumeric(this.a.a(), 10, 10);
      }
      return new DecodedNumeric(this.a.a(), m - 1, 10);
    }
    int i = a(paramInt, 7);
    int j = (i - 8) / 11;
    int k = (i - 8) % 11;
    return new DecodedNumeric(paramInt + 7, j, k);
  }
  
  private BlockParsedResult c()
  {
    while (c(this.b.a()))
    {
      DecodedChar localDecodedChar = d(this.b.a());
      this.b.a(localDecodedChar.e());
      if (localDecodedChar.b()) {
        return new BlockParsedResult(new DecodedInformation(this.b.a(), this.c.toString()), true);
      }
      this.c.append(localDecodedChar.a());
    }
    if (h(this.b.a()))
    {
      this.b.b(3);
      this.b.d();
    }
    while (!g(this.b.a())) {
      return new BlockParsedResult(false);
    }
    if (5 + this.b.a() < this.a.a()) {
      this.b.b(5);
    }
    for (;;)
    {
      this.b.e();
      break;
      this.b.a(this.a.a());
    }
  }
  
  private boolean c(int paramInt)
  {
    boolean bool = true;
    if (paramInt + 5 > this.a.a()) {}
    do
    {
      do
      {
        return false;
        int i = a(paramInt, 5);
        if ((i >= 5) && (i < 16)) {
          return bool;
        }
      } while (paramInt + 7 > this.a.a());
      int j = a(paramInt, 7);
      if ((j >= 64) && (j < 116)) {
        return bool;
      }
    } while (paramInt + 8 > this.a.a());
    int k = a(paramInt, 8);
    if ((k >= 232) && (k < 253)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private BlockParsedResult d()
  {
    while (e(this.b.a()))
    {
      DecodedChar localDecodedChar = f(this.b.a());
      this.b.a(localDecodedChar.e());
      if (localDecodedChar.b()) {
        return new BlockParsedResult(new DecodedInformation(this.b.a(), this.c.toString()), true);
      }
      this.c.append(localDecodedChar.a());
    }
    if (h(this.b.a()))
    {
      this.b.b(3);
      this.b.d();
    }
    while (!g(this.b.a())) {
      return new BlockParsedResult(false);
    }
    if (5 + this.b.a() < this.a.a()) {
      this.b.b(5);
    }
    for (;;)
    {
      this.b.f();
      break;
      this.b.a(this.a.a());
    }
  }
  
  private DecodedChar d(int paramInt)
  {
    int i = a(paramInt, 5);
    if (i == 15) {
      return new DecodedChar(paramInt + 5, '$');
    }
    if ((i >= 5) && (i < 15)) {
      return new DecodedChar(paramInt + 5, (char)(-5 + (i + 48)));
    }
    int j = a(paramInt, 7);
    if ((j >= 64) && (j < 90)) {
      return new DecodedChar(paramInt + 7, (char)(j + 1));
    }
    if ((j >= 90) && (j < 116)) {
      return new DecodedChar(paramInt + 7, (char)(j + 7));
    }
    char c1;
    switch (a(paramInt, 8))
    {
    default: 
      throw FormatException.a();
    case 232: 
      c1 = '!';
    }
    for (;;)
    {
      return new DecodedChar(paramInt + 8, c1);
      c1 = '"';
      continue;
      c1 = '%';
      continue;
      c1 = '&';
      continue;
      c1 = '\'';
      continue;
      c1 = '(';
      continue;
      c1 = ')';
      continue;
      c1 = '*';
      continue;
      c1 = '+';
      continue;
      c1 = ',';
      continue;
      c1 = '-';
      continue;
      c1 = '.';
      continue;
      c1 = '/';
      continue;
      c1 = ':';
      continue;
      c1 = ';';
      continue;
      c1 = '<';
      continue;
      c1 = '=';
      continue;
      c1 = '>';
      continue;
      c1 = '?';
      continue;
      c1 = '_';
      continue;
      c1 = ' ';
    }
  }
  
  private boolean e(int paramInt)
  {
    boolean bool = true;
    if (paramInt + 5 > this.a.a()) {}
    do
    {
      return false;
      int i = a(paramInt, 5);
      if ((i >= 5) && (i < 16)) {
        return bool;
      }
    } while (paramInt + 6 > this.a.a());
    int j = a(paramInt, 6);
    if ((j >= 16) && (j < 63)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private DecodedChar f(int paramInt)
  {
    int i = a(paramInt, 5);
    if (i == 15) {
      return new DecodedChar(paramInt + 5, '$');
    }
    if ((i >= 5) && (i < 15)) {
      return new DecodedChar(paramInt + 5, (char)(-5 + (i + 48)));
    }
    int j = a(paramInt, 6);
    if ((j >= 32) && (j < 58)) {
      return new DecodedChar(paramInt + 6, (char)(j + 33));
    }
    char c1;
    switch (j)
    {
    default: 
      throw new IllegalStateException("Decoding invalid alphanumeric value: " + j);
    case 58: 
      c1 = '*';
    }
    for (;;)
    {
      return new DecodedChar(paramInt + 6, c1);
      c1 = ',';
      continue;
      c1 = '-';
      continue;
      c1 = '.';
      continue;
      c1 = '/';
    }
  }
  
  private boolean g(int paramInt)
  {
    if (paramInt + 1 > this.a.a()) {}
    int i;
    do
    {
      return false;
      i = 0;
      if ((i >= 5) || (i + paramInt >= this.a.a())) {
        break label74;
      }
      if (i != 2) {
        break;
      }
    } while (!this.a.a(paramInt + 2));
    while (!this.a.a(paramInt + i))
    {
      i++;
      break;
    }
    return false;
    label74:
    return true;
  }
  
  private boolean h(int paramInt)
  {
    if (paramInt + 3 > this.a.a()) {
      return false;
    }
    for (int i = paramInt;; i++)
    {
      if (i >= paramInt + 3) {
        break label41;
      }
      if (this.a.a(i)) {
        break;
      }
    }
    label41:
    return true;
  }
  
  private boolean i(int paramInt)
  {
    if (paramInt + 1 > this.a.a()) {
      return false;
    }
    for (int i = 0;; i++)
    {
      if ((i >= 4) || (i + paramInt >= this.a.a())) {
        break label54;
      }
      if (this.a.a(paramInt + i)) {
        break;
      }
    }
    label54:
    return true;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    return a(this.a, paramInt1, paramInt2);
  }
  
  DecodedInformation a(int paramInt, String paramString)
  {
    this.c.setLength(0);
    if (paramString != null) {
      this.c.append(paramString);
    }
    this.b.a(paramInt);
    DecodedInformation localDecodedInformation = a();
    if ((localDecodedInformation != null) && (localDecodedInformation.b())) {
      return new DecodedInformation(this.b.a(), this.c.toString(), localDecodedInformation.c());
    }
    return new DecodedInformation(this.b.a(), this.c.toString());
  }
  
  String a(StringBuilder paramStringBuilder, int paramInt)
  {
    String str1 = null;
    for (;;)
    {
      DecodedInformation localDecodedInformation = a(paramInt, str1);
      String str2 = FieldParser.a(localDecodedInformation.a());
      if (str2 != null) {
        paramStringBuilder.append(str2);
      }
      if (localDecodedInformation.b()) {}
      for (str1 = String.valueOf(localDecodedInformation.c()); paramInt == localDecodedInformation.e(); str1 = null) {
        return paramStringBuilder.toString();
      }
      paramInt = localDecodedInformation.e();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.GeneralAppIdDecoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */