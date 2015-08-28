package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QCodec
  extends RFC1522Codec
  implements StringDecoder, StringEncoder
{
  private static byte BLANK = 32;
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  private static byte UNDERSCORE = 95;
  private String charset = "UTF-8";
  private boolean encodeBlanks = false;
  
  static
  {
    PRINTABLE_CHARS.set(32);
    PRINTABLE_CHARS.set(33);
    PRINTABLE_CHARS.set(34);
    PRINTABLE_CHARS.set(35);
    PRINTABLE_CHARS.set(36);
    PRINTABLE_CHARS.set(37);
    PRINTABLE_CHARS.set(38);
    PRINTABLE_CHARS.set(39);
    PRINTABLE_CHARS.set(40);
    PRINTABLE_CHARS.set(41);
    PRINTABLE_CHARS.set(42);
    PRINTABLE_CHARS.set(43);
    PRINTABLE_CHARS.set(44);
    PRINTABLE_CHARS.set(45);
    PRINTABLE_CHARS.set(46);
    PRINTABLE_CHARS.set(47);
    for (int i = 48; i <= 57; i++) {
      PRINTABLE_CHARS.set(i);
    }
    PRINTABLE_CHARS.set(58);
    PRINTABLE_CHARS.set(59);
    PRINTABLE_CHARS.set(60);
    PRINTABLE_CHARS.set(62);
    PRINTABLE_CHARS.set(64);
    for (int j = 65; j <= 90; j++) {
      PRINTABLE_CHARS.set(j);
    }
    PRINTABLE_CHARS.set(91);
    PRINTABLE_CHARS.set(92);
    PRINTABLE_CHARS.set(93);
    PRINTABLE_CHARS.set(94);
    PRINTABLE_CHARS.set(96);
    for (int k = 97; k <= 122; k++) {
      PRINTABLE_CHARS.set(k);
    }
    PRINTABLE_CHARS.set(123);
    PRINTABLE_CHARS.set(124);
    PRINTABLE_CHARS.set(125);
    PRINTABLE_CHARS.set(126);
  }
  
  public QCodec() {}
  
  public QCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public Object decode(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof String)) {
      return decode((String)paramObject);
    }
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using Q codec");
  }
  
  public String decode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = decodeText(paramString);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new DecoderException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  protected byte[] doDecoding(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    int j = 0;
    if (j < paramArrayOfByte.length) {
      if (paramArrayOfByte[j] != UNDERSCORE) {}
    }
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        label39:
        if (i < paramArrayOfByte.length)
        {
          int m = paramArrayOfByte[i];
          if (m != UNDERSCORE) {
            arrayOfByte[i] = m;
          }
          for (;;)
          {
            i++;
            break label39;
            j++;
            break;
            arrayOfByte[i] = BLANK;
          }
        }
        return QuotedPrintableCodec.decodeQuotedPrintable(arrayOfByte);
      }
      return QuotedPrintableCodec.decodeQuotedPrintable(paramArrayOfByte);
    }
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfByte);
    if (this.encodeBlanks) {
      for (int i = 0; i < arrayOfByte.length; i++) {
        if (arrayOfByte[i] == BLANK) {
          arrayOfByte[i] = UNDERSCORE;
        }
      }
    }
    return arrayOfByte;
  }
  
  public Object encode(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof String)) {
      return encode((String)paramObject);
    }
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using Q codec");
  }
  
  public String encode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return encode(paramString, getDefaultCharset());
  }
  
  public String encode(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      String str = encodeText(paramString1, paramString2);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new EncoderException(localUnsupportedEncodingException.getMessage());
    }
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
  
  protected String getEncoding()
  {
    return "Q";
  }
  
  public boolean isEncodeBlanks()
  {
    return this.encodeBlanks;
  }
  
  public void setEncodeBlanks(boolean paramBoolean)
  {
    this.encodeBlanks = paramBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.net.QCodec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */