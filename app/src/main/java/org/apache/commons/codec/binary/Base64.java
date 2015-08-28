package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Base64
  implements BinaryDecoder, BinaryEncoder
{
  static final int BASELENGTH = 255;
  static final byte[] CHUNK_SEPARATOR;
  static final int CHUNK_SIZE = 76;
  static final int EIGHTBIT = 8;
  static final int FOURBYTE = 4;
  static final int LOOKUPLENGTH = 64;
  static final byte PAD = 61;
  static final int SIGN = -128;
  static final int SIXTEENBIT = 16;
  static final int TWENTYFOURBITGROUP = 24;
  private static byte[] base64Alphabet;
  private static byte[] lookUpBase64Alphabet;
  
  static
  {
    int i = 0;
    CHUNK_SEPARATOR = "\r\n".getBytes();
    base64Alphabet = new byte['ÿ'];
    lookUpBase64Alphabet = new byte[64];
    for (int j = 0; j < 255; j++) {
      base64Alphabet[j] = -1;
    }
    for (int k = 90; k >= 65; k--) {
      base64Alphabet[k] = ((byte)(k - 65));
    }
    for (int m = 122; m >= 97; m--) {
      base64Alphabet[m] = ((byte)(26 + (m - 97)));
    }
    for (int n = 57; n >= 48; n--) {
      base64Alphabet[n] = ((byte)(52 + (n - 48)));
    }
    base64Alphabet[43] = 62;
    base64Alphabet[47] = 63;
    for (int i1 = 0; i1 <= 25; i1++) {
      lookUpBase64Alphabet[i1] = ((byte)(i1 + 65));
    }
    int i2 = 26;
    for (int i3 = 0; i2 <= 51; i3++)
    {
      lookUpBase64Alphabet[i2] = ((byte)(i3 + 97));
      i2++;
    }
    int i4 = 52;
    while (i4 <= 61)
    {
      lookUpBase64Alphabet[i4] = ((byte)(i + 48));
      i4++;
      i++;
    }
    lookUpBase64Alphabet[62] = 43;
    lookUpBase64Alphabet[63] = 47;
  }
  
  public static byte[] decodeBase64(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte1 = discardNonBase64(paramArrayOfByte);
    if (arrayOfByte1.length == 0)
    {
      arrayOfByte2 = new byte[0];
      return arrayOfByte2;
    }
    int j = arrayOfByte1.length / 4;
    int k = arrayOfByte1.length;
    while (arrayOfByte1[(k - 1)] == 61)
    {
      k--;
      if (k == 0) {
        return new byte[0];
      }
    }
    byte[] arrayOfByte2 = new byte[k - j];
    int m = 0;
    label62:
    int i1;
    int i2;
    int i3;
    int i4;
    if (i < j)
    {
      int n = i * 4;
      i1 = arrayOfByte1[(n + 2)];
      i2 = arrayOfByte1[(n + 3)];
      i3 = base64Alphabet[arrayOfByte1[n]];
      i4 = base64Alphabet[arrayOfByte1[(n + 1)]];
      if ((i1 == 61) || (i2 == 61)) {
        break label201;
      }
      int i6 = base64Alphabet[i1];
      int i7 = base64Alphabet[i2];
      arrayOfByte2[m] = ((byte)(i3 << 2 | i4 >> 4));
      arrayOfByte2[(m + 1)] = ((byte)((i4 & 0xF) << 4 | 0xF & i6 >> 2));
      arrayOfByte2[(m + 2)] = ((byte)(i7 | i6 << 6));
    }
    for (;;)
    {
      m += 3;
      i++;
      break label62;
      break;
      label201:
      if (i1 == 61)
      {
        arrayOfByte2[m] = ((byte)(i3 << 2 | i4 >> 4));
      }
      else if (i2 == 61)
      {
        int i5 = base64Alphabet[i1];
        arrayOfByte2[m] = ((byte)(i3 << 2 | i4 >> 4));
        arrayOfByte2[(m + 1)] = ((byte)((i4 & 0xF) << 4 | 0xF & i5 >> 2));
      }
    }
  }
  
  static byte[] discardNonBase64(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      if (isBase64(paramArrayOfByte[i]))
      {
        int k = j + 1;
        arrayOfByte1[j] = paramArrayOfByte[i];
        j = k;
      }
      i++;
    }
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    return arrayOfByte2;
  }
  
  static byte[] discardWhitespace(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      switch (paramArrayOfByte[i])
      {
      default: 
        int k = j + 1;
        arrayOfByte1[j] = paramArrayOfByte[i];
        j = k;
      }
      i++;
    }
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    return arrayOfByte2;
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 8 * paramArrayOfByte.length;
    int j = i % 24;
    int k = i / 24;
    int m;
    int n;
    label46:
    byte[] arrayOfByte;
    int i1;
    int i2;
    int i3;
    int i4;
    label77:
    int i16;
    int i17;
    int i18;
    int i21;
    label142:
    int i22;
    label157:
    int i23;
    label173:
    int i24;
    int i25;
    int i26;
    if (j != 0)
    {
      m = 4 * (k + 1);
      n = 0;
      if (paramBoolean)
      {
        if (CHUNK_SEPARATOR.length != 0) {
          break label327;
        }
        n = 0;
        m += n * CHUNK_SEPARATOR.length;
      }
      arrayOfByte = new byte[m];
      i1 = 76;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      if (i3 >= k) {
        break label386;
      }
      int i15 = i3 * 3;
      i16 = paramArrayOfByte[i15];
      i17 = paramArrayOfByte[(i15 + 1)];
      i18 = paramArrayOfByte[(i15 + 2)];
      int i19 = (byte)(i17 & 0xF);
      int i20 = (byte)(i16 & 0x3);
      if ((i16 & 0xFFFFFF80) != 0) {
        break label343;
      }
      i21 = (byte)(i16 >> 2);
      if ((i17 & 0xFFFFFF80) != 0) {
        break label357;
      }
      i22 = (byte)(i17 >> 4);
      if ((i18 & 0xFFFFFF80) != 0) {
        break label371;
      }
      i23 = (byte)(i18 >> 6);
      arrayOfByte[i4] = lookUpBase64Alphabet[i21];
      arrayOfByte[(i4 + 1)] = lookUpBase64Alphabet[(i22 | i20 << 4)];
      arrayOfByte[(i4 + 2)] = lookUpBase64Alphabet[(i23 | i19 << 2)];
      arrayOfByte[(i4 + 3)] = lookUpBase64Alphabet[(i18 & 0x3F)];
      i24 = i4 + 4;
      if ((!paramBoolean) || (i24 != i1)) {
        break label667;
      }
      System.arraycopy(CHUNK_SEPARATOR, 0, arrayOfByte, i24, CHUNK_SEPARATOR.length);
      i25 = i2 + 1;
      i26 = 76 * (i25 + 1) + i25 * CHUNK_SEPARATOR.length;
    }
    for (int i27 = i24 + CHUNK_SEPARATOR.length;; i27 = i24)
    {
      i3++;
      i4 = i27;
      i1 = i26;
      i2 = i25;
      break label77;
      m = k * 4;
      break;
      label327:
      n = (int)Math.ceil(m / 76.0F);
      break label46;
      label343:
      i21 = (byte)(0xC0 ^ i16 >> 2);
      break label142;
      label357:
      i22 = (byte)(0xF0 ^ i17 >> 4);
      break label157;
      label371:
      i23 = (byte)(0xFC ^ i18 >> 6);
      break label173;
      label386:
      int i5 = i3 * 3;
      if (j == 8)
      {
        i12 = paramArrayOfByte[i5];
        i13 = (byte)(i12 & 0x3);
        if ((i12 & 0xFFFFFF80) == 0)
        {
          i14 = (byte)(i12 >> 2);
          arrayOfByte[i4] = lookUpBase64Alphabet[i14];
          arrayOfByte[(i4 + 1)] = lookUpBase64Alphabet[(i13 << 4)];
          arrayOfByte[(i4 + 2)] = 61;
          arrayOfByte[(i4 + 3)] = 61;
        }
      }
      while (j != 16) {
        for (;;)
        {
          int i12;
          int i13;
          if ((paramBoolean) && (i2 < n)) {
            System.arraycopy(CHUNK_SEPARATOR, 0, arrayOfByte, m - CHUNK_SEPARATOR.length, CHUNK_SEPARATOR.length);
          }
          return arrayOfByte;
          int i14 = (byte)(0xC0 ^ i12 >> 2);
        }
      }
      int i6 = paramArrayOfByte[i5];
      int i7 = paramArrayOfByte[(i5 + 1)];
      int i8 = (byte)(i7 & 0xF);
      int i9 = (byte)(i6 & 0x3);
      int i10;
      if ((i6 & 0xFFFFFF80) == 0)
      {
        i10 = (byte)(i6 >> 2);
        label568:
        if ((i7 & 0xFFFFFF80) != 0) {
          break label653;
        }
      }
      label653:
      for (int i11 = (byte)(i7 >> 4);; i11 = (byte)(0xF0 ^ i7 >> 4))
      {
        arrayOfByte[i4] = lookUpBase64Alphabet[i10];
        arrayOfByte[(i4 + 1)] = lookUpBase64Alphabet[(i11 | i9 << 4)];
        arrayOfByte[(i4 + 2)] = lookUpBase64Alphabet[(i8 << 2)];
        arrayOfByte[(i4 + 3)] = 61;
        break;
        i10 = (byte)(0xC0 ^ i6 >> 2);
        break label568;
      }
      label667:
      i25 = i2;
      i26 = i1;
    }
  }
  
  public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, true);
  }
  
  public static boolean isArrayByteBase64(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = discardWhitespace(paramArrayOfByte);
    int i = arrayOfByte.length;
    if (i == 0) {}
    for (;;)
    {
      return true;
      for (int j = 0; j < i; j++) {
        if (!isBase64(arrayOfByte[j])) {
          return false;
        }
      }
    }
  }
  
  private static boolean isBase64(byte paramByte)
  {
    if (paramByte == 61) {}
    while (base64Alphabet[paramByte] != -1) {
      return true;
    }
    return false;
  }
  
  public Object decode(Object paramObject)
  {
    if (!(paramObject instanceof byte[])) {
      throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
    }
    return decode((byte[])paramObject);
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return decodeBase64(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof byte[])) {
      throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
    }
    return encode((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.binary.Base64
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */