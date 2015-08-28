package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class Picasso$1
  extends Handler
{
  Picasso$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    List localList2;
    int k;
    int m;
    switch (paramMessage.what)
    {
    default: 
      throw new AssertionError("Unknown handler message received: " + paramMessage.what);
    case 8: 
      localList2 = (List)paramMessage.obj;
      k = localList2.size();
      m = 0;
    case 3: 
      while (m < k)
      {
        BitmapHunter localBitmapHunter = (BitmapHunter)localList2.get(m);
        localBitmapHunter.b.a(localBitmapHunter);
        m++;
        continue;
        Action localAction2 = (Action)paramMessage.obj;
        if (localAction2.h().k) {
          Utils.a("Main", "canceled", localAction2.b.a(), "target got garbage collected");
        }
        Picasso.a(localAction2.a, localAction2.d());
      }
    }
    for (;;)
    {
      return;
      List localList1 = (List)paramMessage.obj;
      int i = localList1.size();
      for (int j = 0; j < i; j++)
      {
        Action localAction1 = (Action)localList1.get(j);
        localAction1.a.c(localAction1);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Picasso.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */