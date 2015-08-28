package com.viewpagerindicator;

import android.graphics.Paint;

class UnderlinePageIndicator$1
  implements Runnable
{
  public void run()
  {
    if (!UnderlinePageIndicator.a(this.a)) {}
    int i;
    do
    {
      return;
      i = Math.max(UnderlinePageIndicator.b(this.a).getAlpha() - UnderlinePageIndicator.c(this.a), 0);
      UnderlinePageIndicator.b(this.a).setAlpha(i);
      this.a.invalidate();
    } while (i <= 0);
    this.a.postDelayed(this, 30L);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.UnderlinePageIndicator.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */