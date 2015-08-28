package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.xmpush.thrift.g;
import com.xiaomi.xmpush.thrift.h;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.k;
import com.xiaomi.xmpush.thrift.l;
import com.xiaomi.xmpush.thrift.n;
import com.xiaomi.xmpush.thrift.p;
import com.xiaomi.xmpush.thrift.q;
import com.xiaomi.xmpush.thrift.s;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.w;
import com.xiaomi.xmpush.thrift.x;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.thrift.e;

public class c
{
  private static final byte[] a = { 100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32 };
  
  protected static <T extends org.apache.thrift.b<T, ?>> k a(Context paramContext, T paramT, com.xiaomi.xmpush.thrift.a parama)
  {
    if (!parama.equals(com.xiaomi.xmpush.thrift.a.a)) {}
    for (boolean bool = true;; bool = false) {
      return a(paramContext, paramT, parama, bool);
    }
  }
  
  protected static <T extends org.apache.thrift.b<T, ?>> k a(Context paramContext, T paramT, com.xiaomi.xmpush.thrift.a parama, boolean paramBoolean)
  {
    Object localObject = x.a(paramT);
    if (localObject == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("invoke convertThriftObjectToBytes method, return null.");
      return null;
    }
    k localk = new k();
    byte[] arrayOfByte1;
    if (paramBoolean)
    {
      arrayOfByte1 = com.xiaomi.channel.commonutils.string.a.a(a.a(paramContext).f());
      com.xiaomi.channel.commonutils.logger.b.b(Arrays.toString(arrayOfByte1));
    }
    try
    {
      byte[] arrayOfByte2 = b(arrayOfByte1, (byte[])localObject);
      localObject = arrayOfByte2;
      g localg = new g();
      localg.a = 5L;
      localg.b = "fakeid";
      localk.a(localg);
      localk.a(ByteBuffer.wrap((byte[])localObject));
      localk.a(parama);
      localk.c(true);
      localk.b(paramContext.getPackageName());
      localk.a(paramBoolean);
      localk.a(a.a(paramContext).c());
      return localk;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.c("encryption error. ");
      }
    }
  }
  
  private static Cipher a(byte[] paramArrayOfByte, int paramInt)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte, "AES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(a);
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, localSecretKeySpec, localIvParameterSpec);
    return localCipher;
  }
  
  protected static org.apache.thrift.b a(Context paramContext, k paramk)
  {
    byte[] arrayOfByte2;
    if (paramk.c()) {
      arrayOfByte2 = com.xiaomi.channel.commonutils.string.a.a(a.a(paramContext).f());
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte3 = a(arrayOfByte2, paramk.f());
        arrayOfByte1 = arrayOfByte3;
        org.apache.thrift.b localb = a(paramk.a());
        if (localb != null) {
          x.a(localb, arrayOfByte1);
        }
        return localb;
      }
      catch (Exception localException)
      {
        throw new e("the aes decrypt failed.", localException);
      }
      byte[] arrayOfByte1 = paramk.f();
    }
  }
  
  private static org.apache.thrift.b a(com.xiaomi.xmpush.thrift.a parama)
  {
    switch (c.1.a[parama.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new n();
    case 2: 
      return new u();
    case 3: 
      return new s();
    case 4: 
      return new w();
    case 5: 
      return new q();
    case 6: 
      return new h();
    case 7: 
      return new j();
    case 8: 
      return new p();
    case 9: 
      return new l();
    }
    return new j();
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 2).doFinal(paramArrayOfByte2);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 1).doFinal(paramArrayOfByte2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */