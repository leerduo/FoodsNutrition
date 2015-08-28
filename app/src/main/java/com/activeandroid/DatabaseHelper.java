package com.activeandroid;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.activeandroid.util.Log;
import com.activeandroid.util.SQLiteUtils;
import com.activeandroid.util.SqlParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class DatabaseHelper
  extends SQLiteOpenHelper
{
  private final String a;
  
  public DatabaseHelper(Configuration paramConfiguration)
  {
    super(paramConfiguration.a(), paramConfiguration.b(), null, paramConfiguration.c());
    a(paramConfiguration.a(), paramConfiguration.b());
    this.a = paramConfiguration.d();
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (SQLiteUtils.a)
    {
      paramSQLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");
      Log.b("Foreign Keys supported. Enabling foreign key features.");
    }
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, InputStream paramInputStream)
  {
    Iterator localIterator = SqlParser.a(paramInputStream).iterator();
    while (localIterator.hasNext()) {
      paramSQLiteDatabase.execSQL((String)localIterator.next());
    }
  }
  
  /* Error */
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 84	com/activeandroid/Cache:d	()Landroid/content/Context;
    //   5: invokevirtual 90	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: new 92	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   15: ldc 97
    //   17: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokevirtual 110	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore_3
    //   31: ldc 112
    //   33: aload_0
    //   34: getfield 32	com/activeandroid/DatabaseHelper:a	Ljava/lang/String;
    //   37: invokevirtual 116	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   40: ifeq +14 -> 54
    //   43: aload_0
    //   44: aload_1
    //   45: aload_3
    //   46: invokespecial 118	com/activeandroid/DatabaseHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/io/InputStream;)V
    //   49: aload_3
    //   50: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   53: return
    //   54: aload_0
    //   55: aload_1
    //   56: aload_3
    //   57: invokespecial 125	com/activeandroid/DatabaseHelper:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/io/InputStream;)V
    //   60: goto -11 -> 49
    //   63: astore 5
    //   65: new 92	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   72: ldc 127
    //   74: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_2
    //   78: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: aload 5
    //   86: invokestatic 130	com/activeandroid/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   89: pop
    //   90: aload_3
    //   91: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   94: return
    //   95: astore 4
    //   97: aload_3
    //   98: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   101: aload 4
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	DatabaseHelper
    //   0	104	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	104	2	paramString	String
    //   1	97	3	localInputStream	InputStream
    //   95	7	4	localObject	Object
    //   63	22	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	49	63	java/io/IOException
    //   54	60	63	java/io/IOException
    //   2	49	95	finally
    //   54	60	95	finally
    //   65	90	95	finally
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 84	com/activeandroid/Cache:d	()Landroid/content/Context;
    //   6: invokevirtual 90	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: ldc 135
    //   11: invokevirtual 139	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   14: invokestatic 145	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   17: astore 7
    //   19: aload 7
    //   21: new 147	com/activeandroid/util/NaturalOrderComparator
    //   24: dup
    //   25: invokespecial 148	com/activeandroid/util/NaturalOrderComparator:<init>	()V
    //   28: invokestatic 154	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   31: aload_1
    //   32: invokevirtual 157	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   35: aload 7
    //   37: invokeinterface 65 1 0
    //   42: astore 9
    //   44: aload 9
    //   46: invokeinterface 71 1 0
    //   51: ifeq +134 -> 185
    //   54: aload 9
    //   56: invokeinterface 75 1 0
    //   61: checkcast 77	java/lang/String
    //   64: astore 10
    //   66: aload 10
    //   68: ldc 159
    //   70: ldc 161
    //   72: invokevirtual 165	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   75: invokestatic 171	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   78: invokevirtual 174	java/lang/Integer:intValue	()I
    //   81: istore 13
    //   83: iload 13
    //   85: iload_2
    //   86: if_icmple +43 -> 129
    //   89: iload 13
    //   91: iload_3
    //   92: if_icmpgt +37 -> 129
    //   95: aload_0
    //   96: aload_1
    //   97: aload 10
    //   99: invokespecial 176	com/activeandroid/DatabaseHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   102: iconst_1
    //   103: istore 4
    //   105: new 92	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   112: aload 10
    //   114: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 178
    //   119: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 53	com/activeandroid/util/Log:b	(Ljava/lang/String;)I
    //   128: pop
    //   129: goto -85 -> 44
    //   132: astore 11
    //   134: new 92	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   141: ldc 180
    //   143: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 10
    //   148: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload 11
    //   156: invokestatic 182	com/activeandroid/util/Log:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   159: pop
    //   160: goto -31 -> 129
    //   163: astore 8
    //   165: aload_1
    //   166: invokevirtual 185	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   169: aload 8
    //   171: athrow
    //   172: astore 5
    //   174: ldc 187
    //   176: aload 5
    //   178: invokestatic 130	com/activeandroid/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   181: pop
    //   182: iload 4
    //   184: ireturn
    //   185: aload_1
    //   186: invokevirtual 190	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   189: aload_1
    //   190: invokevirtual 185	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   193: iload 4
    //   195: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	DatabaseHelper
    //   0	196	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	196	2	paramInt1	int
    //   0	196	3	paramInt2	int
    //   1	193	4	bool	boolean
    //   172	5	5	localIOException	IOException
    //   17	19	7	localList	List
    //   163	7	8	localObject	Object
    //   42	13	9	localIterator	Iterator
    //   64	83	10	str	String
    //   132	23	11	localNumberFormatException	java.lang.NumberFormatException
    //   81	12	13	i	int
    // Exception table:
    //   from	to	target	type
    //   66	83	132	java/lang/NumberFormatException
    //   95	102	132	java/lang/NumberFormatException
    //   105	129	132	java/lang/NumberFormatException
    //   35	44	163	finally
    //   44	66	163	finally
    //   66	83	163	finally
    //   95	102	163	finally
    //   105	129	163	finally
    //   134	160	163	finally
    //   185	189	163	finally
    //   3	35	172	java/io/IOException
    //   165	172	172	java/io/IOException
    //   189	193	172	java/io/IOException
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      Iterator localIterator = Cache.e().iterator();
      while (localIterator.hasNext())
      {
        String[] arrayOfString = SQLiteUtils.b((TableInfo)localIterator.next());
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++) {
          paramSQLiteDatabase.execSQL(arrayOfString[j]);
        }
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  private void b(SQLiteDatabase paramSQLiteDatabase, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 204	java/io/InputStreamReader
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 207	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_3
    //   9: new 209	java/io/BufferedReader
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 212	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 215	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore 7
    //   26: aload 7
    //   28: ifnull +52 -> 80
    //   31: aload 7
    //   33: ldc 217
    //   35: ldc 161
    //   37: invokevirtual 165	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   40: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   43: astore 8
    //   45: aload 8
    //   47: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne -31 -> 19
    //   53: aload_1
    //   54: aload 8
    //   56: invokevirtual 46	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   59: goto -40 -> 19
    //   62: astore 5
    //   64: aload_3
    //   65: astore 6
    //   67: aload 4
    //   69: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   72: aload 6
    //   74: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   77: aload 5
    //   79: athrow
    //   80: aload 4
    //   82: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   85: aload_3
    //   86: invokestatic 123	com/activeandroid/util/IOUtils:a	(Ljava/io/Closeable;)V
    //   89: return
    //   90: astore 5
    //   92: aconst_null
    //   93: astore 4
    //   95: aconst_null
    //   96: astore 6
    //   98: goto -31 -> 67
    //   101: astore 5
    //   103: aload_3
    //   104: astore 6
    //   106: aconst_null
    //   107: astore 4
    //   109: goto -42 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	DatabaseHelper
    //   0	112	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	112	2	paramInputStream	InputStream
    //   8	96	3	localInputStreamReader1	java.io.InputStreamReader
    //   17	91	4	localBufferedReader	java.io.BufferedReader
    //   62	16	5	localObject1	Object
    //   90	1	5	localObject2	Object
    //   101	1	5	localObject3	Object
    //   65	40	6	localInputStreamReader2	java.io.InputStreamReader
    //   24	8	7	str1	String
    //   43	12	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   19	26	62	finally
    //   31	59	62	finally
    //   0	9	90	finally
    //   9	19	101	finally
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      Iterator localIterator = Cache.e().iterator();
      while (localIterator.hasNext()) {
        paramSQLiteDatabase.execSQL(SQLiteUtils.c((TableInfo)localIterator.next()));
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    paramSQLiteDatabase.endTransaction();
  }
  
  public void a(Context paramContext, String paramString)
  {
    File localFile = paramContext.getDatabasePath(paramString);
    if (localFile.exists()) {
      return;
    }
    localFile.getParentFile().mkdirs();
    InputStream localInputStream;
    FileOutputStream localFileOutputStream;
    try
    {
      localInputStream = paramContext.getAssets().open(paramString);
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte, 0, 8192);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileOutputStream.flush();
    }
    catch (IOException localIOException)
    {
      Log.b("Failed to open file", localIOException);
      return;
    }
    localFileOutputStream.close();
    localInputStream.close();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    c(paramSQLiteDatabase);
    a(paramSQLiteDatabase, -1, paramSQLiteDatabase.getVersion());
    b(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(paramSQLiteDatabase);
    c(paramSQLiteDatabase);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.DatabaseHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */