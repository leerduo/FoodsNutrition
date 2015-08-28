package com.android.volley;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

class VolleyLog$MarkerLog
{
  public static final boolean a = VolleyLog.b;
  private final List<VolleyLog.MarkerLog.Marker> b = new ArrayList();
  private boolean c = false;
  
  private long a()
  {
    if (this.b.size() == 0) {
      return 0L;
    }
    long l = ((VolleyLog.MarkerLog.Marker)this.b.get(0)).c;
    return ((VolleyLog.MarkerLog.Marker)this.b.get(-1 + this.b.size())).c - l;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 28	com/android/volley/VolleyLog$MarkerLog:c	Z
    //   7: aload_0
    //   8: invokespecial 47	com/android/volley/VolleyLog$MarkerLog:a	()J
    //   11: lstore_3
    //   12: lload_3
    //   13: lconst_0
    //   14: lcmp
    //   15: ifgt +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 26	com/android/volley/VolleyLog$MarkerLog:b	Ljava/util/List;
    //   25: iconst_0
    //   26: invokeinterface 39 2 0
    //   31: checkcast 41	com/android/volley/VolleyLog$MarkerLog$Marker
    //   34: getfield 44	com/android/volley/VolleyLog$MarkerLog$Marker:c	J
    //   37: lstore 5
    //   39: iconst_2
    //   40: anewarray 4	java/lang/Object
    //   43: astore 7
    //   45: aload 7
    //   47: iconst_0
    //   48: lload_3
    //   49: invokestatic 53	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: aload 7
    //   55: iconst_1
    //   56: aload_1
    //   57: aastore
    //   58: ldc 55
    //   60: aload 7
    //   62: invokestatic 58	com/android/volley/VolleyLog:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: getfield 26	com/android/volley/VolleyLog$MarkerLog:b	Ljava/util/List;
    //   69: invokeinterface 62 1 0
    //   74: astore 8
    //   76: lload 5
    //   78: lstore 9
    //   80: aload 8
    //   82: invokeinterface 68 1 0
    //   87: ifeq -69 -> 18
    //   90: aload 8
    //   92: invokeinterface 72 1 0
    //   97: checkcast 41	com/android/volley/VolleyLog$MarkerLog$Marker
    //   100: astore 11
    //   102: aload 11
    //   104: getfield 44	com/android/volley/VolleyLog$MarkerLog$Marker:c	J
    //   107: lstore 12
    //   109: iconst_3
    //   110: anewarray 4	java/lang/Object
    //   113: astore 14
    //   115: aload 14
    //   117: iconst_0
    //   118: lload 12
    //   120: lload 9
    //   122: lsub
    //   123: invokestatic 53	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aastore
    //   127: aload 14
    //   129: iconst_1
    //   130: aload 11
    //   132: getfield 74	com/android/volley/VolleyLog$MarkerLog$Marker:b	J
    //   135: invokestatic 53	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: aastore
    //   139: aload 14
    //   141: iconst_2
    //   142: aload 11
    //   144: getfield 77	com/android/volley/VolleyLog$MarkerLog$Marker:a	Ljava/lang/String;
    //   147: aastore
    //   148: ldc 79
    //   150: aload 14
    //   152: invokestatic 58	com/android/volley/VolleyLog:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: lload 12
    //   157: lstore 9
    //   159: goto -79 -> 80
    //   162: astore_2
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	MarkerLog
    //   0	167	1	paramString	String
    //   162	4	2	localObject	Object
    //   11	38	3	l1	long
    //   37	40	5	l2	long
    //   43	18	7	arrayOfObject1	Object[]
    //   74	17	8	localIterator	java.util.Iterator
    //   78	80	9	l3	long
    //   100	43	11	localMarker	VolleyLog.MarkerLog.Marker
    //   107	49	12	l4	long
    //   113	38	14	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   2	12	162	finally
    //   21	76	162	finally
    //   80	155	162	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      if (this.c) {
        throw new IllegalStateException("Marker added to finished log");
      }
    }
    finally {}
    this.b.add(new VolleyLog.MarkerLog.Marker(paramString, paramLong, SystemClock.elapsedRealtime()));
  }
  
  protected void finalize()
  {
    if (!this.c)
    {
      a("Request on the loose");
      VolleyLog.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.VolleyLog.MarkerLog
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */