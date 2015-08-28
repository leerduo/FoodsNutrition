package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class BinaryCodec
  implements BinaryDecoder, BinaryEncoder
{
  private static final int[] BITS = { 1, 2, 4, 8, 16, 32, 64, 128 };
  private static final int BIT_0 = 1;
  private static final int BIT_1 = 2;
  private static final int BIT_2 = 4;
  private static final int BIT_3 = 8;
  private static final int BIT_4 = 16;
  private static final int BIT_5 = 32;
  private static final int BIT_6 = 64;
  private static final int BIT_7 = 128;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final char[] EMPTY_CHAR_ARRAY = new char[0];
  
  static
  {
    EMPTY_BYTE_ARRAY = new byte[0];
  }
  
  public static byte[] fromAscii(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length >> 3];
    int i = -1 + paramArrayOfByte.length;
    int j = 0;
    while (j < arrayOfByte.length)
    {
      for (int k = 0; k < BITS.length; k++) {
        if (paramArrayOfByte[(i - k)] == 49) {
          arrayOfByte[j] = ((byte)(arrayOfByte[j] | BITS[k]));
        }
      }
      j++;
      i -= 8;
    }
    return arrayOfByte;
  }
  
  public static byte[] fromAscii(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramArrayOfChar.length >> 3];
    int i = -1 + paramArrayOfChar.length;
    int j = 0;
    while (j < arrayOfByte.length)
    {
      for (int k = 0; k < BITS.length; k++) {
        if (paramArrayOfChar[(i - k)] == '1') {
          arrayOfByte[j] = ((byte)(arrayOfByte[j] | BITS[k]));
        }
      }
      j++;
      i -= 8;
    }
    return arrayOfByte;
  }
  
  public static byte[] toAsciiBytes(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length << 3];
    int i = -1 + arrayOfByte.length;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = 0;
      if (k < BITS.length)
      {
        if ((paramArrayOfByte[j] & BITS[k]) == 0) {
          arrayOfByte[(i - k)] = 48;
        }
        for (;;)
        {
          k++;
          break;
          arrayOfByte[(i - k)] = 49;
        }
      }
      j++;
      i -= 8;
    }
    return arrayOfByte;
  }
  
  public static char[] toAsciiChars(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return EMPTY_CHAR_ARRAY;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length << 3];
    int i = -1 + arrayOfChar.length;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = 0;
      if (k < BITS.length)
      {
        if ((paramArrayOfByte[j] & BITS[k]) == 0) {
          arrayOfChar[(i - k)] = '0';
        }
        for (;;)
        {
          k++;
          break;
          arrayOfChar[(i - k)] = '1';
        }
      }
      j++;
      i -= 8;
    }
    return arrayOfChar;
  }
  
  public static String toAsciiString(byte[] paramArrayOfByte)
  {
    return new String(toAsciiChars(paramArrayOfByte));
  }
  
  public Object decode(Object paramObject)
  {
    if (paramObject == null) {
      return EMPTY_BYTE_ARRAY;
    }
    if ((paramObject instanceof byte[])) {
      return fromAscii((byte[])paramObject);
    }
    if ((paramObject instanceof char[])) {
      return fromAscii((char[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return fromAscii(((String)paramObject).toCharArray());
    }
    throw new DecoderException("argument not a byte array");
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return fromAscii(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
  {
    if (!(paramObject instanceof byte[])) {
      throw new EncoderException("argument not a byte array");
    }
    return toAsciiChars((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return toAsciiBytes(paramArrayOfByte);
  }
  
  public byte[] toByteArray(String paramString)
  {
    if (paramString == null) {
      return EMPTY_BYTE_ARRAY;
    }
    return fromAscii(paramString.toCharArray());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.binary.BinaryCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */