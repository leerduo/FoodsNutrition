package com.boohee.food.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.BaseActivity;
import com.boohee.food.MyActivity;
import com.boohee.food.SelectPictureActivity;
import com.boohee.food.model.upload.DraftFood;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.AlertDialogUtil;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.NetworkUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.FoodRequest;
import com.boohee.food.volley.JsonParams;
import com.boohee.pictures.QiniuUploader;
import com.umeng.analytics.MobclickAgent;
import org.json.JSONException;

public class UploadStepTwoActivity
  extends BaseActivity
{
  ImageView b;
  Button c;
  Button d;
  ImageView e;
  ImageView f;
  TextView g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private void a()
  {
    if (!NetworkUtils.a()) {
      this.g.setVisibility(0);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, UploadStepTwoActivity.class);
    localIntent.putExtra("key_bar_code", paramString1);
    localIntent.putExtra("key_name", paramString2);
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      org.json.JSONArray localJSONArray1;
      try
      {
        com.alibaba.fastjson.JSONArray localJSONArray = com.alibaba.fastjson.JSONArray.parseArray(paramString);
        if ((localJSONArray == null) || (localJSONArray.size() < 2))
        {
          ToastUtils.b(getString(2131558631));
          return;
        }
        localJSONArray1 = new org.json.JSONArray();
        int m = 0;
        if (m < localJSONArray.size())
        {
          com.alibaba.fastjson.JSONObject localJSONObject = localJSONArray.getJSONObject(m);
          String str1 = localJSONObject.getString("path");
          String str2 = localJSONObject.getString("hash");
          String str3 = localJSONObject.getString("key");
          int n = localJSONObject.getIntValue("width");
          int i1 = localJSONObject.getIntValue("height");
          org.json.JSONObject localJSONObject1 = new org.json.JSONObject();
          if (!TextUtils.isEmpty(str2)) {
            break label319;
          }
          str4 = "Photo::Boohee";
          localJSONObject1.put("_type", str4);
          if (this.j.equals(str1))
          {
            localJSONObject1.put("photo_type", "front");
            localJSONObject1.put("qiniu_key", str3);
            localJSONObject1.put("qiniu_hash", str2);
            localJSONObject1.put("origin_width", n);
            localJSONObject1.put("origin_height", i1);
            localJSONArray1.put(localJSONObject1);
            m++;
            continue;
          }
          if (!this.k.equals(str1)) {
            continue;
          }
          localJSONObject1.put("photo_type", "back");
          continue;
        }
        localJsonParams1 = new JsonParams();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      JsonParams localJsonParams1;
      localJsonParams1.a("food_name", this.i);
      localJsonParams1.a("barcode", this.h);
      localJsonParams1.a("photos", localJSONArray1);
      JsonParams localJsonParams2 = new JsonParams();
      localJsonParams2.a("food_draft", localJsonParams1);
      c();
      FoodRequest.a("/fb/v1/food_drafts", localJsonParams2, new UploadStepTwoActivity.2(this, this), this);
      return;
      label319:
      String str4 = "Photo::Qiniu";
    }
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    this.h = localIntent.getStringExtra("key_bar_code");
    this.i = localIntent.getStringExtra("key_name");
  }
  
  private void e()
  {
    MobclickAgent.onEvent(this.a, "click_upload");
    if (TextUtils.isEmpty(this.j))
    {
      ToastUtils.b(getString(2131558634));
      return;
    }
    if (TextUtils.isEmpty(this.k))
    {
      ToastUtils.b(getString(2131558621));
      return;
    }
    this.c.setEnabled(false);
    c();
    UploadStepTwoActivity.1 local1 = new UploadStepTwoActivity.1(this);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.j;
    arrayOfString[1] = this.k;
    QiniuUploader.upload(this, local1, arrayOfString);
  }
  
  private void f()
  {
    DraftFood localDraftFood = new DraftFood();
    localDraftFood.user_key = AccountUtils.b();
    localDraftFood.barcode = this.h;
    localDraftFood.food_name = this.i;
    localDraftFood.front_img_url = this.j;
    localDraftFood.back_img_url = this.k;
    localDraftFood.create_time = String.valueOf(System.currentTimeMillis());
    localDraftFood.save();
    MyActivity.a(this);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {
      return;
    }
    switch (paramInt1)
    {
    case 3344: 
    case 4455: 
    default: 
      return;
    }
    String str;
    try
    {
      str = com.alibaba.fastjson.JSONObject.parseArray(paramIntent.getStringExtra("KEY_RESULT_PICTURES")).get(0).toString();
      if ((TextUtils.isEmpty(str)) || (str.equals(this.j)) || (str.equals(this.k)))
      {
        ToastUtils.a(2131558639);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (1122 == paramInt1)
    {
      this.j = str;
      ImageLoader.h(this.e, this.j);
      if ((!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.k))) {
        break label230;
      }
      this.c.setEnabled(false);
      this.d.setEnabled(false);
      this.b.setImageResource(2130837678);
    }
    for (;;)
    {
      LogUtils.a(str);
      return;
      if (2233 != paramInt1) {
        break;
      }
      this.k = str;
      ImageLoader.h(this.f, this.k);
      break;
      label230:
      this.c.setEnabled(true);
      this.d.setEnabled(true);
      this.b.setImageResource(2130837679);
    }
  }
  
  public void onBackPressed()
  {
    AlertDialogUtil.a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427602: 
      SelectPictureActivity.a(this, 1122);
      return;
    case 2131427491: 
      SelectPictureActivity.a(this, 2233);
      return;
    case 2131427510: 
      e();
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903090);
    ButterKnife.a(this);
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QiniuUploader.cancelAll();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepTwoActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */