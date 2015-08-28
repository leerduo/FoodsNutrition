package m.framework.utils;

import java.security.MessageDigest;

public class Data
{
  private static Hashon a = new Hashon();
  
  public static String a(String paramString)
  {
    if (paramString == null) {}
    byte[] arrayOfByte;
    do
    {
      return null;
      arrayOfByte = b(paramString);
    } while (arrayOfByte == null);
    return HEX.a(arrayOfByte);
  }
  
  public static byte[] b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("utf-8"));
      byte[] arrayOfByte = localMessageDigest.digest();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.utils.Data
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */