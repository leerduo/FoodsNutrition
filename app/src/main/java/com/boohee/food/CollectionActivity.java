package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import butterknife.ButterKnife;
import com.boohee.food.adapter.CollectionAdapter;
import com.boohee.food.model.Food;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.view.BooheeListView;
import com.boohee.food.volley.IFoodRequest;
import java.util.ArrayList;
import java.util.List;

public class CollectionActivity
  extends BaseActivity
{
  BooheeListView b;
  View c;
  private CollectionAdapter d;
  private List<Food> e = new ArrayList();
  private List<Boolean> f = new ArrayList();
  private int g = 0;
  private int h = 1;
  
  private void a()
  {
    this.d = new CollectionAdapter(this, this.e, this.f);
    this.b.setAdapter(this.d);
    this.b.setOnLoadMoreListener(new CollectionActivity.1(this));
    this.b.setOnItemClickListener(new CollectionActivity.2(this));
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, CollectionActivity.class));
  }
  
  private void a(boolean paramBoolean)
  {
    this.g = 0;
    this.h = 1;
    this.f.clear();
    this.e.clear();
    this.d.notifyDataSetChanged();
    b(paramBoolean);
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < this.f.size(); i++) {
      if (((Boolean)this.f.get(i)).booleanValue())
      {
        localStringBuilder.append(((Food)this.e.get(i)).id);
        localStringBuilder.append(",");
      }
    }
    String str1 = localStringBuilder.toString();
    if (str1.length() == 0)
    {
      ToastUtils.b(getString(2131558440));
      return;
    }
    String str2 = str1.substring(0, -1 + str1.length());
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str2;
    arrayOfObject[1] = AccountUtils.a();
    String str3 = String.format("/v2/favorite_foods/batch_delete?food_ids=%s&token=%s", arrayOfObject);
    c();
    IFoodRequest.a(3, str3, null, new CollectionActivity.4(this, this), this);
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 1 + this.g;
    if ((i > 1) && (i > this.h)) {
      return;
    }
    if (paramBoolean) {
      c();
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = AccountUtils.a();
    IFoodRequest.a(String.format("/v2/favorite_foods?page=%d&token=%s", arrayOfObject), new CollectionActivity.3(this, this, paramBoolean), this);
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      b();
      return;
    } while (this.f.size() <= 0);
    boolean bool;
    if (!((Boolean)this.f.get(0)).booleanValue()) {
      bool = true;
    }
    while (i < this.f.size())
    {
      this.f.set(i, Boolean.valueOf(bool));
      i++;
      continue;
      bool = false;
      i = 0;
    }
    this.d.notifyDataSetChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903067);
    ButterKnife.a(this);
    a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 1, 1, 2131558441).setShowAsAction(2);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {
      this.f.clear();
    }
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
    }
    if (getString(2131558441).equals(paramMenuItem.getTitle()))
    {
      paramMenuItem.setTitle(2131558442);
      this.d.a(true);
      this.c.setVisibility(0);
      this.c.startAnimation(AnimationUtils.loadAnimation(this, 2130968582));
      return true;
    }
    paramMenuItem.setTitle(2131558441);
    this.d.a(false);
    this.c.setVisibility(8);
    this.c.startAnimation(AnimationUtils.loadAnimation(this, 2130968583));
    return true;
  }
  
  public void onResume()
  {
    if (AccountUtils.d()) {
      a(true);
    }
    for (;;)
    {
      super.onResume();
      return;
      a(AuthActivity.class);
      finish();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CollectionActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */