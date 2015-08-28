package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class LargeImageActivity
  extends FragmentActivity
{
  ImageView a;
  
  private void a()
  {
    setTitle(getIntent().getStringExtra("key_food_name"));
    String str = getIntent().getStringExtra("key_image_url");
    Picasso.a(this).a(str).a(2130837637).b(2130837637).a(this.a);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, LargeImageActivity.class);
    localIntent.putExtra("key_image_url", paramString2);
    localIntent.putExtra("key_food_name", paramString1);
    paramContext.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903075);
    ButterKnife.a(this);
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LargeImageActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */