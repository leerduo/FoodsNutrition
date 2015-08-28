package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;

public class Hex
  implements BinaryDecoder, BinaryEncoder
{
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static byte[] decodeHex(char[] paramArrayOfChar)
  {
    int i = 0;
    int j = paramArrayOfChar.length;
    if ((j & 0x1) != 0) {
      throw new DecoderException("Odd number of characters.");
    }
    byte[] arrayOfByte = new byte[j >> 1];
    for (int k = 0; i < j; k++)
    {
      int m = toDigit(paramArrayOfChar[i], i) << 4;
      int n = i + 1;
      int i1 = m | toDigit(paramArrayOfChar[n], n);
      i = n + 1;
      arrayOfByte[k] = ((byte)(i1 & 0xFF));
    }
    return arrayOfByte;
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j << 1];
    for (int k = 0; k < j; k++)
    {
      int m = i + 1;
      arrayOfChar[i] = DIGITS[((0xF0 & paramArrayOfByte[k]) >>> 4)];
      i = m + 1;
      arrayOfChar[m] = DIGITS[(0xF & paramArrayOfByte[k])];
    }
    return arrayOfChar;
  }
  
  protected static int toDigit(char paramChar, int paramInt)
  {
    int i = Character.digit(paramChar, 16);
    if (i == -1) {
      throw new DecoderException("Illegal hexadecimal charcter " + paramChar + " at index " + paramInt);
    }
    return i;
  }
  
  /* Error */
  public Object decode(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 80
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 80	java/lang/String
    //   11: invokevirtual 84	java/lang/String:toCharArray	()[C
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic 86	org/apache/commons/codec/binary/Hex:decodeHex	([C)[B
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 87	[C
    //   24: astore_3
    //   25: goto -10 -> 15
    //   28: astore_2
    //   29: new 37	org/apache/commons/codec/DecoderException
    //   32: dup
    //   33: aload_2
    //   34: invokevirtual 90	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   37: invokespecial 42	org/apache/commons/codec/DecoderException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	Hex
    //   0	41	1	paramObject	Object
    //   28	6	2	localClassCastException	java.lang.ClassCastException
    //   14	11	3	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/lang/ClassCastException
    //   15	20	28	java/lang/ClassCastException
    //   20	25	28	java/lang/ClassCastException
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return decodeHex(new String(paramArrayOfByte).toCharArray());
  }
  
  /* Error */
  public Object encode(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 80
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 80	java/lang/String
    //   11: invokevirtual 99	java/lang/String:getBytes	()[B
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic 101	org/apache/commons/codec/binary/Hex:encodeHex	([B)[C
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 103	[B
    //   24: astore_3
    //   25: goto -10 -> 15
    //   28: astore_2
    //   29: new 105	org/apache/commons/codec/EncoderException
    //   32: dup
    //   33: aload_2
    //   34: invokevirtual 90	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   37: invokespecial 106	org/apache/commons/codec/EncoderException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	Hex
    //   0	41	1	paramObject	Object
    //   28	6	2	localClassCastException	java.lang.ClassCastException
    //   14	11	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/lang/ClassCastException
    //   15	20	28	java/lang/ClassCastException
    //   20	25	28	java/lang/ClassCastException
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return new String(encodeHex(paramArrayOfByte)).getBytes();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.commons.codec.binary.Hex
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */