package com.squareup.picasso;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Dispatcher$DispatcherHandler
  extends Handler
{
  private final Dispatcher a;
  
  public Dispatcher$DispatcherHandler(Looper paramLooper, Dispatcher paramDispatcher)
  {
    super(paramLooper);
    this.a = paramDispatcher;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    case 3: 
    case 8: 
    default: 
      Picasso.a.post(new Dispatcher.DispatcherHandler.1(this, paramMessage));
      return;
    case 1: 
      Action localAction2 = (Action)paramMessage.obj;
      this.a.c(localAction2);
      return;
    case 2: 
      Action localAction1 = (Action)paramMessage.obj;
      this.a.d(localAction1);
      return;
    case 11: 
      Object localObject2 = paramMessage.obj;
      this.a.a(localObject2);
      return;
    case 12: 
      Object localObject1 = paramMessage.obj;
      this.a.b(localObject1);
      return;
    case 4: 
      BitmapHunter localBitmapHunter3 = (BitmapHunter)paramMessage.obj;
      this.a.e(localBitmapHunter3);
      return;
    case 5: 
      BitmapHunter localBitmapHunter2 = (BitmapHunter)paramMessage.obj;
      this.a.d(localBitmapHunter2);
      return;
    case 6: 
      BitmapHunter localBitmapHunter1 = (BitmapHunter)paramMessage.obj;
      this.a.a(localBitmapHunter1, false);
      return;
    case 7: 
      this.a.a();
      return;
    case 9: 
      NetworkInfo localNetworkInfo = (NetworkInfo)paramMessage.obj;
      this.a.b(localNetworkInfo);
      return;
    }
    Dispatcher localDispatcher = this.a;
    if (paramMessage.arg1 == i) {}
    for (;;)
    {
      localDispatcher.b(i);
      return;
      int j = 0;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Dispatcher.DispatcherHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */