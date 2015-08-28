package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class DecodedBitStreamParser
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };
  
  private static char a(int paramInt)
  {
    if (paramInt >= a.length) {
      throw FormatException.a();
    }
    return a[paramInt];
  }
  
  private static int a(BitSource paramBitSource)
  {
    int i = paramBitSource.a(8);
    if ((i & 0x80) == 0) {
      return i & 0x7F;
    }
    if ((i & 0xC0) == 128) {
      return paramBitSource.a(8) | (i & 0x3F) << 8;
    }
    if ((i & 0xE0) == 192) {
      return paramBitSource.a(16) | (i & 0x1F) << 16;
    }
    throw FormatException.a();
  }
  
  static DecoderResult a(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap)
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    ArrayList localArrayList = new ArrayList(1);
    CharacterSetECI localCharacterSetECI = null;
    int i = -1;
    int j = -1;
    boolean bool1 = false;
    for (;;)
    {
      Mode localMode1;
      Object localObject;
      String str2;
      try
      {
        if (localBitSource.c() < 4)
        {
          localMode1 = Mode.a;
          if (localMode1 == Mode.a) {
            break label459;
          }
          if (localMode1 == Mode.h) {
            break label489;
          }
          if (localMode1 == Mode.i)
          {
            break label489;
            Mode localMode2 = Mode.a;
            if (localMode1 != localMode2) {
              break label474;
            }
            String str1 = localStringBuilder.toString();
            if (!localArrayList.isEmpty()) {
              break label443;
            }
            localObject = null;
            if (paramErrorCorrectionLevel != null) {
              break label450;
            }
            str2 = null;
            return new DecoderResult(paramArrayOfByte, str1, (List)localObject, str2, k, m);
          }
        }
        else
        {
          localMode1 = Mode.a(localBitSource.a(4));
          continue;
        }
        if (localMode1 != Mode.d) {
          break label217;
        }
        if (localBitSource.c() < 16) {
          throw FormatException.a();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw FormatException.a();
      }
      int i3 = localBitSource.a(8);
      int i4 = localBitSource.a(8);
      boolean bool2 = bool1;
      int k = i3;
      int m = i4;
      continue;
      label217:
      if (localMode1 == Mode.f)
      {
        localCharacterSetECI = CharacterSetECI.a(a(localBitSource));
        if (localCharacterSetECI == null) {
          throw FormatException.a();
        }
      }
      else
      {
        if (localMode1 == Mode.j)
        {
          int i1 = localBitSource.a(4);
          int i2 = localBitSource.a(localMode1.a(paramVersion));
          if (i1 != 1) {
            break label518;
          }
          a(localBitSource, localStringBuilder, i2);
          break label518;
        }
        int n = localBitSource.a(localMode1.a(paramVersion));
        if (localMode1 == Mode.b)
        {
          c(localBitSource, localStringBuilder, n);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        if (localMode1 == Mode.c)
        {
          a(localBitSource, localStringBuilder, n, bool1);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        if (localMode1 == Mode.e)
        {
          a(localBitSource, localStringBuilder, n, localCharacterSetECI, localArrayList, paramMap);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        if (localMode1 == Mode.g)
        {
          b(localBitSource, localStringBuilder, n);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        throw FormatException.a();
        localObject = localArrayList;
        continue;
        str2 = paramErrorCorrectionLevel.toString();
        continue;
        bool2 = bool1;
        k = j;
        m = i;
        continue;
        label474:
        i = m;
        j = k;
        bool1 = bool2;
        continue;
        label489:
        bool2 = true;
        k = j;
        m = i;
        continue;
      }
      label443:
      label450:
      label459:
      bool2 = bool1;
      k = j;
      m = i;
      continue;
      label518:
      bool2 = bool1;
      k = j;
      m = i;
    }
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.c()) {
      throw FormatException.a();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.a(13);
      int k = j / 96 << 8 | j % 96;
      if (k < 959) {}
      for (int m = k + 41377;; m = k + 42657)
      {
        arrayOfByte[i] = ((byte)(0xFF & m >> 8));
        arrayOfByte[(i + 1)] = ((byte)(m & 0xFF));
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw FormatException.a();
    }
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap)
  {
    if (paramInt << 3 > paramBitSource.c()) {
      throw FormatException.a();
    }
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < paramInt; i++) {
      arrayOfByte[i] = ((byte)paramBitSource.a(8));
    }
    if (paramCharacterSetECI == null) {}
    for (String str = StringUtils.a(arrayOfByte, paramMap);; str = paramCharacterSetECI.name()) {
      try
      {
        paramStringBuilder.append(new String(arrayOfByte, str));
        paramCollection.add(arrayOfByte);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw FormatException.a();
      }
    }
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      if (paramBitSource.c() < 11) {
        throw FormatException.a();
      }
      int j = paramBitSource.a(11);
      paramStringBuilder.append(a(j / 45));
      paramStringBuilder.append(a(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1)
    {
      if (paramBitSource.c() < 6) {
        throw FormatException.a();
      }
      paramStringBuilder.append(a(paramBitSource.a(6)));
    }
    if (paramBoolean) {
      if (i < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(i) == '%')
        {
          if ((i >= -1 + paramStringBuilder.length()) || (paramStringBuilder.charAt(i + 1) != '%')) {
            break label159;
          }
          paramStringBuilder.deleteCharAt(i + 1);
        }
        for (;;)
        {
          i++;
          break;
          label159:
          paramStringBuilder.setCharAt(i, '\035');
        }
      }
    }
  }
  
  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.c()) {
      throw FormatException.a();
    }
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.a(13);
      int k = j / 192 << 8 | j % 192;
      if (k < 7936) {}
      for (int m = k + 33088;; m = k + 49472)
      {
        arrayOfByte[i] = ((byte)(m >> 8));
        arrayOfByte[(i + 1)] = ((byte)m);
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw FormatException.a();
    }
  }
  
  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    while (paramInt >= 3)
    {
      if (paramBitSource.c() < 10) {
        throw FormatException.a();
      }
      int k = paramBitSource.a(10);
      if (k >= 1000) {
        throw FormatException.a();
      }
      paramStringBuilder.append(a(k / 100));
      paramStringBuilder.append(a(k / 10 % 10));
      paramStringBuilder.append(a(k % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramBitSource.c() < 7) {
        throw FormatException.a();
      }
      j = paramBitSource.a(7);
      if (j >= 100) {
        throw FormatException.a();
      }
      paramStringBuilder.append(a(j / 10));
      paramStringBuilder.append(a(j % 10));
    }
    while (paramInt != 1)
    {
      int j;
      return;
    }
    if (paramBitSource.c() < 4) {
      throw FormatException.a();
    }
    int i = paramBitSource.a(4);
    if (i >= 10) {
      throw FormatException.a();
    }
    paramStringBuilder.append(a(i));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.DecodedBitStreamParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */