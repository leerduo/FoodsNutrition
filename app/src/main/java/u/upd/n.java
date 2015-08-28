package u.upd;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class n
{
  public static final String a = System.getProperty("line.separator");
  
  public static String a()
  {
    return a(new Date());
  }
  
  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte[1024];
    try
    {
      boolean bool = paramFile.isFile();
      if (!bool) {
        return "";
      }
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1)
        {
          localFileInputStream.close();
          return String.format("%1$032x", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (;;)
      {
        if (i >= arrayOfByte2.length) {
          return localStringBuffer.toString();
        }
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(arrayOfByte2[i]);
        localStringBuffer.append(String.format("%02X", arrayOfObject));
        i++;
      }
      return paramString.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
    }
    catch (Exception localException) {}
  }
  
  public static String a(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
  }
  
  public static String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0;; i++)
      {
        if (i >= arrayOfByte.length) {
          return localStringBuffer.toString();
        }
        localStringBuffer.append(Integer.toHexString(0xFF & arrayOfByte[i]));
      }
      return "";
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      b.a("helper", "getMD5 error", localNoSuchAlgorithmException);
    }
  }
  
  public static String c(String paramString)
  {
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l < 1024L) {
        return (int)l + "B";
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return paramString;
    }
    if (l < 1048576L) {
      return new DecimalFormat("#0.00").format((float)l / 1024.0D) + "K";
    }
    if (l < 1073741824L) {
      return new DecimalFormat("#0.00").format((float)l / 1048576.0D) + "M";
    }
    return new DecimalFormat("#0.00").format((float)l / 1073741824.0D) + "G";
  }
  
  public static boolean d(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.upd.n
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */