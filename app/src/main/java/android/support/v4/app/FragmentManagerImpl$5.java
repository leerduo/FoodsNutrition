package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$5
  implements Animation.AnimationListener
{
  FragmentManagerImpl$5(FragmentManagerImpl paramFragmentManagerImpl, Fragment paramFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$fragment.mAnimatingAway != null)
    {
      this.val$fragment.mAnimatingAway = null;
      this.this$0.moveToState(this.val$fragment, this.val$fragment.mStateAfterAnimating, 0, 0, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.5
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */