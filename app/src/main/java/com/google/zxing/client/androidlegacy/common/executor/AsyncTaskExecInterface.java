package com.google.zxing.client.androidlegacy.common.executor;

import android.os.AsyncTask;

public abstract interface AsyncTaskExecInterface
{
  public abstract <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.common.executor.AsyncTaskExecInterface
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */