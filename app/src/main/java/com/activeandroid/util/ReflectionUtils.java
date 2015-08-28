package com.activeandroid.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.serializer.TypeSerializer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class ReflectionUtils
{
  public static <T> T a(Context paramContext, String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo.metaData != null)
      {
        Object localObject = localApplicationInfo.metaData.get(paramString);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.c("Couldn't find meta-data: " + paramString);
    }
    return null;
  }
  
  public static boolean a(Class<?> paramClass)
  {
    return (a(paramClass, Model.class)) && (!Modifier.isAbstract(paramClass.getModifiers()));
  }
  
  public static boolean a(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass1.getSuperclass() != null)
    {
      if (paramClass1.getSuperclass().equals(paramClass2)) {
        return true;
      }
      return a(paramClass1.getSuperclass(), paramClass2);
    }
    return false;
  }
  
  public static boolean b(Class<?> paramClass)
  {
    return a(paramClass, TypeSerializer.class);
  }
  
  public static Set<Field> c(Class<?> paramClass)
  {
    Object localObject = Collections.emptySet();
    if ((a(paramClass, Model.class)) || (Model.class.equals(paramClass)))
    {
      localObject = new LinkedHashSet();
      Field[] arrayOfField = paramClass.getDeclaredFields();
      Arrays.sort(arrayOfField, new ReflectionUtils.1());
      int i = arrayOfField.length;
      for (int j = 0; j < i; j++)
      {
        Field localField = arrayOfField[j];
        if (localField.isAnnotationPresent(Column.class)) {
          ((Set)localObject).add(localField);
        }
      }
      Class localClass = paramClass.getSuperclass();
      if (localClass != null) {
        ((Set)localObject).addAll(c(localClass));
      }
    }
    return localObject;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.ReflectionUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */