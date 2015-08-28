package com.google.zxing.client.androidlegacy.common.executor;

import com.google.zxing.client.androidlegacy.common.PlatformSupportManager;

public final class AsyncTaskExecManager
  extends PlatformSupportManager<AsyncTaskExecInterface>
{
  public AsyncTaskExecManager()
  {
    super(AsyncTaskExecInterface.class, new DefaultAsyncTaskExecInterface());
    a(11, "com.google.zxing.client.android.common.executor.HoneycombAsyncTaskExecInterface");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.common.executor.AsyncTaskExecManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */