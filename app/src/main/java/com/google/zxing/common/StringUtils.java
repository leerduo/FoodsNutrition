package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils
{
  private static final String a = Charset.defaultCharset().name();
  private static final boolean b;
  
  static
  {
    if (("SJIS".equalsIgnoreCase(a)) || ("EUC_JP".equalsIgnoreCase(a))) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap != null)
    {
      String str = (String)paramMap.get(DecodeHintType.e);
      if (str != null) {
        return str;
      }
    }
    int i = paramArrayOfByte.length;
    int j = 1;
    int k = 1;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    label106:
    int i14;
    int i15;
    if ((paramArrayOfByte.length > 3) && (paramArrayOfByte[0] == -17) && (paramArrayOfByte[1] == -69) && (paramArrayOfByte[2] == -65))
    {
      i8 = 1;
      i9 = 0;
      i10 = 0;
      i11 = 0;
      i12 = 1;
      if ((i9 >= i) || ((j == 0) && (k == 0) && (i12 == 0))) {
        break label663;
      }
      i14 = 0xFF & paramArrayOfByte[i9];
      if (i12 == 0) {
        break label896;
      }
      if (m <= 0) {
        break label296;
      }
      if ((i14 & 0x80) != 0) {
        break label286;
      }
      i15 = 0;
    }
    for (;;)
    {
      label158:
      label179:
      int i21;
      int i22;
      int i17;
      int i18;
      int i19;
      int i16;
      if (j != 0)
      {
        if ((i14 > 127) && (i14 < 160)) {
          j = 0;
        }
      }
      else
      {
        if (k == 0) {
          break label865;
        }
        if (i3 <= 0) {
          break label467;
        }
        if ((i14 >= 64) && (i14 != 127) && (i14 <= 252)) {
          break label426;
        }
        int i30 = i6;
        i21 = i11;
        i22 = i30;
        int i31 = i5;
        i17 = i4;
        i18 = i3;
        i19 = 0;
        i16 = i31;
      }
      label663:
      for (;;)
      {
        i9++;
        k = i19;
        i3 = i18;
        i4 = i17;
        i5 = i16;
        i12 = i15;
        int i23 = i21;
        i6 = i22;
        i11 = i23;
        break label106;
        i8 = 0;
        break;
        label286:
        m--;
        i15 = i12;
        break label158;
        label296:
        if ((i14 & 0x80) == 0) {
          break label896;
        }
        if ((i14 & 0x40) == 0)
        {
          i15 = 0;
          break label158;
        }
        m++;
        if ((i14 & 0x20) == 0)
        {
          n++;
          i15 = i12;
          break label158;
        }
        m++;
        if ((i14 & 0x10) == 0)
        {
          i1++;
          i15 = i12;
          break label158;
        }
        m++;
        if ((i14 & 0x8) == 0)
        {
          i2++;
          i15 = i12;
          break label158;
        }
        i15 = 0;
        break label158;
        if ((i14 <= 159) || ((i14 >= 192) && (i14 != 215) && (i14 != 247))) {
          break label179;
        }
        i7++;
        break label179;
        label426:
        int i32 = i3 - 1;
        i19 = k;
        int i33 = i11;
        i22 = i6;
        i21 = i33;
        int i34 = i4;
        i18 = i32;
        i16 = i5;
        i17 = i34;
        continue;
        label467:
        if ((i14 == 128) || (i14 == 160) || (i14 > 239))
        {
          int i24 = i6;
          i21 = i11;
          i22 = i24;
          int i25 = i5;
          i17 = i4;
          i18 = i3;
          i16 = i25;
          i19 = 0;
        }
        else
        {
          int i28;
          if ((i14 > 160) && (i14 < 224))
          {
            i28 = i4 + 1;
            i22 = i5 + 1;
            if (i22 > i6)
            {
              i17 = i28;
              i16 = i22;
              i18 = i3;
              i19 = k;
              i21 = 0;
            }
          }
          else
          {
            int i26;
            int i27;
            if (i14 > 127)
            {
              i26 = i3 + 1;
              i27 = i11 + 1;
              if (i27 > i10)
              {
                i10 = i27;
                i19 = k;
                i22 = i6;
                i21 = i27;
                i17 = i4;
                i18 = i26;
                i16 = 0;
              }
            }
            else
            {
              i17 = i4;
              i18 = i3;
              i19 = k;
              i22 = i6;
              i21 = 0;
              i16 = 0;
              continue;
              if ((i12 != 0) && (m > 0)) {}
              for (int i13 = 0;; i13 = i12)
              {
                if ((k != 0) && (i3 > 0)) {
                  k = 0;
                }
                if ((i13 != 0) && ((i8 != 0) || (i2 + (n + i1) > 0))) {
                  return "UTF8";
                }
                if ((k != 0) && ((b) || (i6 >= 3) || (i10 >= 3))) {
                  return "SJIS";
                }
                if ((j != 0) && (k != 0))
                {
                  if (((i6 == 2) && (i4 == 2)) || (i7 * 10 >= i)) {
                    return "SJIS";
                  }
                  return "ISO8859_1";
                }
                if (j != 0) {
                  return "ISO8859_1";
                }
                if (k != 0) {
                  return "SJIS";
                }
                if (i13 != 0) {
                  return "UTF8";
                }
                return a;
              }
              i19 = k;
              i22 = i6;
              i21 = i27;
              i17 = i4;
              i18 = i26;
              i16 = 0;
              continue;
              i17 = i28;
              i18 = i3;
              i19 = k;
              int i29 = i6;
              i16 = i22;
              i22 = i29;
              i21 = 0;
              continue;
              label865:
              i16 = i5;
              i17 = i4;
              i18 = i3;
              i19 = k;
              int i20 = i6;
              i21 = i11;
              i22 = i20;
            }
          }
        }
      }
      label896:
      i15 = i12;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.StringUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */