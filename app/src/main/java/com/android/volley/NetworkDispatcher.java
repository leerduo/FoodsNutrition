package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final BlockingQueue<Request<?>> a;
  private final Network b;
  private final Cache c;
  private final ResponseDelivery d;
  private volatile boolean e = false;
  
  public NetworkDispatcher(BlockingQueue<Request<?>> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.a = paramBlockingQueue;
    this.b = paramNetwork;
    this.c = paramCache;
    this.d = paramResponseDelivery;
  }
  
  @TargetApi(14)
  private void a(Request<?> paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramRequest.c());
    }
  }
  
  private void a(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    VolleyError localVolleyError = paramRequest.a(paramVolleyError);
    this.d.a(paramRequest, localVolleyError);
  }
  
  public void a()
  {
    this.e = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 74	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 24	com/android/volley/NetworkDispatcher:a	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 86 1 0
    //   18: checkcast 42	com/android/volley/Request
    //   21: astore 4
    //   23: aload 4
    //   25: ldc 88
    //   27: invokevirtual 91	com/android/volley/Request:a	(Ljava/lang/String;)V
    //   30: aload 4
    //   32: invokevirtual 95	com/android/volley/Request:i	()Z
    //   35: ifeq +45 -> 80
    //   38: aload 4
    //   40: ldc 97
    //   42: invokevirtual 99	com/android/volley/Request:b	(Ljava/lang/String;)V
    //   45: goto -40 -> 5
    //   48: astore 8
    //   50: aload 8
    //   52: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
    //   55: lload_1
    //   56: lsub
    //   57: invokevirtual 102	com/android/volley/VolleyError:a	(J)V
    //   60: aload_0
    //   61: aload 4
    //   63: aload 8
    //   65: invokespecial 103	com/android/volley/NetworkDispatcher:a	(Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   68: goto -63 -> 5
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 22	com/android/volley/NetworkDispatcher:e	Z
    //   76: ifeq -71 -> 5
    //   79: return
    //   80: aload_0
    //   81: aload 4
    //   83: invokespecial 105	com/android/volley/NetworkDispatcher:a	(Lcom/android/volley/Request;)V
    //   86: aload_0
    //   87: getfield 26	com/android/volley/NetworkDispatcher:b	Lcom/android/volley/Network;
    //   90: aload 4
    //   92: invokeinterface 110 2 0
    //   97: astore 9
    //   99: aload 4
    //   101: ldc 112
    //   103: invokevirtual 91	com/android/volley/Request:a	(Ljava/lang/String;)V
    //   106: aload 9
    //   108: getfield 116	com/android/volley/NetworkResponse:d	Z
    //   111: ifeq +84 -> 195
    //   114: aload 4
    //   116: invokevirtual 119	com/android/volley/Request:x	()Z
    //   119: ifeq +76 -> 195
    //   122: aload 4
    //   124: ldc 121
    //   126: invokevirtual 99	com/android/volley/Request:b	(Ljava/lang/String;)V
    //   129: goto -124 -> 5
    //   132: astore 5
    //   134: iconst_1
    //   135: anewarray 123	java/lang/Object
    //   138: astore 6
    //   140: aload 6
    //   142: iconst_0
    //   143: aload 5
    //   145: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   148: aastore
    //   149: aload 5
    //   151: ldc 129
    //   153: aload 6
    //   155: invokestatic 134	com/android/volley/VolleyLog:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: new 67	com/android/volley/VolleyError
    //   161: dup
    //   162: aload 5
    //   164: invokespecial 137	com/android/volley/VolleyError:<init>	(Ljava/lang/Throwable;)V
    //   167: astore 7
    //   169: aload 7
    //   171: invokestatic 80	android/os/SystemClock:elapsedRealtime	()J
    //   174: lload_1
    //   175: lsub
    //   176: invokevirtual 102	com/android/volley/VolleyError:a	(J)V
    //   179: aload_0
    //   180: getfield 30	com/android/volley/NetworkDispatcher:d	Lcom/android/volley/ResponseDelivery;
    //   183: aload 4
    //   185: aload 7
    //   187: invokeinterface 59 3 0
    //   192: goto -187 -> 5
    //   195: aload 4
    //   197: aload 9
    //   199: invokevirtual 140	com/android/volley/Request:a	(Lcom/android/volley/NetworkResponse;)Lcom/android/volley/Response;
    //   202: astore 10
    //   204: aload 4
    //   206: ldc 142
    //   208: invokevirtual 91	com/android/volley/Request:a	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: invokevirtual 145	com/android/volley/Request:s	()Z
    //   216: ifeq +37 -> 253
    //   219: aload 10
    //   221: getfield 150	com/android/volley/Response:b	Lcom/android/volley/Cache$Entry;
    //   224: ifnull +29 -> 253
    //   227: aload_0
    //   228: getfield 28	com/android/volley/NetworkDispatcher:c	Lcom/android/volley/Cache;
    //   231: aload 4
    //   233: invokevirtual 153	com/android/volley/Request:f	()Ljava/lang/String;
    //   236: aload 10
    //   238: getfield 150	com/android/volley/Response:b	Lcom/android/volley/Cache$Entry;
    //   241: invokeinterface 158 3 0
    //   246: aload 4
    //   248: ldc 160
    //   250: invokevirtual 91	com/android/volley/Request:a	(Ljava/lang/String;)V
    //   253: aload 4
    //   255: invokevirtual 163	com/android/volley/Request:w	()V
    //   258: aload_0
    //   259: getfield 30	com/android/volley/NetworkDispatcher:d	Lcom/android/volley/ResponseDelivery;
    //   262: aload 4
    //   264: aload 10
    //   266: invokeinterface 166 3 0
    //   271: goto -266 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	NetworkDispatcher
    //   8	167	1	l	long
    //   71	1	3	localInterruptedException	java.lang.InterruptedException
    //   21	242	4	localRequest	Request
    //   132	31	5	localException	java.lang.Exception
    //   138	16	6	arrayOfObject	java.lang.Object[]
    //   167	19	7	localVolleyError1	VolleyError
    //   48	16	8	localVolleyError2	VolleyError
    //   97	101	9	localNetworkResponse	NetworkResponse
    //   202	63	10	localResponse	Response
    // Exception table:
    //   from	to	target	type
    //   23	45	48	com/android/volley/VolleyError
    //   80	129	48	com/android/volley/VolleyError
    //   195	253	48	com/android/volley/VolleyError
    //   253	271	48	com/android/volley/VolleyError
    //   9	23	71	java/lang/InterruptedException
    //   23	45	132	java/lang/Exception
    //   80	129	132	java/lang/Exception
    //   195	253	132	java/lang/Exception
    //   253	271	132	java/lang/Exception
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.NetworkDispatcher
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */