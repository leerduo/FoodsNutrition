package com.boohee.food.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.boohee.food.TopicActivity;
import com.boohee.food.model.Topic;

class HomeItemFragment$2
  extends AnimatorListenerAdapter
{
  HomeItemFragment$2(HomeItemFragment paramHomeItemFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (HomeItemFragment.a(this.a) != null) {
      TopicActivity.a(this.a.getActivity(), HomeItemFragment.a(this.a).id + "");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeItemFragment.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */