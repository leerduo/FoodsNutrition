package com.boohee.pictures.qiniu;

import org.apache.commons.codec.binary.Base64;

public class EncodeUtils
{
  private static byte[] encodeBase64Ex(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = Base64.encodeBase64(paramArrayOfByte);
    int i = 0;
    if (i < arrayOfByte.length)
    {
      if (arrayOfByte[i] == 47) {
        arrayOfByte[i] = 95;
      }
      for (;;)
      {
        i++;
        break;
        if (arrayOfByte[i] == 43) {
          arrayOfByte[i] = 45;
        }
      }
    }
    return arrayOfByte;
  }
  
  public static byte[] urlsafeEncodeBytes(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1;
    if (paramArrayOfByte.length % 3 == 0) {
      arrayOfByte1 = encodeBase64Ex(paramArrayOfByte);
    }
    do
    {
      return arrayOfByte1;
      arrayOfByte1 = encodeBase64Ex(paramArrayOfByte);
    } while (arrayOfByte1.length % 4 == 0);
    int i = 4 - arrayOfByte1.length % 4;
    byte[] arrayOfByte2 = new byte[i + arrayOfByte1.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    arrayOfByte2[arrayOfByte1.length] = 61;
    if (i > 1) {
      arrayOfByte2[(1 + arrayOfByte1.length)] = 61;
    }
    return arrayOfByte2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.qiniu.EncodeUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */