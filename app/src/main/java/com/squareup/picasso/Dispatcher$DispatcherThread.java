package com.squareup.picasso;

import android.os.HandlerThread;

class Dispatcher$DispatcherThread
  extends HandlerThread
{
  Dispatcher$DispatcherThread()
  {
    super("Picasso-Dispatcher", 10);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Dispatcher.DispatcherThread
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */