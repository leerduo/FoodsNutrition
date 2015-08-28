package com.viewpagerindicator;

class UnderlinePageIndicator$2
  implements Runnable
{
  UnderlinePageIndicator$2(UnderlinePageIndicator paramUnderlinePageIndicator) {}
  
  public void run()
  {
    if (UnderlinePageIndicator.a(this.a)) {
      this.a.post(UnderlinePageIndicator.d(this.a));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.UnderlinePageIndicator.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */