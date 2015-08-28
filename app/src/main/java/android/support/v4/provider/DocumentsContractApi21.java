package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

class DocumentsContractApi21
{
  private static final String TAG = "DocumentFile";
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException) {}
  }
  
  public static Uri createDirectory(Context paramContext, Uri paramUri, String paramString)
  {
    return createFile(paramContext, paramUri, "vnd.android.document/directory", paramString);
  }
  
  public static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    return DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
  }
  
  /* Error */
  public static Uri[] listFiles(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: aload_1
    //   6: aload_1
    //   7: invokestatic 49	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   10: invokestatic 53	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_3
    //   14: new 55	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 56	java/util/ArrayList:<init>	()V
    //   21: astore 4
    //   23: aload_2
    //   24: aload_3
    //   25: iconst_1
    //   26: anewarray 58	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 60
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 9
    //   42: aload 9
    //   44: astore 6
    //   46: aload 6
    //   48: invokeinterface 72 1 0
    //   53: ifeq +74 -> 127
    //   56: aload 4
    //   58: aload_1
    //   59: aload 6
    //   61: iconst_0
    //   62: invokeinterface 76 2 0
    //   67: invokestatic 79	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   70: invokevirtual 83	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: goto -28 -> 46
    //   77: astore 5
    //   79: ldc 8
    //   81: new 85	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   88: ldc 88
    //   90: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 5
    //   95: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 105	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: aload 6
    //   107: invokestatic 107	android/support/v4/provider/DocumentsContractApi21:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   110: aload 4
    //   112: aload 4
    //   114: invokevirtual 111	java/util/ArrayList:size	()I
    //   117: anewarray 113	android/net/Uri
    //   120: invokevirtual 117	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   123: checkcast 119	[Landroid/net/Uri;
    //   126: areturn
    //   127: aload 6
    //   129: invokestatic 107	android/support/v4/provider/DocumentsContractApi21:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   132: goto -22 -> 110
    //   135: astore 7
    //   137: aconst_null
    //   138: astore 6
    //   140: aload 6
    //   142: invokestatic 107	android/support/v4/provider/DocumentsContractApi21:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   145: aload 7
    //   147: athrow
    //   148: astore 7
    //   150: goto -10 -> 140
    //   153: astore 5
    //   155: aconst_null
    //   156: astore 6
    //   158: goto -79 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   0	161	1	paramUri	Uri
    //   4	20	2	localContentResolver	android.content.ContentResolver
    //   13	12	3	localUri	Uri
    //   21	92	4	localArrayList	java.util.ArrayList
    //   77	17	5	localException1	Exception
    //   153	1	5	localException2	Exception
    //   44	113	6	localCursor1	android.database.Cursor
    //   135	11	7	localObject1	Object
    //   148	1	7	localObject2	Object
    //   40	3	9	localCursor2	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   46	74	77	java/lang/Exception
    //   23	42	135	finally
    //   46	74	148	finally
    //   79	105	148	finally
    //   23	42	153	java/lang/Exception
  }
  
  public static Uri prepareTreeUri(Uri paramUri)
  {
    return DocumentsContract.buildDocumentUriUsingTree(paramUri, DocumentsContract.getTreeDocumentId(paramUri));
  }
  
  public static Uri renameTo(Context paramContext, Uri paramUri, String paramString)
  {
    return DocumentsContract.renameDocument(paramContext.getContentResolver(), paramUri, paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi21
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */