package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.adapter.IngredientInfoAdapter;
import com.boohee.food.model.FoodCompare;
import com.boohee.food.model.FoodInfo;
import com.boohee.food.model.IngredientInfo;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.FoodUtils;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.PrefUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.FoodRequest;
import com.boohee.food.volley.IFoodRequest;
import com.boohee.food.volley.JsonParams;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

public class DetailInfoActivity
  extends BaseActivity
{
  ImageView b;
  TextView c;
  TextView d;
  TextView e;
  RadioGroup f;
  RadioButton g;
  RadioButton h;
  ImageView i;
  LinearLayout j;
  TextView k;
  ImageView l;
  TextView m;
  TextView n;
  ListView o;
  private Menu p;
  private IngredientInfoAdapter q;
  private List<IngredientInfo> r = new ArrayList();
  private FoodInfo s;
  
  private void a()
  {
    this.o.setFocusable(false);
    this.o.setOnTouchListener(new DetailInfoActivity.1(this));
    this.q = new IngredientInfoAdapter(this, this.r);
    this.o.setAdapter(this.q);
  }
  
  private void a(int paramInt)
  {
    if (!AccountUtils.d()) {}
    while ((this.p == null) || (this.p.getItem(0) == null)) {
      return;
    }
    c();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = AccountUtils.a();
    IFoodRequest.a(String.format("/v2/favorite_foods/%s?token=%s", arrayOfObject), new DetailInfoActivity.4(this, this), this);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ToastUtils.b(paramContext.getString(2131558464));
      return;
    }
    MobclickAgent.onEvent(paramContext, "view_food_detail");
    Intent localIntent = new Intent(paramContext, DetailInfoActivity.class);
    localIntent.putExtra("key_food_code", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void a(MenuItem paramMenuItem)
  {
    if (!AccountUtils.d()) {
      AuthActivity.a(this);
    }
    while (this.s == null) {
      return;
    }
    boolean bool = getString(2131558450).equals(paramMenuItem.getTitle());
    JsonParams localJsonParams = null;
    int i1;
    String str;
    if (bool)
    {
      i1 = 3;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.s.id);
      arrayOfObject[1] = AccountUtils.a();
      str = String.format("/v2/favorite_foods/%s?token=%s", arrayOfObject);
    }
    for (;;)
    {
      paramMenuItem.setEnabled(false);
      c();
      IFoodRequest.a(i1, str, localJsonParams, new DetailInfoActivity.5(this, this, paramMenuItem, bool), this);
      return;
      str = "/v2/favorite_foods/";
      localJsonParams = new JsonParams();
      localJsonParams.a("food_id", this.s.id);
      localJsonParams.a("code", this.s.code);
      localJsonParams.a("token", AccountUtils.a());
      i1 = 1;
    }
  }
  
  private void b()
  {
    ImageLoader.d(this.b, this.s.thumb_image_url);
    boolean bool1 = PrefUtils.f();
    this.g.setChecked(bool1);
    RadioButton localRadioButton = this.h;
    boolean bool2;
    if (!bool1)
    {
      bool2 = true;
      localRadioButton.setChecked(bool2);
      this.f.setOnCheckedChangeListener(new DetailInfoActivity.2(this));
      this.c.setText(this.s.name);
      this.d.setText(FoodUtils.a(this.s.calory, true));
      this.e.setText(FoodUtils.a(this.s.weight, this.s.is_liquid, true));
      FoodUtils.b(this.s.health_light, this.i);
      if (!TextUtils.isEmpty(this.s.appraise)) {
        break label312;
      }
      this.k.setText(getString(2131558456));
      label155:
      FoodCompare localFoodCompare = this.s.compare;
      if ((localFoodCompare == null) || (TextUtils.isEmpty(localFoodCompare.target_name))) {
        break label329;
      }
      ImageLoader.f(this.l, localFoodCompare.target_image_url);
      this.m.setText(localFoodCompare.amount1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localFoodCompare.amount0);
      localStringBuilder.append(localFoodCompare.unit0);
      localStringBuilder.append(this.s.name);
      localStringBuilder.append(" ≈ ");
      localStringBuilder.append(localFoodCompare.amount1);
      localStringBuilder.append(localFoodCompare.unit1);
      localStringBuilder.append(localFoodCompare.target_name);
      this.n.setText(localStringBuilder.toString());
    }
    for (;;)
    {
      e();
      return;
      bool2 = false;
      break;
      label312:
      this.k.setText(this.s.appraise);
      break label155;
      label329:
      this.j.setVisibility(8);
    }
  }
  
  private void e()
  {
    FoodUtils.a(this.r, this.s.ingredient);
    FoodUtils.a(this.r, this.s.lights);
    FoodUtils.a(this.r);
    this.q.notifyDataSetChanged();
  }
  
  private void f()
  {
    String str1 = getIntent().getStringExtra("key_food_code");
    if (TextUtils.isEmpty(str1))
    {
      finish();
      return;
    }
    String str2 = String.format("/fb/v1/foods/%s", new Object[] { str1 });
    c();
    FoodRequest.a(str2, new DetailInfoActivity.3(this, this), this);
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/boohee/food/DetailInfoActivity:r	Ljava/util/List;
    //   4: invokeinterface 406 1 0
    //   9: astore_1
    //   10: aload_1
    //   11: invokeinterface 411 1 0
    //   16: ifeq +73 -> 89
    //   19: aload_1
    //   20: invokeinterface 415 1 0
    //   25: checkcast 417	com/boohee/food/model/IngredientInfo
    //   28: astore_2
    //   29: aload_2
    //   30: getfield 420	com/boohee/food/model/IngredientInfo:value	Ljava/lang/String;
    //   33: invokestatic 426	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   36: pop
    //   37: invokestatic 428	com/boohee/food/util/FoodUtils:b	()Z
    //   40: ifeq +57 -> 97
    //   43: aload_0
    //   44: ldc_w 429
    //   47: invokevirtual 169	com/boohee/food/DetailInfoActivity:getString	(I)Ljava/lang/String;
    //   50: aload_2
    //   51: getfield 432	com/boohee/food/model/IngredientInfo:unit	Ljava/lang/String;
    //   54: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +40 -> 97
    //   60: aload_2
    //   61: aload_0
    //   62: ldc_w 433
    //   65: invokevirtual 169	com/boohee/food/DetailInfoActivity:getString	(I)Ljava/lang/String;
    //   68: putfield 432	com/boohee/food/model/IngredientInfo:unit	Ljava/lang/String;
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 46	com/boohee/food/DetailInfoActivity:s	Lcom/boohee/food/model/FoodInfo;
    //   76: getfield 270	com/boohee/food/model/FoodInfo:calory	Ljava/lang/String;
    //   79: iconst_1
    //   80: invokestatic 275	com/boohee/food/util/FoodUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   83: invokestatic 436	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: putfield 420	com/boohee/food/model/IngredientInfo:value	Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 71	com/boohee/food/DetailInfoActivity:q	Lcom/boohee/food/adapter/IngredientInfoAdapter;
    //   93: invokevirtual 379	com/boohee/food/adapter/IngredientInfoAdapter:notifyDataSetChanged	()V
    //   96: return
    //   97: invokestatic 428	com/boohee/food/util/FoodUtils:b	()Z
    //   100: ifne -90 -> 10
    //   103: aload_0
    //   104: ldc_w 433
    //   107: invokevirtual 169	com/boohee/food/DetailInfoActivity:getString	(I)Ljava/lang/String;
    //   110: aload_2
    //   111: getfield 432	com/boohee/food/model/IngredientInfo:unit	Ljava/lang/String;
    //   114: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifeq -107 -> 10
    //   120: aload_2
    //   121: aload_0
    //   122: ldc_w 429
    //   125: invokevirtual 169	com/boohee/food/DetailInfoActivity:getString	(I)Ljava/lang/String;
    //   128: putfield 432	com/boohee/food/model/IngredientInfo:unit	Ljava/lang/String;
    //   131: aload_2
    //   132: aload_0
    //   133: getfield 46	com/boohee/food/DetailInfoActivity:s	Lcom/boohee/food/model/FoodInfo;
    //   136: getfield 270	com/boohee/food/model/FoodInfo:calory	Ljava/lang/String;
    //   139: iconst_1
    //   140: invokestatic 275	com/boohee/food/util/FoodUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   143: invokestatic 436	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: putfield 420	com/boohee/food/model/IngredientInfo:value	Ljava/lang/String;
    //   149: goto -60 -> 89
    //   152: astore_3
    //   153: goto -64 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	DetailInfoActivity
    //   9	11	1	localIterator	java.util.Iterator
    //   28	104	2	localIngredientInfo	IngredientInfo
    //   152	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   29	37	152	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427426: 
      LargeImageActivity.a(this.a, this.s.name, this.s.large_image_url);
      return;
    case 2131427435: 
      LightIntroduceActivity.a(this);
      return;
    }
    IngredientInfoActivity.a(this.a, this.r);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903068);
    ButterKnife.a(this);
    a();
    f();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.p = paramMenu;
    getMenuInflater().inflate(2131689472, paramMenu);
    return true;
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
    a(paramMenuItem);
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.s != null) {
      a(this.s.id);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DetailInfoActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */