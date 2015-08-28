package com.umeng.update.net;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import u.upd.n;

public class b
{
  private static final String a = b.class.getName();
  private static final String b = "umeng_download_task_list";
  private static final String c = "UMENG_DATA";
  private static final String d = "cp";
  private static final String e = "url";
  private static final String f = "progress";
  private static final String g = "last_modified";
  private static final String h = "extra";
  private static Context i;
  private static final String j = "yyyy-MM-dd HH:mm:ss";
  private b.a k = new b.a(this, i);
  
  public static b a(Context paramContext)
  {
    if ((i == null) && (paramContext == null)) {
      throw new NullPointerException();
    }
    if (i == null) {
      i = paramContext;
    }
    return b.b.a;
  }
  
  public List<String> a(String paramString)
  {
    String[] arrayOfString = { paramString };
    Cursor localCursor = this.k.getReadableDatabase().query("umeng_download_task_list", new String[] { "url" }, "cp=?", arrayOfString, null, null, null, "1");
    ArrayList localArrayList = new ArrayList();
    localCursor.moveToFirst();
    for (;;)
    {
      if (localCursor.isAfterLast())
      {
        localCursor.close();
        return localArrayList;
      }
      localArrayList.add(localCursor.getString(0));
      localCursor.moveToNext();
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      Date localDate = new Date(new Date().getTime() - paramInt * 1000);
      String str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate);
      String str2 = " DELETE FROM umeng_download_task_list WHERE strftime('yyyy-MM-dd HH:mm:ss', last_modified)<=strftime('yyyy-MM-dd HH:mm:ss', '" + str1 + "')";
      this.k.getWritableDatabase().execSQL(str2);
      u.upd.b.c(a, "clearOverdueTasks(" + paramInt + ")" + " remove all tasks before " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate));
      return;
    }
    catch (Exception localException)
    {
      u.upd.b.b(a, localException.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("progress", Integer.valueOf(paramInt));
    localContentValues.put("last_modified", n.a());
    String[] arrayOfString = { paramString1, paramString2 };
    this.k.getWritableDatabase().update("umeng_download_task_list", localContentValues, "cp=? and url=?", arrayOfString);
    u.upd.b.c(a, "updateProgress(" + paramString1 + ", " + paramString2 + ", " + paramInt + ")");
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extra", paramString3);
    localContentValues.put("last_modified", n.a());
    String[] arrayOfString = { paramString1, paramString2 };
    this.k.getWritableDatabase().update("umeng_download_task_list", localContentValues, "cp=? and url=?", arrayOfString);
    u.upd.b.c(a, "updateExtra(" + paramString1 + ", " + paramString2 + ", " + paramString3 + ")");
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 176	android/content/ContentValues
    //   3: dup
    //   4: invokespecial 177	android/content/ContentValues:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 15
    //   11: aload_1
    //   12: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_3
    //   16: ldc 18
    //   18: aload_2
    //   19: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_3
    //   23: ldc 21
    //   25: iconst_0
    //   26: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: invokevirtual 187	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   32: aload_3
    //   33: ldc 24
    //   35: invokestatic 191	u/upd/n:a	()Ljava/lang/String;
    //   38: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_2
    //   42: anewarray 70	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_2
    //   52: aastore
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 56	com/umeng/update/net/b:k	Lcom/umeng/update/net/b$a;
    //   59: invokevirtual 74	com/umeng/update/net/b$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: ldc 9
    //   64: iconst_1
    //   65: anewarray 70	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: ldc 21
    //   72: aastore
    //   73: ldc 195
    //   75: aload 4
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: ldc 78
    //   82: invokevirtual 84	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 8
    //   87: aload 8
    //   89: invokeinterface 211 1 0
    //   94: ifle +57 -> 151
    //   97: getstatic 44	com/umeng/update/net/b:a	Ljava/lang/String;
    //   100: new 136	java/lang/StringBuilder
    //   103: dup
    //   104: ldc 213
    //   106: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 203
    //   115: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_2
    //   119: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 215
    //   124: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 217
    //   129: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 168	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_0
    //   139: istore 7
    //   141: aload 8
    //   143: invokeinterface 99 1 0
    //   148: iload 7
    //   150: ireturn
    //   151: aload_0
    //   152: getfield 56	com/umeng/update/net/b:k	Lcom/umeng/update/net/b$a;
    //   155: invokevirtual 151	com/umeng/update/net/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   158: ldc 9
    //   160: aconst_null
    //   161: aload_3
    //   162: invokevirtual 221	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   165: lstore 9
    //   167: lload 9
    //   169: ldc2_w 222
    //   172: lcmp
    //   173: ifne +59 -> 232
    //   176: iconst_0
    //   177: istore 11
    //   179: getstatic 44	com/umeng/update/net/b:a	Ljava/lang/String;
    //   182: new 136	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 213
    //   188: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 203
    //   197: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_2
    //   201: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 215
    //   206: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 225
    //   211: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: lload 9
    //   216: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 168	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: iload 11
    //   227: istore 7
    //   229: goto -88 -> 141
    //   232: iconst_1
    //   233: istore 11
    //   235: goto -56 -> 179
    //   238: astore 5
    //   240: aload 5
    //   242: astore 6
    //   244: iconst_0
    //   245: istore 7
    //   247: getstatic 44	com/umeng/update/net/b:a	Ljava/lang/String;
    //   250: new 136	java/lang/StringBuilder
    //   253: dup
    //   254: ldc 213
    //   256: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   259: aload_1
    //   260: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 203
    //   265: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_2
    //   269: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 215
    //   274: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 6
    //   279: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   282: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: aload 6
    //   290: invokestatic 231	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   293: iload 7
    //   295: ireturn
    //   296: astore 12
    //   298: iload 11
    //   300: istore 7
    //   302: aload 12
    //   304: astore 6
    //   306: goto -59 -> 247
    //   309: astore 6
    //   311: goto -64 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	b
    //   0	314	1	paramString1	String
    //   0	314	2	paramString2	String
    //   7	155	3	localContentValues	ContentValues
    //   53	23	4	arrayOfString	String[]
    //   238	3	5	localException1	Exception
    //   242	63	6	localObject	Object
    //   309	1	6	localException2	Exception
    //   139	162	7	bool1	boolean
    //   85	57	8	localCursor	Cursor
    //   165	50	9	l	long
    //   177	122	11	bool2	boolean
    //   296	7	12	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   41	138	238	java/lang/Exception
    //   151	167	238	java/lang/Exception
    //   179	225	296	java/lang/Exception
    //   141	148	309	java/lang/Exception
  }
  
  public int b(String paramString1, String paramString2)
  {
    String[] arrayOfString = { paramString1, paramString2 };
    Cursor localCursor = this.k.getReadableDatabase().query("umeng_download_task_list", new String[] { "progress" }, "cp=? and url=?", arrayOfString, null, null, null, "1");
    if (localCursor.getCount() > 0) {
      localCursor.moveToFirst();
    }
    for (int m = localCursor.getInt(0);; m = -1)
    {
      localCursor.close();
      return m;
    }
  }
  
  public String c(String paramString1, String paramString2)
  {
    String[] arrayOfString = { paramString1, paramString2 };
    Cursor localCursor = this.k.getReadableDatabase().query("umeng_download_task_list", new String[] { "extra" }, "cp=? and url=?", arrayOfString, null, null, null, "1");
    int m = localCursor.getCount();
    String str = null;
    if (m > 0)
    {
      localCursor.moveToFirst();
      str = localCursor.getString(0);
    }
    localCursor.close();
    return str;
  }
  
  public Date d(String paramString1, String paramString2)
  {
    String[] arrayOfString = { paramString1, paramString2 };
    Cursor localCursor = this.k.getReadableDatabase().query("umeng_download_task_list", new String[] { "last_modified" }, "cp=? and url=?", arrayOfString, null, null, null, null);
    int m = localCursor.getCount();
    Object localObject = null;
    String str;
    if (m > 0)
    {
      localCursor.moveToFirst();
      str = localCursor.getString(0);
      u.upd.b.c(a, "getLastModified(" + paramString1 + ", " + paramString2 + "): " + str);
    }
    try
    {
      Date localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
      localObject = localDate;
      localCursor.close();
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        u.upd.b.c(a, localException.getMessage());
        localObject = null;
      }
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    String[] arrayOfString = { paramString1, paramString2 };
    this.k.getWritableDatabase().delete("umeng_download_task_list", "cp=? and url=?", arrayOfString);
    u.upd.b.c(a, "delete(" + paramString1 + ", " + paramString2 + ")");
  }
  
  public void finalize()
  {
    this.k.close();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.net.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */