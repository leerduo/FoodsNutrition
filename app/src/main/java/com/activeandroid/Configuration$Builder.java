package com.activeandroid;

import android.content.Context;
import com.activeandroid.serializer.TypeSerializer;
import com.activeandroid.util.Log;
import com.activeandroid.util.ReflectionUtils;
import java.util.ArrayList;
import java.util.List;

public class Configuration$Builder
{
  private Context a;
  private Integer b;
  private String c;
  private Integer d;
  private String e;
  private List<Class<? extends Model>> f;
  private List<Class<? extends TypeSerializer>> g;
  
  public Configuration$Builder(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = Integer.valueOf(1024);
  }
  
  private List<Class<? extends Model>> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    ClassLoader localClassLoader = this.a.getClass().getClassLoader();
    int i = paramArrayOfString.length;
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        String str = paramArrayOfString[j];
        try
        {
          Class localClass = Class.forName(str.trim(), false, localClassLoader);
          if (ReflectionUtils.a(localClass)) {
            localArrayList.add(localClass);
          }
          j++;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          for (;;)
          {
            Log.b("Couldn't create class.", localClassNotFoundException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private String b()
  {
    String str = (String)ReflectionUtils.a(this.a, "AA_DB_NAME");
    if (str == null) {
      str = "Application.db";
    }
    return str;
  }
  
  private List<Class<? extends TypeSerializer>> b(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    ClassLoader localClassLoader = this.a.getClass().getClassLoader();
    int i = paramArrayOfString.length;
    int j = 0;
    for (;;)
    {
      if (j < i)
      {
        String str = paramArrayOfString[j];
        try
        {
          Class localClass = Class.forName(str.trim(), false, localClassLoader);
          if (ReflectionUtils.b(localClass)) {
            localArrayList.add(localClass);
          }
          j++;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          for (;;)
          {
            Log.b("Couldn't create class.", localClassNotFoundException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private int c()
  {
    Integer localInteger = (Integer)ReflectionUtils.a(this.a, "AA_DB_VERSION");
    if ((localInteger == null) || (localInteger.intValue() == 0)) {
      localInteger = Integer.valueOf(1);
    }
    return localInteger.intValue();
  }
  
  private String d()
  {
    String str = (String)ReflectionUtils.a(this.a, "AA_SQL_PARSER");
    if (str == null) {
      str = "legacy";
    }
    return str;
  }
  
  public Configuration a()
  {
    Configuration localConfiguration = new Configuration(this.a, null);
    Configuration.a(localConfiguration, this.b.intValue());
    if (this.c != null)
    {
      Configuration.a(localConfiguration, this.c);
      if (this.d == null) {
        break label122;
      }
      Configuration.b(localConfiguration, this.d.intValue());
      label60:
      if (this.e == null) {
        break label134;
      }
      Configuration.b(localConfiguration, this.e);
      label76:
      if (this.f == null) {
        break label146;
      }
      Configuration.a(localConfiguration, this.f);
      label92:
      if (this.g == null) {
        break label184;
      }
      Configuration.b(localConfiguration, this.g);
    }
    label122:
    String str2;
    label134:
    label146:
    label184:
    do
    {
      return localConfiguration;
      Configuration.a(localConfiguration, b());
      break;
      Configuration.b(localConfiguration, c());
      break label60;
      Configuration.b(localConfiguration, d());
      break label76;
      String str1 = (String)ReflectionUtils.a(this.a, "AA_MODELS");
      if (str1 == null) {
        break label92;
      }
      Configuration.a(localConfiguration, a(str1.split(",")));
      break label92;
      str2 = (String)ReflectionUtils.a(this.a, "AA_SERIALIZERS");
    } while (str2 == null);
    Configuration.b(localConfiguration, b(str2.split(",")));
    return localConfiguration;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.Configuration.Builder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */