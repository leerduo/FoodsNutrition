package com.activeandroid.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.TableInfo;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Column.ConflictAction;
import com.activeandroid.annotation.Column.ForeignKeyAction;
import com.activeandroid.serializer.TypeSerializer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class SQLiteUtils
{
  public static final boolean a;
  private static final HashMap<Class<?>, SQLiteUtils.SQLiteType> b;
  private static HashMap<String, List<String>> c;
  private static HashMap<String, List<String>> d;
  private static HashMap<String, Column.ConflictAction> e;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new SQLiteUtils.1();
      return;
    }
  }
  
  public static ArrayList<String> a(TableInfo paramTableInfo)
  {
    ArrayList localArrayList = new ArrayList();
    d = new HashMap();
    e = new HashMap();
    Iterator localIterator1 = paramTableInfo.d().iterator();
    while (localIterator1.hasNext()) {
      a(paramTableInfo, (Field)localIterator1.next());
    }
    if (d.isEmpty()) {
      return localArrayList;
    }
    Iterator localIterator2 = d.keySet().iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      List localList = (List)d.get(str);
      Column.ConflictAction localConflictAction = (Column.ConflictAction)e.get(str);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = TextUtils.join(", ", localList);
      arrayOfObject[1] = localConflictAction.toString();
      localArrayList.add(String.format("UNIQUE (%s) ON CONFLICT %s", arrayOfObject));
    }
    return localArrayList;
  }
  
  public static <T extends Model> List<T> a(Class<? extends Model> paramClass, Cursor paramCursor)
  {
    String str = Cache.a(paramClass).c();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      Constructor localConstructor = paramClass.getConstructor(new Class[0]);
      if (paramCursor.moveToFirst())
      {
        ArrayList localArrayList2 = new ArrayList(Arrays.asList(paramCursor.getColumnNames()));
        boolean bool;
        do
        {
          Model localModel = Cache.a(paramClass, paramCursor.getLong(localArrayList2.indexOf(str)));
          if (localModel == null) {
            localModel = (Model)localConstructor.newInstance(new Object[0]);
          }
          localModel.loadFromCursor(paramCursor);
          localArrayList1.add(localModel);
          bool = paramCursor.moveToNext();
        } while (bool);
      }
      return localArrayList1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("Your model " + paramClass.getName() + " does not define a default " + "constructor. The default constructor is required for " + "now in ActiveAndroid models, as the process to " + "populate the ORM model is : " + "1. instantiate default model " + "2. populate fields");
    }
    catch (Exception localException)
    {
      Log.b("Failed to process cursor.", localException);
    }
    return localArrayList1;
  }
  
  public static <T extends Model> List<T> a(Class<? extends Model> paramClass, String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = Cache.b().rawQuery(paramString, paramArrayOfString);
    List localList = a(paramClass, localCursor);
    localCursor.close();
    return localList;
  }
  
  public static void a(TableInfo paramTableInfo, Field paramField)
  {
    String str1 = paramTableInfo.a(paramField);
    Column localColumn = (Column)paramField.getAnnotation(Column.class);
    if (paramField.getName().equals("mId")) {}
    String[] arrayOfString;
    Column.ConflictAction[] arrayOfConflictAction;
    do
    {
      return;
      arrayOfString = localColumn.i();
      arrayOfConflictAction = localColumn.j();
    } while (arrayOfString.length != arrayOfConflictAction.length);
    int i = 0;
    label57:
    String str2;
    Column.ConflictAction localConflictAction;
    if (i < arrayOfString.length)
    {
      str2 = arrayOfString[i];
      localConflictAction = arrayOfConflictAction[i];
      if (!TextUtils.isEmpty(str2)) {
        break label93;
      }
    }
    for (;;)
    {
      i++;
      break label57;
      break;
      label93:
      Object localObject = (List)d.get(str2);
      if (localObject == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(str1);
      d.put(str2, localObject);
      e.put(str2, localConflictAction);
    }
  }
  
  public static void a(String paramString, Object[] paramArrayOfObject)
  {
    Cache.b().execSQL(paramString, paramArrayOfObject);
  }
  
  public static <T extends Model> T b(Class<? extends Model> paramClass, String paramString, String[] paramArrayOfString)
  {
    List localList = a(paramClass, paramString, paramArrayOfString);
    if (localList.size() > 0) {
      return (Model)localList.get(0);
    }
    return null;
  }
  
  public static void b(TableInfo paramTableInfo, Field paramField)
  {
    String str1 = paramTableInfo.a(paramField);
    Column localColumn = (Column)paramField.getAnnotation(Column.class);
    if (paramField.getName().equals("mId")) {
      return;
    }
    if (localColumn.k())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      c.put(str1, localArrayList);
    }
    String[] arrayOfString = localColumn.l();
    int i = arrayOfString.length;
    int j = 0;
    label82:
    String str2;
    if (j < i)
    {
      str2 = arrayOfString[j];
      if (!TextUtils.isEmpty(str2)) {
        break label110;
      }
    }
    for (;;)
    {
      j++;
      break label82;
      break;
      label110:
      Object localObject = (List)c.get(str2);
      if (localObject == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(str1);
      c.put(str2, localObject);
    }
  }
  
  public static String[] b(TableInfo paramTableInfo)
  {
    ArrayList localArrayList = new ArrayList();
    c = new HashMap();
    Iterator localIterator1 = paramTableInfo.d().iterator();
    while (localIterator1.hasNext()) {
      b(paramTableInfo, (Field)localIterator1.next());
    }
    if (c.isEmpty()) {
      return new String[0];
    }
    Iterator localIterator2 = c.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = ("index_" + paramTableInfo.b() + "_" + (String)localEntry.getKey());
      arrayOfObject[1] = paramTableInfo.b();
      arrayOfObject[2] = TextUtils.join(", ", (Iterable)localEntry.getValue());
      localArrayList.add(String.format("CREATE INDEX IF NOT EXISTS %s on %s(%s);", arrayOfObject));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String c(TableInfo paramTableInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramTableInfo.d().iterator();
    while (localIterator.hasNext())
    {
      String str = c(paramTableInfo, (Field)localIterator.next());
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    localArrayList.addAll(a(paramTableInfo));
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramTableInfo.b();
    arrayOfObject[1] = TextUtils.join(", ", localArrayList);
    return String.format("CREATE TABLE IF NOT EXISTS %s (%s);", arrayOfObject);
  }
  
  public static String c(TableInfo paramTableInfo, Field paramField)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class localClass1 = paramField.getType();
    String str = paramTableInfo.a(paramField);
    TypeSerializer localTypeSerializer = Cache.b(paramField.getType());
    Column localColumn = (Column)paramField.getAnnotation(Column.class);
    if (localTypeSerializer != null) {}
    for (Class localClass2 = localTypeSerializer.b();; localClass2 = localClass1)
    {
      if (b.containsKey(localClass2))
      {
        localStringBuilder.append(str);
        localStringBuilder.append(" ");
        localStringBuilder.append(((SQLiteUtils.SQLiteType)b.get(localClass2)).toString());
        if (TextUtils.isEmpty(localStringBuilder)) {
          break label452;
        }
        if (!str.equals(paramTableInfo.c())) {
          break label339;
        }
        localStringBuilder.append(" PRIMARY KEY AUTOINCREMENT");
        label124:
        if ((a) && (ReflectionUtils.a(localClass2)))
        {
          localStringBuilder.append(" REFERENCES ");
          localStringBuilder.append(Cache.a(localClass2).b());
          localStringBuilder.append("(" + paramTableInfo.c() + ")");
          localStringBuilder.append(" ON DELETE ");
          localStringBuilder.append(localColumn.e().toString().replace("_", " "));
          localStringBuilder.append(" ON UPDATE ");
          localStringBuilder.append(localColumn.f().toString().replace("_", " "));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        if (ReflectionUtils.a(localClass2))
        {
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append(SQLiteUtils.SQLiteType.a.toString());
          break;
        }
        if (!ReflectionUtils.a(localClass2, Enum.class)) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append(" ");
        localStringBuilder.append(SQLiteUtils.SQLiteType.c.toString());
        break;
        label339:
        if (localColumn == null) {
          break label124;
        }
        if (localColumn.b() > -1)
        {
          localStringBuilder.append("(");
          localStringBuilder.append(localColumn.b());
          localStringBuilder.append(")");
        }
        if (localColumn.c())
        {
          localStringBuilder.append(" NOT NULL ON CONFLICT ");
          localStringBuilder.append(localColumn.d().toString());
        }
        if (!localColumn.g()) {
          break label124;
        }
        localStringBuilder.append(" UNIQUE ON CONFLICT ");
        localStringBuilder.append(localColumn.h().toString());
        break label124;
        label452:
        Log.d("No type mapping for: " + localClass2.toString());
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.SQLiteUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */