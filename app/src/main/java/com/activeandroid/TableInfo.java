package com.activeandroid;

import android.text.TextUtils;
import android.util.Log;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class TableInfo
{
  private Class<? extends Model> a;
  private String b;
  private String c = "Id";
  private Map<Field, String> d = new LinkedHashMap();
  
  public TableInfo(Class<? extends Model> paramClass)
  {
    this.a = paramClass;
    Table localTable = (Table)paramClass.getAnnotation(Table.class);
    if (localTable != null)
    {
      this.b = localTable.a();
      this.c = localTable.b();
    }
    for (;;)
    {
      Field localField1 = a(paramClass);
      this.d.put(localField1, this.c);
      LinkedList localLinkedList = new LinkedList(ReflectionUtils.c(paramClass));
      Collections.reverse(localLinkedList);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        Field localField2 = (Field)localIterator.next();
        if (localField2.isAnnotationPresent(Column.class))
        {
          String str = ((Column)localField2.getAnnotation(Column.class)).a();
          if (TextUtils.isEmpty(str)) {
            str = localField2.getName();
          }
          this.d.put(localField2, str);
        }
      }
      this.b = paramClass.getSimpleName();
    }
  }
  
  private Field a(Class<?> paramClass)
  {
    if (paramClass.equals(Model.class)) {
      try
      {
        localField = paramClass.getDeclaredField("mId");
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("Impossible!", localNoSuchFieldException.toString());
      }
    }
    while (paramClass.getSuperclass() == null)
    {
      Field localField;
      return null;
    }
    return a(paramClass.getSuperclass());
  }
  
  public Class<? extends Model> a()
  {
    return this.a;
  }
  
  public String a(Field paramField)
  {
    return (String)this.d.get(paramField);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Collection<Field> d()
  {
    return this.d.keySet();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.TableInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */