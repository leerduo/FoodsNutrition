package com.boohee.food.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.boohee.food.model.Topic;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.ViewUtils;

public class HomeItemFragment
  extends BaseFragment
{
  private static AnimatorSet c;
  private static int d;
  ImageView a;
  FrameLayout b;
  private Topic e;
  
  public static HomeItemFragment a(Topic paramTopic)
  {
    HomeItemFragment localHomeItemFragment = new HomeItemFragment();
    Bundle localBundle = new Bundle();
    if (paramTopic != null) {}
    for (String str = paramTopic.toString();; str = "")
    {
      localBundle.putString("KEY_TOPIC_DATA", str);
      localHomeItemFragment.setArguments(localBundle);
      return localHomeItemFragment;
    }
  }
  
  private void a(View paramView)
  {
    c.removeAllListeners();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "rotationY", new float[] { 0.0F, 360.0F });
    c.setTarget(paramView);
    c.playTogether(new Animator[] { localObjectAnimator });
    c.addListener(new HomeItemFragment.2(this));
    c.start();
  }
  
  private void c()
  {
    this.a.setOnClickListener(new HomeItemFragment.1(this));
  }
  
  private void d()
  {
    if (c == null)
    {
      c = new AnimatorSet();
      c.setDuration(300L);
      c.setInterpolator(new AccelerateInterpolator());
    }
  }
  
  private void e()
  {
    if (this.e != null)
    {
      String str = this.e.image_url;
      if (str.contains("http"))
      {
        this.b.getLayoutParams().width = d;
        ImageLoader.a(this.a, str, 2130837639);
      }
    }
    else
    {
      return;
    }
    ImageLoader.a(this.a, ViewUtils.a(getActivity(), this.e.image_url), 2130837639);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    d = getResources().getDisplayMetrics().widthPixels / 3;
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null)
    {
      this.e = Topic.parse(getArguments().getString("KEY_TOPIC_DATA"));
      d();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903097, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ButterKnife.a(this, paramView);
    c();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeItemFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */