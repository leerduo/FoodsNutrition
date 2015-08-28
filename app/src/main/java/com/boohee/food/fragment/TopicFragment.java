package com.boohee.food.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.DetailInfoActivity;
import com.boohee.food.model.TopicDetail;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.ViewUtils;
import com.umeng.analytics.MobclickAgent;

public class TopicFragment
  extends BaseFragment
{
  ImageView a;
  TextView b;
  TextView c;
  private TopicDetail d;
  
  private void c()
  {
    int i = ViewUtils.a(getActivity(), 2131361906, 2131361905);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
  }
  
  private void d()
  {
    if (this.d != null)
    {
      ImageLoader.b(this.a, this.d.image_url);
      this.b.setText(this.d.food_name);
      this.c.setText(this.d.description);
    }
  }
  
  public void a(View paramView)
  {
    MobclickAgent.onEvent(getActivity(), "click_topic_food");
    DetailInfoActivity.a(getActivity(), this.d.food_code);
  }
  
  public void a(TopicDetail paramTopicDetail)
  {
    this.d = paramTopicDetail;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903101, null);
    ButterKnife.a(this, localView);
    c();
    d();
    return localView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.TopicFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */