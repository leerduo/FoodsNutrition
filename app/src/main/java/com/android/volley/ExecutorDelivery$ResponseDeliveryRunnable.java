package com.android.volley;

class ExecutorDelivery$ResponseDeliveryRunnable
  implements Runnable
{
  private final Request b;
  private final Response c;
  private final Runnable d;
  
  public ExecutorDelivery$ResponseDeliveryRunnable(ExecutorDelivery paramExecutorDelivery, Request paramRequest, Response paramResponse, Runnable paramRunnable)
  {
    this.b = paramRequest;
    this.c = paramResponse;
    this.d = paramRunnable;
  }
  
  public void run()
  {
    if (this.b.i()) {
      this.b.b("canceled-at-delivery");
    }
    label97:
    label107:
    for (;;)
    {
      return;
      if (this.c.a())
      {
        this.b.b(this.c.a);
        if (!this.c.d) {
          break label97;
        }
        this.b.a("intermediate-response");
      }
      for (;;)
      {
        if (this.d == null) {
          break label107;
        }
        this.d.run();
        return;
        this.b.b(this.c.c);
        break;
        this.b.b("done");
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.ExecutorDelivery.ResponseDeliveryRunnable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */