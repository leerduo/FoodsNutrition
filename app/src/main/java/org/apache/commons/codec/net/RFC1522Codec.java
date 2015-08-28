package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

abstract class RFC1522Codec
{
  protected String decodeText(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ((!paramString.startsWith("=?")) || (!paramString.endsWith("?="))) {
      throw new DecoderException("RFC 1522 violation: malformed encoded content");
    }
    int i = -2 + paramString.length();
    int j = paramString.indexOf("?", 2);
    if ((j == -1) || (j == i)) {
      throw new DecoderException("RFC 1522 violation: charset token not found");
    }
    String str1 = paramString.substring(2, j);
    if (str1.equals("")) {
      throw new DecoderException("RFC 1522 violation: charset not specified");
    }
    int k = j + 1;
    int m = paramString.indexOf("?", k);
    if ((m == -1) || (m == i)) {
      throw new DecoderException("RFC 1522 violation: encoding token not found");
    }
    String str2 = paramString.substring(k, m);
    if (!getEncoding().equalsIgnoreCase(str2)) {
      throw new DecoderException("This codec cannot decode " + str2 + " encoded content");
    }
    int n = m + 1;
    return new String(doDecoding(paramString.substring(n, paramString.indexOf("?", n)).getBytes("US-ASCII")), str1);
  }
  
  protected abstract byte[] doDecoding(byte[] paramArrayOfByte);
  
  protected abstract byte[] doEncoding(byte[] paramArrayOfByte);
  
  protected String encodeText(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("=?");
    localStringBuffer.append(paramString2);
    localStringBuffer.append('?');
    localStringBuffer.append(getEncoding());
    localStringBuffer.append('?');
    localStringBuffer.append(new String(doEncoding(paramString1.getBytes(paramString2)), "US-ASCII"));
    localStringBuffer.append("?=");
    return localStringBuffer.toString();
  }
  
  protected abstract String getEncoding();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.net.RFC1522Codec
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */