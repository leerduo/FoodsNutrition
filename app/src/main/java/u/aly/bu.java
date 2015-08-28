package u.aly;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

public class bu
{
  public static int a;
  
  public static byte[] a(String paramString1, String paramString2)
  {
    if (bv.c(paramString1)) {
      return null;
    }
    return a(paramString1.getBytes(paramString2));
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    byte[] arrayOfByte = new byte[8192];
    a = 0;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        for (;;)
        {
          if (localDeflater.finished())
          {
            localDeflater.end();
            if (localByteArrayOutputStream != null) {
              localByteArrayOutputStream.close();
            }
            return localByteArrayOutputStream.toByteArray();
          }
          int i = localDeflater.deflate(arrayOfByte);
          a = i + a;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        if (localByteArrayOutputStream == null) {
          break label107;
        }
      }
      finally {}
      localByteArrayOutputStream.close();
      label107:
      throw localObject1;
    }
    finally
    {
      Object localObject2 = localObject3;
      ByteArrayOutputStream localByteArrayOutputStream = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bu
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */