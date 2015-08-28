package cn.sharesdk.framework.utils;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class f
{
  private File a;
  private HashMap<String, Object> b;
  
  private void a()
  {
    if (this.b == null) {}
    while (this.a == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.a.getParentFile().exists()) {
          this.a.getParentFile().mkdirs();
        }
        FileOutputStream localFileOutputStream;
        synchronized (this.b)
        {
          localFileOutputStream = new FileOutputStream(this.a);
          if (localFileOutputStream.getChannel().tryLock() != null)
          {
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localFileOutputStream);
            localObjectOutputStream.writeObject(this.b);
            localObjectOutputStream.flush();
            localObjectOutputStream.close();
            return;
          }
        }
        localFileOutputStream.close();
      }
      catch (Throwable localThrowable)
      {
        e.c(localThrowable);
        return;
      }
    }
  }
  
  private void b(String paramString, Object paramObject)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    this.b.put(paramString, paramObject);
  }
  
  private Object e(String paramString)
  {
    if (this.b == null) {
      return null;
    }
    return this.b.get(paramString);
  }
  
  public void a(String paramString)
  {
    try
    {
      this.a = new File(paramString);
      if (!this.a.exists()) {
        return;
      }
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream(this.a));
      this.b = ((HashMap)localObjectInputStream.readObject());
      localObjectInputStream.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
  }
  
  public void a(String paramString, Long paramLong)
  {
    b(paramString, paramLong);
    a();
  }
  
  public void a(String paramString, Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      a(paramString, Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
    a();
  }
  
  public String b(String paramString)
  {
    Object localObject = e(paramString);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    return String.valueOf(localObject);
  }
  
  public long c(String paramString)
  {
    Object localObject = e(paramString);
    if (localObject == null) {
      return 0L;
    }
    if ((localObject instanceof Long)) {
      return ((Long)localObject).longValue();
    }
    return 0L;
  }
  
  public Object d(String paramString)
  {
    try
    {
      ObjectInputStream localObjectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(b(paramString), 2)));
      Object localObject = localObjectInputStream.readObject();
      localObjectInputStream.close();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      e.b(localThrowable);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */