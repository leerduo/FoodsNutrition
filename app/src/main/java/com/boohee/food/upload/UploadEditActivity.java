package com.boohee.food.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.boohee.food.BaseActivity;
import com.boohee.food.SelectPictureActivity;
import com.boohee.food.model.upload.DraftFood;
import com.boohee.food.util.AlertDialogUtil;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.view.SquareImageView;
import com.boohee.food.volley.FoodRequest;
import com.boohee.food.volley.JsonParams;
import com.boohee.pictures.QiniuUploader;
import com.umeng.analytics.MobclickAgent;
import java.util.List;
import org.json.JSONException;

public class UploadEditActivity
  extends BaseActivity
{
  TextView b;
  EditText c;
  SquareImageView d;
  SquareImageView e;
  Button f;
  private DraftFood g;
  
  private void a()
  {
    Long localLong = Long.valueOf(getIntent().getLongExtra("key_drafts", 0L));
    List localList = new Select().a(DraftFood.class).a("Id = ?", new Object[] { localLong }).b();
    if ((localList == null) || (localList.size() == 0) || (localList.get(0) == null))
    {
      finish();
      return;
    }
    this.g = ((DraftFood)localList.get(0));
    this.b.setText(this.g.barcode);
    String str = this.g.food_name;
    if (!TextUtils.isEmpty(str))
    {
      this.c.setText(str);
      this.c.setSelection(str.length());
    }
    ImageLoader.h(this.d, this.g.front_img_url);
    ImageLoader.h(this.e, this.g.back_img_url);
  }
  
  public static void a(Context paramContext, DraftFood paramDraftFood)
  {
    if ((paramDraftFood == null) || (paramDraftFood.getId().longValue() <= 0L)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, UploadEditActivity.class);
    localIntent.putExtra("key_drafts", paramDraftFood.getId());
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
        int i = 0;
        if (i < localJSONArray.size())
        {
          com.alibaba.fastjson.JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          String str1 = localJSONObject.getString("path");
          String str2 = localJSONObject.getString("hash");
          String str3 = localJSONObject.getString("key");
          int j = localJSONObject.getIntValue("width");
          int k = localJSONObject.getIntValue("height");
          org.json.JSONObject localJSONObject1 = new org.json.JSONObject();
          if (!TextUtils.isEmpty(str2)) {
            break label336;
          }
          str4 = "Photo::Boohee";
          localJSONObject1.put("_type", str4);
          if (this.g.front_img_url.equals(str1))
          {
            localJSONObject1.put("photo_type", "front");
            localJSONObject1.put("qiniu_key", str3);
            localJSONObject1.put("qiniu_hash", str2);
            localJSONObject1.put("origin_width", j);
            localJSONObject1.put("origin_height", k);
            localJSONArray1.put(localJSONObject1);
            i++;
            continue;
          }
          if (!this.g.back_img_url.equals(str1)) {
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
      localJsonParams1.a("food_name", this.c.getText().toString());
      localJsonParams1.a("barcode", this.g.barcode);
      localJsonParams1.a("photos", localJSONArray1);
      JsonParams localJsonParams2 = new JsonParams();
      localJsonParams2.a("food_draft", localJsonParams1);
      c();
      FoodRequest.a("/fb/v1/food_drafts", localJsonParams2, new UploadEditActivity.2(this, this), this);
      return;
      label336:
      String str4 = "Photo::Qiniu";
    }
  }
  
  private void b()
  {
    this.g.food_name = this.c.getText().toString();
    this.g.create_time = String.valueOf(System.currentTimeMillis());
    this.g.save();
    finish();
  }
  
  private void e()
  {
    MobclickAgent.onEvent(this.a, "click_draft_upload");
    if (TextUtils.isEmpty(this.g.front_img_url))
    {
      ToastUtils.b(getString(2131558634));
      return;
    }
    if (TextUtils.isEmpty(this.g.back_img_url))
    {
      ToastUtils.b(getString(2131558621));
      return;
    }
    this.f.setEnabled(false);
    c();
    UploadEditActivity.1 local1 = new UploadEditActivity.1(this);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.g.front_img_url;
    arrayOfString[1] = this.g.back_img_url;
    QiniuUploader.upload(this, local1, arrayOfString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null)) {
      for (;;)
      {
        String str;
        try
        {
          str = com.alibaba.fastjson.JSONObject.parseArray(paramIntent.getStringExtra("KEY_RESULT_PICTURES")).get(0).toString();
          if ((TextUtils.isEmpty(str)) || (str.equals(this.g.front_img_url)) || (str.equals(this.g.back_img_url)))
          {
            ToastUtils.a(2131558639);
            return;
          }
          if (1122 == paramInt1)
          {
            this.g.front_img_url = str;
            ImageLoader.h(this.d, this.g.front_img_url);
            LogUtils.a(str);
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if (2233 == paramInt1)
        {
          this.g.back_img_url = str;
          ImageLoader.h(this.e, this.g.back_img_url);
        }
      }
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
    case 2131427510: 
      e();
      return;
    case 2131427511: 
      b();
      return;
    case 2131427424: 
      try
      {
        this.g.delete();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        finish();
      }
    case 2131427602: 
      SelectPictureActivity.a(this, 1122);
      return;
    }
    SelectPictureActivity.a(this, 2233);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903087);
    ButterKnife.a(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QiniuUploader.cancelAll();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadEditActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */