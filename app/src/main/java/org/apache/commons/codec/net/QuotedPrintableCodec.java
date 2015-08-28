package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QuotedPrintableCodec
  implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
{
  private static byte ESCAPE_CHAR;
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  private static byte SPACE;
  private static byte TAB;
  private String charset = "UTF-8";
  
  static
  {
    ESCAPE_CHAR = 61;
    TAB = 9;
    SPACE = 32;
    for (int i = 33; i <= 60; i++) {
      PRINTABLE_CHARS.set(i);
    }
    for (int j = 62; j <= 126; j++) {
      PRINTABLE_CHARS.set(j);
    }
    PRINTABLE_CHARS.set(TAB);
    PRINTABLE_CHARS.set(SPACE);
  }
  
  public QuotedPrintableCodec() {}
  
  public QuotedPrintableCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public static final byte[] decodeQuotedPrintable(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      if (j == ESCAPE_CHAR)
      {
        int k = i + 1;
        int m;
        int n;
        try
        {
          m = Character.digit((char)paramArrayOfByte[k], 16);
          i = k + 1;
          n = Character.digit((char)paramArrayOfByte[i], 16);
          if ((m == -1) || (n == -1)) {
            throw new DecoderException("Invalid quoted-printable encoding");
          }
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw new DecoderException("Invalid quoted-printable encoding");
        }
        int i1 = (char)(n + (m << 4));
        localByteArrayOutputStream.write(i1);
      }
      for (;;)
      {
        i++;
        break;
        localByteArrayOutputStream.write(j);
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static final void encodeQuotedPrintable(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    paramByteArrayOutputStream.write(ESCAPE_CHAR);
    int i = Character.toUpperCase(Character.forDigit(0xF & paramInt >> 4, 16));
    int j = Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
    paramByteArrayOutputStream.write(i);
    paramByteArrayOutputStream.write(j);
  }
  
  public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramBitSet == null) {
      paramBitSet = PRINTABLE_CHARS;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      if (j < 0) {
        j += 256;
      }
      if (paramBitSet.get(j)) {
        localByteArrayOutputStream.write(j);
      }
      for (;;)
      {
        i++;
        break;
        encodeQuotedPrintable(j, localByteArrayOutputStream);
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public Object decode(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof byte[])) {
      return decode((byte[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return decode((String)paramObject);
    }
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable decoded");
  }
  
  public String decode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = decode(paramString, getDefaultCharset());
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new DecoderException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  public String decode(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    return new String(decode(paramString1.getBytes("US-ASCII")), paramString2);
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return decodeQuotedPrintable(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof byte[])) {
      return encode((byte[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return encode((String)paramObject);
    }
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable encoded");
  }
  
  public String encode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = encode(paramString, getDefaultCharset());
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new EncoderException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  public String encode(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    return new String(encode(paramString1.getBytes(paramString2)), "US-ASCII");
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfByte);
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.net.QuotedPrintableCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */