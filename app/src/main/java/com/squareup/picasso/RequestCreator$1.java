package com.squareup.picasso;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

final class RequestCreator$1
  implements Runnable
{
  RequestCreator$1(AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    this.a.set(RequestCreator.d());
    this.b.countDown();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.RequestCreator.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */