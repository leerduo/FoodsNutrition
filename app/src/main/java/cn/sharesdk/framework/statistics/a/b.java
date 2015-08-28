package cn.sharesdk.framework.statistics.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.e;

public class b
{
  private static b c = null;
  private Context a;
  private a b;
  
  private b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new a(this.a);
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new b(paramContext);
      }
      b localb = c;
      return localb;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    Cursor localCursor = null;
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    try
    {
      localCursor = localSQLiteDatabase.rawQuery("select count(*) from " + paramString, null);
      boolean bool = localCursor.moveToNext();
      int i = 0;
      if (bool)
      {
        int j = localCursor.getInt(0);
        i = j;
      }
      return i;
    }
    catch (Exception localException)
    {
      e.c(localException);
      return 0;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    try
    {
      int j = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
      i = j;
      Object[] arrayOfObject;
      Exception localException2;
    }
    catch (Exception localException1)
    {
      try
      {
        arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = paramString1;
        e.a("Deleted %d rows from table: %s", arrayOfObject);
        return i;
      }
      catch (Exception localException3)
      {
        int i;
        break label63;
      }
      localException1 = localException1;
      localException2 = localException1;
      i = 0;
    }
    label63:
    // INTERNAL ERROR //

/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.a.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */