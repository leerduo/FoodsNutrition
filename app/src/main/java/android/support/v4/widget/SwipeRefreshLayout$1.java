package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$1
  implements Animation.AnimationListener
{
  SwipeRefreshLayout$1(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (SwipeRefreshLayout.access$000(this.this$0))
    {
      SwipeRefreshLayout.access$100(this.this$0).setAlpha(255);
      SwipeRefreshLayout.access$100(this.this$0).start();
      if ((SwipeRefreshLayout.access$200(this.this$0)) && (SwipeRefreshLayout.access$300(this.this$0) != null)) {
        SwipeRefreshLayout.access$300(this.this$0).onRefresh();
      }
    }
    for (;;)
    {
      SwipeRefreshLayout.access$802(this.this$0, SwipeRefreshLayout.access$400(this.this$0).getTop());
      return;
      SwipeRefreshLayout.access$100(this.this$0).stop();
      SwipeRefreshLayout.access$400(this.this$0).setVisibility(8);
      SwipeRefreshLayout.access$500(this.this$0, 255);
      if (SwipeRefreshLayout.access$600(this.this$0)) {
        SwipeRefreshLayout.access$700(this.this$0, 0.0F);
      } else {
        SwipeRefreshLayout.access$900(this.this$0, this.this$0.mOriginalOffsetTop - SwipeRefreshLayout.access$800(this.this$0), true);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */