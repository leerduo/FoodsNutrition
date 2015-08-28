package m.framework.utils;

public class HEX
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuffer.toString();
      }
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Byte.valueOf(paramArrayOfByte[i]);
      localStringBuffer.append(String.format("%02x", arrayOfObject));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.utils.HEX
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */