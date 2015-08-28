package com.boohee.food;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.astuetz.PagerSlidingTabStrip;
import com.boohee.food.adapter.FragmentAdapter;
import com.boohee.food.fragment.FoodListFragment;
import com.boohee.food.model.Category;
import com.boohee.food.util.PrefUtils;
import com.boohee.food.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;

public class FoodListActivity
  extends BaseActivity
{
  private Category b;
  private String c;
  private int d;
  private int e = -1;
  private List<Category> f;
  private int g;
  private PagerSlidingTabStrip h;
  private ViewPager i;
  private Spinner j;
  private TextView k;
  private RelativeLayout l;
  private ActionBar m;
  private int[] n;
  private int[] o;
  private String[] p;
  private List<Fragment> q;
  
  private void a()
  {
    this.c = getIntent().getStringExtra("key_category_kind");
    this.b = ((Category)getIntent().getSerializableExtra("key_category"));
    if (this.b != null)
    {
      this.d = this.b.id;
      this.f = this.b.sub_categories;
    }
  }
  
  public static void a(Context paramContext, String paramString, Category paramCategory)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramCategory == null))
    {
      ToastUtils.b(paramContext.getString(2131558464));
      return;
    }
    Intent localIntent = new Intent(paramContext, FoodListActivity.class);
    localIntent.putExtra("key_category_kind", paramString);
    localIntent.putExtra("key_category", paramCategory);
    paramContext.startActivity(localIntent);
  }
  
  private void a(View paramView)
  {
    paramView.setBackgroundColor(getResources().getColor(2131296279));
    TextView localTextView = (TextView)paramView;
    localTextView.setTextColor(getResources().getColor(2131296263));
    localTextView.setTextSize(16.0F);
    localTextView.setGravity(19);
  }
  
  private void b()
  {
    this.m = getActionBar();
    this.m.setTitle(this.b.name);
    if ((this.b != null) && (this.b.sub_category_count > 0))
    {
      this.m.setDisplayShowCustomEnabled(true);
      e();
    }
  }
  
  private void e()
  {
    this.j = new Spinner(this);
    this.j.setAdapter(new ArrayAdapter(this, 17367049, f()));
    this.j.setSelection(0, true);
    this.j.setOnItemSelectedListener(new FoodListActivity.SpinnerItemSelectedListener(this, null));
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams(-2, -2);
    localLayoutParams.gravity = 8388613;
    this.m.setCustomView(this.j, localLayoutParams);
  }
  
  private List<String> f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("全部");
    if ((this.f != null) && (this.f.size() > 0)) {
      for (int i1 = 0; i1 < this.f.size(); i1++) {
        localArrayList.add(((Category)this.f.get(i1)).name);
      }
    }
    return localArrayList;
  }
  
  private void g()
  {
    this.i = ((ViewPager)findViewById(2131427448));
    this.h = ((PagerSlidingTabStrip)findViewById(2131427444));
    this.k = ((TextView)findViewById(2131427447));
    this.l = ((RelativeLayout)findViewById(2131427445));
    this.k.setOnClickListener(new FoodListActivity.ClikListener(this, null));
    this.l.setOnClickListener(new FoodListActivity.ClikListener(this, null));
  }
  
  private void h()
  {
    j();
    if (!PrefUtils.e().booleanValue())
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }
  
  private List<Fragment> i()
  {
    this.o = getResources().getIntArray(2131165185);
    this.n = getResources().getIntArray(2131165186);
    this.p = getResources().getStringArray(2131165184);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FoodListFragment.a(this.c, this.d, this.e, this.o[0], this.n[0]));
    localArrayList.add(FoodListFragment.a(this.c, this.d, this.e, this.o[1], this.n[1]));
    localArrayList.add(FoodListFragment.a(this.c, this.d, this.e, this.o[2], this.n[2]));
    localArrayList.add(FoodListFragment.a(this.c, this.d, this.e, this.o[3], this.n[3]));
    return localArrayList;
  }
  
  private void j()
  {
    this.q = i();
    this.i.setAdapter(new FragmentAdapter(getSupportFragmentManager(), this, this.q, this.p, this.n));
    this.i.setOffscreenPageLimit(5);
    this.h.setTabDefaultValue(this.n);
    this.h.setViewPager(this.i);
    this.h.setOnPageChangeListener(new FoodListActivity.1(this));
    this.h.setOnTabClickListener(new FoodListActivity.2(this));
    this.i.setCurrentItem(this.g);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903070);
    ButterKnife.a(this);
    a();
    g();
    b();
    h();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.FoodListActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */