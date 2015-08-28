package com.xiaomi.kenai.jbosh;

class u
  implements Runnable
{
  u(s params) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   4: invokestatic 22	com/xiaomi/kenai/jbosh/s:b	(Lcom/xiaomi/kenai/jbosh/s;)Ljava/util/concurrent/locks/ReentrantLock;
    //   7: invokevirtual 27	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   10: aload_0
    //   11: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   14: invokestatic 31	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/s;)Ljava/util/Queue;
    //   17: ifnull +20 -> 37
    //   20: aload_0
    //   21: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   24: invokestatic 31	com/xiaomi/kenai/jbosh/s:c	(Lcom/xiaomi/kenai/jbosh/s;)Ljava/util/Queue;
    //   27: invokeinterface 37 1 0
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +14 -> 48
    //   37: aload_0
    //   38: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   41: invokestatic 22	com/xiaomi/kenai/jbosh/s:b	(Lcom/xiaomi/kenai/jbosh/s;)Ljava/util/concurrent/locks/ReentrantLock;
    //   44: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   47: return
    //   48: aload_0
    //   49: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   52: invokestatic 22	com/xiaomi/kenai/jbosh/s:b	(Lcom/xiaomi/kenai/jbosh/s;)Ljava/util/concurrent/locks/ReentrantLock;
    //   55: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   58: aload_0
    //   59: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   62: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   65: invokestatic 49	com/xiaomi/kenai/jbosh/s:a	(Lcom/xiaomi/kenai/jbosh/s;J)J
    //   68: pop2
    //   69: aload_0
    //   70: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   73: invokestatic 52	com/xiaomi/kenai/jbosh/s:d	(Lcom/xiaomi/kenai/jbosh/s;)V
    //   76: goto -76 -> 0
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 12	com/xiaomi/kenai/jbosh/u:a	Lcom/xiaomi/kenai/jbosh/s;
    //   84: invokestatic 22	com/xiaomi/kenai/jbosh/s:b	(Lcom/xiaomi/kenai/jbosh/s;)Ljava/util/concurrent/locks/ReentrantLock;
    //   87: invokevirtual 40	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	u
    //   79	12	1	localObject	Object
    //   32	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	33	79	finally
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.u
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */