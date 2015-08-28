package com.boohee.food;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.ButterKnife;
import com.boohee.food.adapter.TopicAdapter;
import com.boohee.food.model.TopicDetail;
import com.boohee.food.util.MobUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.util.ViewUtils;
import com.boohee.food.volley.FoodRequest;
import com.umeng.analytics.MobclickAgent;
import com.viewpagerindicator.LinePageIndicator;
import java.util.ArrayList;
import java.util.List;

public class TopicActivity
  extends BaseActivity
{
  private static final String d = TopicActivity.class.getSimpleName();
  ViewPager b;
  LinePageIndicator c;
  private TopicAdapter e;
  private List<TopicDetail> f = new ArrayList();
  private String g;
  private String h;
  
  private void a()
  {
    ActionBar localActionBar = getActionBar();
    localActionBar.setDisplayShowTitleEnabled(false);
    localActionBar.setDisplayShowHomeEnabled(true);
    localActionBar.setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ToastUtils.b(paramContext.getString(2131558464));
      return;
    }
    Intent localIntent = new Intent(paramContext, TopicActivity.class);
    localIntent.putExtra("key_topic_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    this.e = new TopicAdapter(this.f, getSupportFragmentManager());
    this.b.setAdapter(this.e);
  }
  
  private void e()
  {
    this.c.setViewPager(this.b);
  }
  
  private void f()
  {
    c();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getIntent().getStringExtra("key_topic_id");
    FoodRequest.a(String.format("/fb/v1/topics/%s", arrayOfObject), new TopicActivity.1(this, this), this);
  }
  
  private void g()
  {
    MobclickAgent.onEvent(this.a, "click_share");
    try
    {
      int i = this.b.getCurrentItem();
      TopicDetail localTopicDetail = (TopicDetail)this.f.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      if (TextUtils.isEmpty(this.g)) {}
      String str3;
      for (Object localObject = "";; localObject = str3)
      {
        String str1 = (String)localObject + localTopicDetail.food_name;
        String str2 = localTopicDetail.description + " " + localTopicDetail.page_url;
        if ((!TextUtils.isEmpty(localTopicDetail.description)) && (str2.length() >= 135))
        {
          int j = 135 - (1 + localTopicDetail.page_url.length());
          str2 = localTopicDetail.description.substring(0, j) + "... " + localTopicDetail.page_url;
        }
        MobUtils.a(this, str1, str2, localTopicDetail.page_url, localTopicDetail.image_url);
        return;
        str3 = this.g + "——";
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ToastUtils.b(getString(2131558601));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a();
    ViewUtils.a(this);
    super.onCreate(paramBundle);
    setContentView(2130903086);
    ButterKnife.a(this);
    MobclickAgent.onEvent(this, "view_topic");
    b();
    f();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689475, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.f != null) {
      this.f.clear();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      onBackPressed();
      return true;
    }
    g();
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.TopicActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */