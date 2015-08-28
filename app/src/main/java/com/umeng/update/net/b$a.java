package com.umeng.update.net;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class b$a
  extends SQLiteOpenHelper
{
  private static final int b = 2;
  private static final String c = "CREATE TABLE umeng_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);";
  
  b$a(b paramb, Context paramContext)
  {
    super(paramContext, "UMENG_DATA", null, 2);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    u.upd.b.c(b.a(), "CREATE TABLE umeng_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
    paramSQLiteDatabase.execSQL("CREATE TABLE umeng_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.b.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */