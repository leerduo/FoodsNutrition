package com.boohee.food.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.boohee.food.MainActivity;
import com.boohee.food.SearchActivity;
import com.boohee.food.cache.FileCache;
import com.boohee.food.model.Banner;
import com.boohee.food.model.Topic;
import com.boohee.food.model.TopicWrapper;
import com.boohee.food.util.AssetUtils;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.ViewUtils;
import com.boohee.food.view.MultiViewPager;
import com.boohee.food.volley.FoodRequest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class HomeFragment
  extends BaseFragment
{
  private static int g = 1;
  MultiViewPager a;
  TextView b;
  TextView c;
  ImageView d;
  SwipeRefreshLayout e;
  private HomeFragment.ViewPagerAdapter f;
  private List<Banner> h;
  private Banner i;
  private List<Topic> j = new ArrayList();
  private int k;
  private FileCache l;
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    TopicWrapper localTopicWrapper;
    do
    {
      return;
      localTopicWrapper = TopicWrapper.parse(paramJSONObject.toString());
    } while ((localTopicWrapper == null) || (localTopicWrapper.topic_count <= 0));
    this.k = localTopicWrapper.topic_count;
    this.j.clear();
    this.j.addAll(localTopicWrapper.topics);
  }
  
  private void b(int paramInt)
  {
    if ((this.j != null) && (this.j.size() > 0))
    {
      this.b.setText(((Topic)this.j.get(paramInt)).title);
      this.c.setText(((Topic)this.j.get(paramInt)).sub_title);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      if (paramJSONObject.has(Banner.KEY)) {
        this.i = Banner.parse(paramJSONObject.optString(Banner.KEY));
      }
    } while (!paramJSONObject.has(Banner.KEY_OTHERS));
    this.h = Banner.parseOthers(paramJSONObject.optString(Banner.KEY_OTHERS));
    this.h.add(0, this.i);
    g = 1;
  }
  
  private void e()
  {
    this.a.setOnPageChangeListener(new HomeFragment.MPagerChangeL(this, null));
    this.a.setOffscreenPageLimit(this.k);
    this.a.setPageTransformer(true, new HomeFragment.RotatePageTransformer());
    b(0);
  }
  
  private void f()
  {
    int m = Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    this.d.getLayoutParams().width = m;
    this.d.getLayoutParams().height = ((int)(0.75F * m));
  }
  
  private void g()
  {
    FoodRequest.a("/fb/v1/welcome", new HomeFragment.3(this, getActivity()), getActivity());
  }
  
  private void h()
  {
    FoodRequest.a("/fb/v1/topics", new HomeFragment.4(this, getActivity()), getActivity());
  }
  
  private void i()
  {
    if (this.i != null) {
      ImageLoader.a(this.d, this.i.image_url, 2130837637, 2130837637);
    }
    for (;;)
    {
      return;
      String str = AssetUtils.a(getActivity(), "json/home_banner.json");
      if (!TextUtils.isEmpty(str)) {
        try
        {
          this.i = ((Banner)JSON.parseObject(new JSONObject(str).optString(Banner.KEY), Banner.class));
          if (this.i != null)
          {
            ImageLoader.a(this.d, ViewUtils.a(getActivity(), this.i.image_url), 2130837637, 2130837637);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void j()
  {
    if ((this.j != null) && (this.j.size() > 0)) {
      if (this.f == null)
      {
        this.f = new HomeFragment.ViewPagerAdapter(this, getChildFragmentManager());
        this.a.setAdapter(this.f);
        b(this.a.getCurrentItem());
      }
    }
    TopicWrapper localTopicWrapper;
    do
    {
      String str;
      do
      {
        return;
        this.f.notifyDataSetChanged();
        break;
        str = AssetUtils.a(getActivity(), "json/home_topic.json");
      } while (TextUtils.isEmpty(str));
      localTopicWrapper = TopicWrapper.parse(str);
    } while (localTopicWrapper == null);
    this.k = localTopicWrapper.topic_count;
    this.j = localTopicWrapper.topics;
    e();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    e();
    f();
    a();
    h();
    g();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427571: 
      ((MainActivity)getActivity()).a();
      return;
    }
    SearchActivity.a(getActivity());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = FileCache.a(getActivity());
    b(this.l.b("CACHE_HOME_BANNER"));
    a(this.l.b("CACHE_HOME_TOPICS"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903096, paramViewGroup, false);
    ButterKnife.a(this, localView);
    this.d.setOnClickListener(new HomeFragment.1(this));
    this.e.setOnRefreshListener(new HomeFragment.2(this));
    return localView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */