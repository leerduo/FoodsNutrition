package com.activeandroid;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.activeandroid.content.ContentProvider;
import com.activeandroid.query.Delete;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.activeandroid.serializer.TypeSerializer;
import com.activeandroid.util.Log;
import com.activeandroid.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class Model
{
  private static final int HASH_PRIME = 739;
  private final String idName = this.mTableInfo.c();
  private Long mId = null;
  private final TableInfo mTableInfo = Cache.a(getClass());
  
  public static void delete(Class<? extends Model> paramClass, long paramLong)
  {
    TableInfo localTableInfo = Cache.a(paramClass);
    From localFrom = new Delete().a(paramClass);
    String str = localTableInfo.c() + "=?";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    localFrom.a(str, arrayOfObject).b();
  }
  
  public static <T extends Model> T load(Class<T> paramClass, long paramLong)
  {
    TableInfo localTableInfo = Cache.a(paramClass);
    From localFrom = new Select().a(paramClass);
    String str = localTableInfo.c() + "=?";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    return localFrom.a(str, arrayOfObject).c();
  }
  
  public final void delete()
  {
    SQLiteDatabase localSQLiteDatabase = Cache.b();
    String str1 = this.mTableInfo.b();
    String str2 = this.idName + "=?";
    String[] arrayOfString = new String[1];
    arrayOfString[0] = getId().toString();
    localSQLiteDatabase.delete(str1, str2, arrayOfString);
    Cache.c(this);
    Cache.d().getContentResolver().notifyChange(ContentProvider.a(this.mTableInfo.a(), this.mId), null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof Model)) && (this.mId != null))
    {
      localModel = (Model)paramObject;
      if ((!this.mId.equals(localModel.mId)) || (!this.mTableInfo.b().equals(localModel.mTableInfo.b()))) {}
    }
    while (this == paramObject)
    {
      Model localModel;
      return true;
      return false;
    }
    return false;
  }
  
  public final Long getId()
  {
    return this.mId;
  }
  
  protected final <T extends Model> List<T> getMany(Class<T> paramClass, String paramString)
  {
    From localFrom = new Select().a(paramClass);
    String str = Cache.c(paramClass) + "." + paramString + "=?";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getId();
    return localFrom.a(str, arrayOfObject).b();
  }
  
  public int hashCode()
  {
    if (this.mId == null) {}
    for (int i = super.hashCode();; i = this.mId.hashCode()) {
      return 739 + i * 739 + 739 * this.mTableInfo.b().hashCode();
    }
  }
  
  public final void loadFromCursor(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramCursor.getColumnNames()));
    Iterator localIterator = this.mTableInfo.d().iterator();
    Field localField1;
    Class localClass;
    int i;
    while (localIterator.hasNext())
    {
      localField1 = (Field)localIterator.next();
      String str1 = this.mTableInfo.a(localField1);
      localClass = localField1.getType();
      i = localArrayList.indexOf(str1);
      if (i >= 0) {
        localField1.setAccessible(true);
      }
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = paramCursor.isNull(i);
        localTypeSerializer = Cache.b(localClass);
        if (localTypeSerializer == null) {
          break label824;
        }
        localClass = localTypeSerializer.b();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        TypeSerializer localTypeSerializer;
        Log.b(localIllegalArgumentException.getClass().getName(), localIllegalArgumentException);
        break;
        if ((!localClass.equals(Byte.class)) && (!localClass.equals(Byte.TYPE))) {
          continue;
        }
        Integer localInteger1 = Integer.valueOf(paramCursor.getInt(i));
        localField2 = localField1;
        localObject = localInteger1;
        continue;
        if ((!localClass.equals(Short.class)) && (!localClass.equals(Short.TYPE))) {
          continue;
        }
        Integer localInteger2 = Integer.valueOf(paramCursor.getInt(i));
        localField2 = localField1;
        localObject = localInteger2;
        continue;
        if ((!localClass.equals(Integer.class)) && (!localClass.equals(Integer.TYPE))) {
          continue;
        }
        Integer localInteger3 = Integer.valueOf(paramCursor.getInt(i));
        localField2 = localField1;
        localObject = localInteger3;
        continue;
        if ((!localClass.equals(Long.class)) && (!localClass.equals(Long.TYPE))) {
          continue;
        }
        Long localLong = Long.valueOf(paramCursor.getLong(i));
        localField2 = localField1;
        localObject = localLong;
        continue;
        if ((!localClass.equals(Float.class)) && (!localClass.equals(Float.TYPE))) {
          continue;
        }
        Float localFloat = Float.valueOf(paramCursor.getFloat(i));
        localField2 = localField1;
        localObject = localFloat;
        continue;
        if ((!localClass.equals(Double.class)) && (!localClass.equals(Double.TYPE))) {
          continue;
        }
        Double localDouble = Double.valueOf(paramCursor.getDouble(i));
        localField2 = localField1;
        localObject = localDouble;
        continue;
        if ((!localClass.equals(Boolean.class)) && (!localClass.equals(Boolean.TYPE))) {
          continue;
        }
        if (paramCursor.getInt(i) == 0) {
          break label838;
        }
        bool2 = true;
        Boolean localBoolean = Boolean.valueOf(bool2);
        localField2 = localField1;
        localObject = localBoolean;
        continue;
        if ((!localClass.equals(Character.class)) && (!localClass.equals(Character.TYPE))) {
          continue;
        }
        Character localCharacter = Character.valueOf(paramCursor.getString(i).charAt(0));
        localField2 = localField1;
        localObject = localCharacter;
        continue;
        if (!localClass.equals(String.class)) {
          continue;
        }
        String str3 = paramCursor.getString(i);
        localField2 = localField1;
        localObject = str3;
        continue;
        if ((!localClass.equals([Ljava.lang.Byte.class)) && (!localClass.equals([B.class))) {
          continue;
        }
        byte[] arrayOfByte = paramCursor.getBlob(i);
        localField2 = localField1;
        localObject = arrayOfByte;
        continue;
        if (!ReflectionUtils.a(localClass)) {
          continue;
        }
        long l = paramCursor.getLong(i);
        localModel1 = Cache.a(localClass, l);
        if (localModel1 != null) {
          break label844;
        }
        From localFrom = new Select().a(localClass);
        String str2 = this.idName + "=?";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Long.valueOf(l);
        localModel1 = localFrom.a(str2, arrayOfObject).c();
        break label844;
        if (!ReflectionUtils.a(localClass, Enum.class)) {
          break label814;
        }
        Enum localEnum = Enum.valueOf(localClass, paramCursor.getString(i));
        localField2 = localField1;
        localObject = localEnum;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.b(localIllegalAccessException.getClass().getName(), localIllegalAccessException);
        break;
      }
      catch (SecurityException localSecurityException)
      {
        Log.b(localSecurityException.getClass().getName(), localSecurityException);
      }
      if ((localTypeSerializer != null) && (!bool1)) {
        localObject = localTypeSerializer.c(localObject);
      }
      if (localObject == null) {
        break;
      }
      localField2.set(this, localObject);
      break;
      boolean bool2;
      Model localModel1;
      break;
      if (this.mId != null) {
        Cache.b(this);
      }
      return;
      label814:
      Field localField2 = localField1;
      Object localObject = null;
      continue;
      label824:
      if (bool1)
      {
        localObject = null;
        localField2 = null;
        continue;
        label838:
        bool2 = false;
        continue;
        label844:
        Model localModel2 = localModel1;
        localField2 = localField1;
        localObject = localModel2;
      }
    }
  }
  
  public final Long save()
  {
    SQLiteDatabase localSQLiteDatabase = Cache.b();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = this.mTableInfo.d().iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      String str = this.mTableInfo.a(localField);
      Class localClass = localField.getType();
      localField.setAccessible(true);
      Object localObject;
      try
      {
        localObject = localField.get(this);
        if (localObject != null)
        {
          TypeSerializer localTypeSerializer = Cache.b(localClass);
          if (localTypeSerializer != null)
          {
            localObject = localTypeSerializer.d(localObject);
            if (localObject != null)
            {
              localClass = localObject.getClass();
              if (!localClass.equals(localTypeSerializer.b()))
              {
                Object[] arrayOfObject = new Object[2];
                arrayOfObject[0] = localTypeSerializer.b();
                arrayOfObject[1] = localClass;
                Log.c(String.format("TypeSerializer returned wrong type: expected a %s but got a %s", arrayOfObject));
              }
            }
          }
        }
        if (localObject == null) {
          localContentValues.putNull(str);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.b(localIllegalArgumentException.getClass().getName(), localIllegalArgumentException);
        continue;
        if ((!localClass.equals(Byte.class)) && (!localClass.equals(Byte.TYPE))) {
          break label248;
        }
        localContentValues.put(str, (Byte)localObject);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.b(localIllegalAccessException.getClass().getName(), localIllegalAccessException);
      }
      continue;
      label248:
      if ((localClass.equals(Short.class)) || (localClass.equals(Short.TYPE))) {
        localContentValues.put(str, (Short)localObject);
      } else if ((localClass.equals(Integer.class)) || (localClass.equals(Integer.TYPE))) {
        localContentValues.put(str, (Integer)localObject);
      } else if ((localClass.equals(Long.class)) || (localClass.equals(Long.TYPE))) {
        localContentValues.put(str, (Long)localObject);
      } else if ((localClass.equals(Float.class)) || (localClass.equals(Float.TYPE))) {
        localContentValues.put(str, (Float)localObject);
      } else if ((localClass.equals(Double.class)) || (localClass.equals(Double.TYPE))) {
        localContentValues.put(str, (Double)localObject);
      } else if ((localClass.equals(Boolean.class)) || (localClass.equals(Boolean.TYPE))) {
        localContentValues.put(str, (Boolean)localObject);
      } else if ((localClass.equals(Character.class)) || (localClass.equals(Character.TYPE))) {
        localContentValues.put(str, localObject.toString());
      } else if (localClass.equals(String.class)) {
        localContentValues.put(str, localObject.toString());
      } else if ((localClass.equals([Ljava.lang.Byte.class)) || (localClass.equals([B.class))) {
        localContentValues.put(str, (byte[])localObject);
      } else if (ReflectionUtils.a(localClass)) {
        localContentValues.put(str, ((Model)localObject).getId());
      } else if (ReflectionUtils.a(localClass, Enum.class)) {
        localContentValues.put(str, ((Enum)localObject).name());
      }
    }
    if (this.mId == null) {
      this.mId = Long.valueOf(localSQLiteDatabase.insert(this.mTableInfo.b(), null, localContentValues));
    }
    for (;;)
    {
      Cache.d().getContentResolver().notifyChange(ContentProvider.a(this.mTableInfo.a(), this.mId), null);
      return this.mId;
      localSQLiteDatabase.update(this.mTableInfo.b(), localContentValues, this.idName + "=" + this.mId, null);
    }
  }
  
  public String toString()
  {
    return this.mTableInfo.b() + "@" + getId();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.Model
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */