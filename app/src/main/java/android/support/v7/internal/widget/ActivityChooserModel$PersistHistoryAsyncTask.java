package android.support.v7.internal.widget;

import android.os.AsyncTask;

final class ActivityChooserModel$PersistHistoryAsyncTask
  extends AsyncTask<Object, Void, Void>
{
  private ActivityChooserModel$PersistHistoryAsyncTask(ActivityChooserModel paramActivityChooserModel) {}
  
  /* Error */
  public Void a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: iconst_0
    //   4: aaload
    //   5: checkcast 28	java/util/List
    //   8: astore_3
    //   9: aload_1
    //   10: iconst_1
    //   11: aaload
    //   12: checkcast 30	java/lang/String
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   21: invokestatic 35	android/support/v7/internal/widget/ActivityChooserModel:a	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Landroid/content/Context;
    //   24: aload 4
    //   26: iconst_0
    //   27: invokevirtual 41	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   30: astore 7
    //   32: invokestatic 47	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   35: astore 8
    //   37: aload 8
    //   39: aload 7
    //   41: aconst_null
    //   42: invokeinterface 53 3 0
    //   47: aload 8
    //   49: ldc 55
    //   51: iconst_1
    //   52: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: invokeinterface 65 3 0
    //   60: aload 8
    //   62: aconst_null
    //   63: ldc 67
    //   65: invokeinterface 71 3 0
    //   70: pop
    //   71: aload_3
    //   72: invokeinterface 75 1 0
    //   77: istore 25
    //   79: iload_2
    //   80: iload 25
    //   82: if_icmpge +133 -> 215
    //   85: aload_3
    //   86: iconst_0
    //   87: invokeinterface 79 2 0
    //   92: checkcast 81	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
    //   95: astore 26
    //   97: aload 8
    //   99: aconst_null
    //   100: ldc 83
    //   102: invokeinterface 71 3 0
    //   107: pop
    //   108: aload 8
    //   110: aconst_null
    //   111: ldc 85
    //   113: aload 26
    //   115: getfield 88	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:a	Landroid/content/ComponentName;
    //   118: invokevirtual 94	android/content/ComponentName:flattenToString	()Ljava/lang/String;
    //   121: invokeinterface 98 4 0
    //   126: pop
    //   127: aload 8
    //   129: aconst_null
    //   130: ldc 100
    //   132: aload 26
    //   134: getfield 104	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:b	J
    //   137: invokestatic 107	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   140: invokeinterface 98 4 0
    //   145: pop
    //   146: aload 8
    //   148: aconst_null
    //   149: ldc 109
    //   151: aload 26
    //   153: getfield 113	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:c	F
    //   156: invokestatic 116	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   159: invokeinterface 98 4 0
    //   164: pop
    //   165: aload 8
    //   167: aconst_null
    //   168: ldc 83
    //   170: invokeinterface 119 3 0
    //   175: pop
    //   176: iinc 2 1
    //   179: goto -100 -> 79
    //   182: astore 5
    //   184: invokestatic 122	android/support/v7/internal/widget/ActivityChooserModel:d	()Ljava/lang/String;
    //   187: new 124	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   194: ldc 127
    //   196: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 4
    //   201: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload 5
    //   209: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   212: pop
    //   213: aconst_null
    //   214: areturn
    //   215: aload 8
    //   217: aconst_null
    //   218: ldc 67
    //   220: invokeinterface 119 3 0
    //   225: pop
    //   226: aload 8
    //   228: invokeinterface 143 1 0
    //   233: aload_0
    //   234: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   237: iconst_1
    //   238: invokestatic 146	android/support/v7/internal/widget/ActivityChooserModel:a	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
    //   241: pop
    //   242: aload 7
    //   244: ifnull -31 -> 213
    //   247: aload 7
    //   249: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore 34
    //   256: aconst_null
    //   257: areturn
    //   258: astore 20
    //   260: invokestatic 122	android/support/v7/internal/widget/ActivityChooserModel:d	()Ljava/lang/String;
    //   263: new 124	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   270: ldc 127
    //   272: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   279: invokestatic 154	android/support/v7/internal/widget/ActivityChooserModel:b	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
    //   282: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: aload 20
    //   290: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   293: pop
    //   294: aload_0
    //   295: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   298: iconst_1
    //   299: invokestatic 146	android/support/v7/internal/widget/ActivityChooserModel:a	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
    //   302: pop
    //   303: aload 7
    //   305: ifnull -92 -> 213
    //   308: aload 7
    //   310: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   313: aconst_null
    //   314: areturn
    //   315: astore 23
    //   317: aconst_null
    //   318: areturn
    //   319: astore 16
    //   321: invokestatic 122	android/support/v7/internal/widget/ActivityChooserModel:d	()Ljava/lang/String;
    //   324: new 124	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   331: ldc 127
    //   333: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_0
    //   337: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   340: invokestatic 154	android/support/v7/internal/widget/ActivityChooserModel:b	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
    //   343: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: aload 16
    //   351: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   354: pop
    //   355: aload_0
    //   356: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   359: iconst_1
    //   360: invokestatic 146	android/support/v7/internal/widget/ActivityChooserModel:a	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
    //   363: pop
    //   364: aload 7
    //   366: ifnull -153 -> 213
    //   369: aload 7
    //   371: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   374: aconst_null
    //   375: areturn
    //   376: astore 19
    //   378: aconst_null
    //   379: areturn
    //   380: astore 12
    //   382: invokestatic 122	android/support/v7/internal/widget/ActivityChooserModel:d	()Ljava/lang/String;
    //   385: new 124	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   392: ldc 127
    //   394: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_0
    //   398: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   401: invokestatic 154	android/support/v7/internal/widget/ActivityChooserModel:b	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
    //   404: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: aload 12
    //   412: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   415: pop
    //   416: aload_0
    //   417: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   420: iconst_1
    //   421: invokestatic 146	android/support/v7/internal/widget/ActivityChooserModel:a	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
    //   424: pop
    //   425: aload 7
    //   427: ifnull -214 -> 213
    //   430: aload 7
    //   432: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   435: aconst_null
    //   436: areturn
    //   437: astore 15
    //   439: aconst_null
    //   440: areturn
    //   441: astore 9
    //   443: aload_0
    //   444: getfield 11	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:a	Landroid/support/v7/internal/widget/ActivityChooserModel;
    //   447: iconst_1
    //   448: invokestatic 146	android/support/v7/internal/widget/ActivityChooserModel:a	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
    //   451: pop
    //   452: aload 7
    //   454: ifnull +8 -> 462
    //   457: aload 7
    //   459: invokevirtual 151	java/io/FileOutputStream:close	()V
    //   462: aload 9
    //   464: athrow
    //   465: astore 11
    //   467: goto -5 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	PersistHistoryAsyncTask
    //   0	470	1	paramVarArgs	Object[]
    //   1	176	2	i	int
    //   8	78	3	localList	java.util.List
    //   15	185	4	str	java.lang.String
    //   182	26	5	localFileNotFoundException	java.io.FileNotFoundException
    //   30	428	7	localFileOutputStream	java.io.FileOutputStream
    //   35	192	8	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   441	22	9	localObject	Object
    //   465	1	11	localIOException1	java.io.IOException
    //   380	31	12	localIOException2	java.io.IOException
    //   437	1	15	localIOException3	java.io.IOException
    //   319	31	16	localIllegalStateException	java.lang.IllegalStateException
    //   376	1	19	localIOException4	java.io.IOException
    //   258	31	20	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   315	1	23	localIOException5	java.io.IOException
    //   77	6	25	j	int
    //   95	57	26	localHistoricalRecord	ActivityChooserModel.HistoricalRecord
    //   254	1	34	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   17	32	182	java/io/FileNotFoundException
    //   247	252	254	java/io/IOException
    //   37	79	258	java/lang/IllegalArgumentException
    //   85	176	258	java/lang/IllegalArgumentException
    //   215	233	258	java/lang/IllegalArgumentException
    //   308	313	315	java/io/IOException
    //   37	79	319	java/lang/IllegalStateException
    //   85	176	319	java/lang/IllegalStateException
    //   215	233	319	java/lang/IllegalStateException
    //   369	374	376	java/io/IOException
    //   37	79	380	java/io/IOException
    //   85	176	380	java/io/IOException
    //   215	233	380	java/io/IOException
    //   430	435	437	java/io/IOException
    //   37	79	441	finally
    //   85	176	441	finally
    //   215	233	441	finally
    //   260	294	441	finally
    //   321	355	441	finally
    //   382	416	441	finally
    //   457	462	465	java/io/IOException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.PersistHistoryAsyncTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */