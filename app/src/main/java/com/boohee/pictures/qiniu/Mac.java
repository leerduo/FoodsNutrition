package com.boohee.pictures.qiniu;

import javax.crypto.spec.SecretKeySpec;

public class Mac
{
  public String accessKey;
  public String secretKey;
  
  public Mac(String paramString1, String paramString2)
  {
    this.accessKey = paramString1;
    this.secretKey = paramString2;
  }
  
  public String signWithData(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = this.accessKey.getBytes();
    byte[] arrayOfByte2 = this.secretKey.getBytes();
    try
    {
      byte[] arrayOfByte3 = EncodeUtils.urlsafeEncodeBytes(paramArrayOfByte);
      javax.crypto.Mac localMac = javax.crypto.Mac.getInstance("HmacSHA1");
      localMac.init(new SecretKeySpec(arrayOfByte2, "HmacSHA1"));
      byte[] arrayOfByte4 = EncodeUtils.urlsafeEncodeBytes(localMac.doFinal(arrayOfByte3));
      byte[] arrayOfByte5 = new byte[30 + arrayOfByte1.length + arrayOfByte3.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, arrayOfByte1.length);
      arrayOfByte5[arrayOfByte1.length] = 58;
      System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 1 + arrayOfByte1.length, arrayOfByte4.length);
      arrayOfByte5[(29 + arrayOfByte1.length)] = 58;
      System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 30 + arrayOfByte1.length, arrayOfByte3.length);
      String str = new String(arrayOfByte5);
      return str;
    }
    catch (Exception localException)
    {
      throw new AuthException("Fail to sign with data!", localException);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.qiniu.Mac
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */