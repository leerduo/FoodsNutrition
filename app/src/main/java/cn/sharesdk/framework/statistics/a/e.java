package cn.sharesdk.framework.statistics.a;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;

public class e
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  
  /* Error */
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull +16 -> 20
    //   7: aload_1
    //   8: invokevirtual 23	java/lang/String:trim	()Ljava/lang/String;
    //   11: astore 7
    //   13: aload 7
    //   15: ldc 25
    //   17: if_acmpne +14 -> 31
    //   20: ldc2_w 26
    //   23: lstore 4
    //   25: ldc 2
    //   27: monitorexit
    //   28: lload 4
    //   30: lreturn
    //   31: aload_0
    //   32: invokestatic 32	cn/sharesdk/framework/statistics/a/b:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a/b;
    //   35: astore 8
    //   37: new 34	android/content/ContentValues
    //   40: dup
    //   41: invokespecial 37	android/content/ContentValues:<init>	()V
    //   44: astore 9
    //   46: aload 9
    //   48: ldc 39
    //   50: lload_2
    //   51: invokestatic 45	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: invokevirtual 49	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   57: aload 9
    //   59: ldc 51
    //   61: aload_1
    //   62: invokevirtual 54	java/lang/String:toString	()Ljava/lang/String;
    //   65: invokevirtual 57	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload 8
    //   70: ldc 59
    //   72: aload 9
    //   74: invokevirtual 62	cn/sharesdk/framework/statistics/a/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   77: lstore 10
    //   79: lload 10
    //   81: lstore 4
    //   83: goto -58 -> 25
    //   86: astore 6
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload 6
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   0	94	1	paramString	String
    //   0	94	2	paramLong	long
    //   23	59	4	l1	long
    //   86	6	6	localObject	Object
    //   11	3	7	str	String
    //   35	34	8	localb	b
    //   44	29	9	localContentValues	android.content.ContentValues
    //   77	3	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   7	13	86	finally
    //   31	79	86	finally
  }
  
  public static long a(Context paramContext, ArrayList<String> paramArrayList)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < paramArrayList.size(); i++)
      {
        localStringBuilder.append("'");
        localStringBuilder.append((String)paramArrayList.get(i));
        localStringBuilder.append("'");
        localStringBuilder.append(",");
      }
      String str = localStringBuilder.toString().substring(0, -1 + localStringBuilder.length());
      int j = b.a(paramContext).a("message", "_id in ( " + str + " )", null);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(j);
      cn.sharesdk.framework.utils.e.c("delete COUNT == %s", arrayOfObject);
      long l = j;
      return l;
    }
    finally {}
  }
  
  /* Error */
  public static ArrayList<d> a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 32	cn/sharesdk/framework/statistics/a/b:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a/b;
    //   7: ldc 59
    //   9: invokevirtual 115	cn/sharesdk/framework/statistics/a/b:a	(Ljava/lang/String;)I
    //   12: ifle +17 -> 29
    //   15: aload_0
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokestatic 118	cn/sharesdk/framework/statistics/a/e:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   21: astore_3
    //   22: aload_3
    //   23: astore_2
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 68	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 119	java/util/ArrayList:<init>	()V
    //   36: astore_2
    //   37: goto -13 -> 24
    //   40: astore_1
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   40	5	1	localObject	Object
    //   23	14	2	localArrayList1	ArrayList
    //   21	2	3	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   3	22	40	finally
    //   29	37	40	finally
  }
  
  private static ArrayList<d> a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList;
    Cursor localCursor;
    StringBuilder localStringBuilder2;
    d locald2;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        d locald1 = new d();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localCursor = b.a(paramContext).a("message", new String[] { "_id", "post_time", "message_data" }, paramString, paramArrayOfString, null);
        localStringBuilder2 = localStringBuilder1;
        locald2 = locald1;
        if ((localCursor == null) || (!localCursor.moveToNext())) {
          break;
        }
        locald2.b.add(localCursor.getString(0));
        if (locald2.b.size() == 100)
        {
          localStringBuilder2.append(localCursor.getString(2));
          locald2.a = localStringBuilder2.toString();
          localArrayList.add(locald2);
          locald2 = new d();
          localStringBuilder2 = new StringBuilder();
        }
        else
        {
          localStringBuilder2.append(localCursor.getString(2) + "\n");
        }
      }
      finally {}
    }
    localCursor.close();
    if (locald2.b.size() != 0)
    {
      locald2.a = localStringBuilder2.toString().substring(0, -1 + localStringBuilder2.length());
      localArrayList.add(locald2);
    }
    return localArrayList;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.a.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */