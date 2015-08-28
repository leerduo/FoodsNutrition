package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Stats$StatsHandler
  extends Handler
{
  private final Stats a;
  
  public Stats$StatsHandler(Looper paramLooper, Stats paramStats)
  {
    super(paramLooper);
    this.a = paramStats;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Picasso.a.post(new Stats.StatsHandler.1(this, paramMessage));
      return;
    case 0: 
      this.a.c();
      return;
    case 1: 
      this.a.d();
      return;
    case 2: 
      this.a.b(paramMessage.arg1);
      return;
    case 3: 
      this.a.c(paramMessage.arg1);
      return;
    }
    this.a.a((Long)paramMessage.obj);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Stats.StatsHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */