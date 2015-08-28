package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public abstract class l
  implements Handler.Callback
{
  protected final Handler a;
  private String b;
  
  public l(String paramString)
  {
    this.b = paramString;
    HandlerThread localHandlerThread = new HandlerThread(paramString);
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public void a()
  {
    a(0, 0, null);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = -1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    this.a.sendMessage(localMessage);
  }
  
  protected void a(Message paramMessage) {}
  
  public void b()
  {
    b(0, 0, null);
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = -2;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramObject;
    this.a.sendMessage(localMessage);
  }
  
  protected void b(Message paramMessage) {}
  
  protected abstract void c(Message paramMessage);
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      c(paramMessage);
    }
    for (;;)
    {
      return false;
      a(paramMessage);
      continue;
      b(paramMessage);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */