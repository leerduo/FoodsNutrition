package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSONArray;
import com.boohee.food.adapter.IngredientInfoAdapter;
import com.boohee.food.model.IngredientInfo;
import com.boohee.food.util.ToastUtils;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

public class IngredientInfoActivity
  extends BaseActivity
{
  ListView b;
  private List<IngredientInfo> c = new ArrayList();
  private IngredientInfoAdapter d;
  
  private void a()
  {
    this.d = new IngredientInfoAdapter(this, this.c);
    this.b.setAdapter(this.d);
  }
  
  public static void a(Context paramContext, List<IngredientInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      ToastUtils.b(paramContext.getString(2131558464));
      return;
    }
    MobclickAgent.onEvent(paramContext, "view_food_nutrition");
    Intent localIntent = new Intent(paramContext, IngredientInfoActivity.class);
    localIntent.putExtra("key_ingredient_info", JSONArray.toJSONString(paramList));
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    String str = getIntent().getStringExtra("key_ingredient_info");
    if (!TextUtils.isEmpty(str))
    {
      this.c.addAll(JSONArray.parseArray(str, IngredientInfo.class));
      this.d.notifyDataSetChanged();
      return;
    }
    ToastUtils.b("Parameter error!");
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903073);
    ButterKnife.a(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      this.c.clear();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.IngredientInfoActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */