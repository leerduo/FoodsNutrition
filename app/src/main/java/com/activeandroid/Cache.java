package com.activeandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.util.LruCache;
import com.activeandroid.serializer.TypeSerializer;
import com.activeandroid.util.Log;
import java.util.Collection;

public final class Cache
{
  private static Context a;
  private static ModelInfo b;
  private static DatabaseHelper c;
  private static LruCache<String, Model> d;
  private static boolean e = false;
  
  public static Model a(Class<? extends Model> paramClass, long paramLong)
  {
    try
    {
      Model localModel = (Model)d.get(a(paramClass, Long.valueOf(paramLong)));
      return localModel;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TableInfo a(Class<? extends Model> paramClass)
  {
    try
    {
      TableInfo localTableInfo = b.a(paramClass);
      return localTableInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String a(Model paramModel)
  {
    return a(paramModel.getClass(), paramModel.getId());
  }
  
  public static String a(Class<? extends Model> paramClass, Long paramLong)
  {
    return c(paramClass) + "@" + paramLong;
  }
  
  public static void a()
  {
    try
    {
      c();
      d = null;
      b = null;
      c = null;
      e = false;
      Log.a("ActiveAndroid disposed. Call initialize to use library.");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void a(Configuration paramConfiguration)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/activeandroid/Cache:e	Z
    //   6: ifeq +13 -> 19
    //   9: ldc 90
    //   11: invokestatic 87	com/activeandroid/util/Log:a	(Ljava/lang/String;)I
    //   14: pop
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokevirtual 95	com/activeandroid/Configuration:a	()Landroid/content/Context;
    //   23: putstatic 97	com/activeandroid/Cache:a	Landroid/content/Context;
    //   26: new 44	com/activeandroid/ModelInfo
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 99	com/activeandroid/ModelInfo:<init>	(Lcom/activeandroid/Configuration;)V
    //   34: putstatic 42	com/activeandroid/Cache:b	Lcom/activeandroid/ModelInfo;
    //   37: new 101	com/activeandroid/DatabaseHelper
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 102	com/activeandroid/DatabaseHelper:<init>	(Lcom/activeandroid/Configuration;)V
    //   45: putstatic 80	com/activeandroid/Cache:c	Lcom/activeandroid/DatabaseHelper;
    //   48: new 33	android/support/v4/util/LruCache
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 106	com/activeandroid/Configuration:g	()I
    //   56: invokespecial 109	android/support/v4/util/LruCache:<init>	(I)V
    //   59: putstatic 22	com/activeandroid/Cache:d	Landroid/support/v4/util/LruCache;
    //   62: invokestatic 112	com/activeandroid/Cache:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   65: pop
    //   66: iconst_1
    //   67: putstatic 19	com/activeandroid/Cache:e	Z
    //   70: ldc 114
    //   72: invokestatic 87	com/activeandroid/util/Log:a	(Ljava/lang/String;)I
    //   75: pop
    //   76: goto -61 -> 15
    //   79: astore_1
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramConfiguration	Configuration
    //   79	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	79	finally
    //   19	76	79	finally
  }
  
  public static SQLiteDatabase b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TypeSerializer b(Class<?> paramClass)
  {
    try
    {
      TypeSerializer localTypeSerializer = b.b(paramClass);
      return localTypeSerializer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(Model paramModel)
  {
    try
    {
      d.put(a(paramModel), paramModel);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String c(Class<? extends Model> paramClass)
  {
    try
    {
      String str = b.a(paramClass).b();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void c()
  {
    try
    {
      c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void c(Model paramModel)
  {
    try
    {
      d.remove(a(paramModel));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Context d()
  {
    return a;
  }
  
  public static Collection<TableInfo> e()
  {
    try
    {
      Collection localCollection = b.a();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.Cache
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */