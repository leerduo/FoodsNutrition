package com.boohee.food;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.adapter.SearchListAdapter;
import com.boohee.food.model.Food;
import com.boohee.food.util.KeyBoardUtils;
import com.boohee.food.util.PrefUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.view.NoScrollGridView;
import com.boohee.food.volley.FoodRequest;
import com.umeng.analytics.MobclickAgent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchActivity
  extends BaseActivity
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  NoScrollGridView b;
  EditText c;
  ImageView d;
  LinearLayout e;
  LinearLayout f;
  ListView g;
  TextView h;
  ScrollView i;
  private int j = 1;
  private int k = 1;
  private int l = 0;
  private int m = 0;
  private String n;
  private List<String> o = new ArrayList();
  private List<Food> p = new ArrayList();
  private List<String> q = new ArrayList();
  private SearchListAdapter r;
  
  private List<String> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return localArrayList;
    }
    for (int i1 = 0; i1 < paramArrayOfString.length; i1++) {
      localArrayList.add(paramArrayOfString[i1]);
    }
    return localArrayList;
  }
  
  private void a()
  {
    this.g.setOnItemClickListener(this);
    this.g.setOnScrollListener(this);
    this.b.setOnItemClickListener(this);
    this.c.addTextChangedListener(new SearchActivity.SearchTextWatcher(this, null));
    this.c.setOnEditorActionListener(new SearchActivity.SearchOnEditorActionListener(this, null));
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, SearchActivity.class));
    ((Activity)paramContext).overridePendingTransition(2130968582, 2130968583);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.j = 1;
    this.k = 1;
    this.c.setText(paramString);
    this.c.setSelection(paramString.length());
    b(paramString);
  }
  
  private void a(List<Food> paramList)
  {
    if (this.j == 1) {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.p.clear();
        this.p.addAll(paramList);
        c(this.n);
        this.r = new SearchListAdapter(this.a, this.p);
        this.g.setAdapter(this.r);
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.j = (1 + this.j);
      }
    }
    while ((paramList == null) || (paramList.size() <= 0))
    {
      return;
      this.g.setVisibility(8);
      this.i.setVisibility(8);
      this.h.setVisibility(0);
      return;
    }
    this.p.addAll(paramList);
    this.r.notifyDataSetChanged();
    this.j = (1 + this.j);
  }
  
  private String b(List<String> paramList)
  {
    Object localObject = "";
    if ((paramList == null) || (paramList.size() == 0)) {
      return localObject;
    }
    int i1 = 0;
    while (i1 < paramList.size())
    {
      String str = (String)localObject + (String)paramList.get(i1) + "##";
      i1++;
      localObject = str;
    }
    return ((String)localObject).substring(0, ((String)localObject).lastIndexOf("##"));
  }
  
  private void b()
  {
    this.n = this.c.getText().toString();
    if (!TextUtils.isEmpty(this.n))
    {
      this.j = 1;
      this.k = 1;
      b(this.n);
      return;
    }
    ToastUtils.a(getResources().getString(2131558559));
  }
  
  private void b(String paramString)
  {
    String str;
    try
    {
      str = URLEncoder.encode(paramString, "UTF-8");
      if (TextUtils.isEmpty(str)) {
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      return;
    }
    MobclickAgent.onEvent(this.a, "click_food_search");
    c();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(this.j);
    FoodRequest.a(String.format("/fb/v1/foods/search?q=%1$s&page=%2$d", arrayOfObject), new SearchActivity.1(this, this), this.a);
  }
  
  private void c(String paramString)
  {
    String str1 = PrefUtils.c();
    if (TextUtils.isEmpty(str1)) {
      PrefUtils.a(paramString + "##");
    }
    List localList;
    do
    {
      return;
      localList = a(str1.split("##"));
    } while (localList.contains(paramString));
    if (localList.size() >= 5)
    {
      localList.remove(0);
      localList.add(paramString);
    }
    for (String str2 = b(localList);; str2 = str1 + paramString + "##")
    {
      PrefUtils.a(str2);
      return;
    }
  }
  
  private void e()
  {
    c();
    FoodRequest.a(String.format("/fb/v1/keywords", new Object[0]), new SearchActivity.2(this, this), this.a);
  }
  
  private void f()
  {
    String str = PrefUtils.c();
    if (TextUtils.isEmpty(str))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    List localList = Arrays.asList(str.split("##"));
    if (this.o != null)
    {
      this.o.clear();
      this.o.addAll(localList);
      Collections.reverse(this.o);
    }
    g();
  }
  
  private void g()
  {
    if (this.o == null) {}
    for (;;)
    {
      return;
      this.f.removeAllViews();
      for (int i1 = 0; i1 < this.o.size(); i1++)
      {
        String str = (String)this.o.get(i1);
        View localView = LayoutInflater.from(this.a).inflate(2130903110, null);
        ((TextView)localView.findViewById(2131427572)).setText(str);
        localView.setOnClickListener(new SearchActivity.3(this, str));
        this.f.addView(localView);
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    overridePendingTransition(0, 2130968583);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131427492: 
    case 2131427495: 
    case 2131427496: 
    case 2131427497: 
    default: 
      return;
    case 2131427493: 
      this.c.setText("");
      this.g.setVisibility(8);
      this.i.setVisibility(0);
      f();
      return;
    case 2131427491: 
      finish();
      overridePendingTransition(0, 2130968583);
      return;
    case 2131427498: 
      this.e.setVisibility(8);
      PrefUtils.d();
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
    getActionBar().hide();
    ButterKnife.a(this);
    MobclickAgent.onEvent(this.a, "view_search");
    a();
    f();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.o != null) {
      this.o.clear();
    }
    if (this.p != null) {
      this.p.clear();
    }
    if (this.q != null) {
      this.q.clear();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default: 
      return;
    case 2131427500: 
      DetailInfoActivity.a(this.a, ((Food)this.p.get(paramInt)).code);
      return;
    }
    this.n = ((String)this.q.get(paramInt));
    a(this.n);
  }
  
  public void onPause()
  {
    super.onPause();
    KeyBoardUtils.a(this.a, this.c);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = (paramInt1 + paramInt2);
    this.m = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.m == this.l) && (this.j <= 10) && (this.j > this.k))
    {
      this.k = this.j;
      b(this.n);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SearchActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */