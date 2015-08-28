package com.boohee.food.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.BaseActivity;
import com.boohee.food.adapter.UploadAdapter;
import com.boohee.food.model.upload.UploadFood;
import com.boohee.food.util.ImageLoader;

public class UploadStateActivity
  extends BaseActivity
{
  private UploadFood b;
  
  private void a()
  {
    this.b = ((UploadFood)UploadFood.parse(getIntent().getStringExtra("key_upload_food"), UploadFood.class));
    a(2131427512, 2131558640, this.b.barcode);
    a(2131427513, 2131558642, this.b.food_name);
    a(2131427514, 2131558646, this.b.upload_date);
    a(2131427515, 2131558643, UploadAdapter.a(this, this.b.state));
    if ((!TextUtils.isEmpty(this.b.message)) && (!"null".equals(this.b.message))) {
      a(2131427516, 2131558644, this.b.message);
    }
    for (;;)
    {
      ImageLoader.h((ImageView)findViewById(2131427602), this.b.front_img_url);
      ImageLoader.h((ImageView)findViewById(2131427491), this.b.back_img_url);
      return;
      findViewById(2131427516).setVisibility(8);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    View localView = findViewById(paramInt1);
    ((TextView)localView.findViewById(2131427581)).setText(paramInt2);
    ((TextView)localView.findViewById(2131427590)).setText(paramString);
  }
  
  public static void a(Context paramContext, UploadFood paramUploadFood)
  {
    if (paramUploadFood == null) {}
    String str;
    do
    {
      return;
      str = paramUploadFood.toString();
    } while (TextUtils.isEmpty(str));
    Intent localIntent = new Intent(paramContext, UploadStateActivity.class);
    localIntent.putExtra("key_upload_food", str);
    paramContext.startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903088);
    ButterKnife.a(this);
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStateActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */