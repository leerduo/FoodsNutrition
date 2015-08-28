package com.activeandroid;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.activeandroid.serializer.TypeSerializer;
import com.activeandroid.util.Log;
import com.activeandroid.util.ReflectionUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class ModelInfo
{
  private Map<Class<? extends Model>, TableInfo> a = new HashMap();
  private Map<Class<?>, TypeSerializer> b = new ModelInfo.1(this);
  
  public ModelInfo(Configuration paramConfiguration)
  {
    if (!a(paramConfiguration)) {}
    try
    {
      a(paramConfiguration.a());
      Log.b("ModelInfo loaded.");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.b("Couldn't open source path.", localIOException);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    String str2 = paramContext.getApplicationInfo().sourceDir;
    ArrayList localArrayList = new ArrayList();
    Enumeration localEnumeration2;
    if ((str2 != null) && (!new File(str2).isDirectory())) {
      localEnumeration2 = new DexFile(str2).entries();
    }
    while (localEnumeration2.hasMoreElements())
    {
      localArrayList.add(localEnumeration2.nextElement());
      continue;
      Enumeration localEnumeration1 = Thread.currentThread().getContextClassLoader().getResources("");
      while (localEnumeration1.hasMoreElements())
      {
        String str3 = ((URL)localEnumeration1.nextElement()).getFile();
        if ((str3.contains("bin")) || (str3.contains("classes"))) {
          localArrayList.add(str3);
        }
      }
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      a(new File((String)localIterator.next()), str1, paramContext.getClassLoader());
    }
  }
  
  private void a(File paramFile, String paramString, ClassLoader paramClassLoader)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      for (int k = 0; k < j; k++) {
        a(arrayOfFile[k], paramString, paramClassLoader);
      }
    }
    String str1 = paramFile.getName();
    String str3;
    int i;
    if (!paramFile.getPath().equals(str1))
    {
      String str2 = paramFile.getPath();
      if (str2.endsWith(".class"))
      {
        str3 = str2.substring(0, -6 + str2.length()).replace(System.getProperty("file.separator"), ".");
        i = str3.lastIndexOf(paramString);
        if (i >= 0) {
          break label119;
        }
      }
    }
    for (;;)
    {
      return;
      label119:
      str1 = str3.substring(i);
      try
      {
        localClass = Class.forName(str1, false, paramClassLoader);
        if (ReflectionUtils.a(localClass))
        {
          this.a.put(localClass, new TableInfo(localClass));
          return;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Class localClass;
        Log.b("Couldn't create class.", localClassNotFoundException);
        return;
        if (ReflectionUtils.b(localClass))
        {
          TypeSerializer localTypeSerializer = (TypeSerializer)localClass.newInstance();
          this.b.put(localTypeSerializer.a(), localTypeSerializer);
          return;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        Log.b("Couldn't instantiate TypeSerializer.", localInstantiationException);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.b("IllegalAccessException", localIllegalAccessException);
      }
    }
  }
  
  private boolean a(Configuration paramConfiguration)
  {
    if (!paramConfiguration.h()) {
      return false;
    }
    List localList1 = paramConfiguration.e();
    if (localList1 != null)
    {
      Iterator localIterator2 = localList1.iterator();
      while (localIterator2.hasNext())
      {
        Class localClass2 = (Class)localIterator2.next();
        this.a.put(localClass2, new TableInfo(localClass2));
      }
    }
    List localList2 = paramConfiguration.f();
    if (localList2 != null)
    {
      Iterator localIterator1 = localList2.iterator();
      while (localIterator1.hasNext())
      {
        Class localClass1 = (Class)localIterator1.next();
        try
        {
          TypeSerializer localTypeSerializer = (TypeSerializer)localClass1.newInstance();
          this.b.put(localTypeSerializer.a(), localTypeSerializer);
        }
        catch (InstantiationException localInstantiationException)
        {
          Log.b("Couldn't instantiate TypeSerializer.", localInstantiationException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.b("IllegalAccessException", localIllegalAccessException);
        }
      }
    }
    return true;
  }
  
  public TableInfo a(Class<? extends Model> paramClass)
  {
    return (TableInfo)this.a.get(paramClass);
  }
  
  public Collection<TableInfo> a()
  {
    return this.a.values();
  }
  
  public TypeSerializer b(Class<?> paramClass)
  {
    return (TypeSerializer)this.b.get(paramClass);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.ModelInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */