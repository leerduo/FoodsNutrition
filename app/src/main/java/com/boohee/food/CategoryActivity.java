package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import com.boohee.food.adapter.CategoryAdapter;
import com.boohee.food.model.Category;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.FoodRequest;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener
{
  private List<Category> b = new ArrayList();
  private GridView c;
  private ListView d;
  private CategoryAdapter e;
  private String f;
  
  private void a()
  {
    this.f = getIntent().getStringExtra("key_kind");
    this.e = new CategoryAdapter(this, this.f, this.b);
    if ("season".equals(this.f))
    {
      setContentView(2130903066);
      this.d = ((ListView)findViewById(2131427420));
      this.d.setAdapter(this.e);
      this.d.setOnItemClickListener(this);
      if (!"group".equals(this.f)) {
        break label143;
      }
      setTitle(2131558518);
    }
    label143:
    do
    {
      return;
      setContentView(2130903065);
      this.c = ((GridView)findViewById(2131427419));
      this.c.setAdapter(this.e);
      this.c.setOnItemClickListener(this);
      break;
      if ("brand".equals(this.f))
      {
        setTitle(2131558516);
        return;
      }
      if ("restaurant".equals(this.f))
      {
        setTitle(2131558520);
        return;
      }
      if ("cooking".equals(this.f))
      {
        setTitle(2131558517);
        return;
      }
    } while (!"season".equals(this.f));
    setTitle(2131558521);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ToastUtils.b(paramContext.getString(2131558464));
      return;
    }
    if ("group".equals(paramString)) {
      MobclickAgent.onEvent(paramContext, "view_by_category");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, CategoryActivity.class);
      localIntent.putExtra("key_kind", paramString);
      paramContext.startActivity(localIntent);
      return;
      if ("brand".equals(paramString)) {
        MobclickAgent.onEvent(paramContext, "view_by_brand");
      } else if ("restaurant".equals(paramString)) {
        MobclickAgent.onEvent(paramContext, "view_by_restaurant");
      } else if ("cooking".equals(paramString)) {
        MobclickAgent.onEvent(paramContext, "view_by_cooking");
      } else if ("season".equals(paramString)) {
        MobclickAgent.onEvent(paramContext, "view_by_season");
      }
    }
  }
  
  private void b()
  {
    c();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.f;
    FoodRequest.a(String.format("/fb/v1/categories?kind=%s", arrayOfObject), new CategoryActivity.1(this, this), this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Category localCategory = (Category)this.b.get(paramInt);
    FoodListActivity.a(this.a, this.f, localCategory);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CategoryActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */