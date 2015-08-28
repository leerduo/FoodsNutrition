package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.boohee.food.model.upload.DraftFood;
import com.boohee.food.upload.ListDraftsActivity;
import com.boohee.food.upload.ListUploadActivity;
import com.boohee.food.upload.UploadStepOneActivity;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.util.SDcard;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.FoodRequest;
import com.boohee.food.volley.IFoodRequest;
import com.boohee.pictures.PictureUpload;
import com.boohee.pictures.model.AuthParams;
import com.umeng.analytics.MobclickAgent;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class MyActivity
  extends BaseActivity
  implements View.OnClickListener
{
  TextView b;
  CircleImageView c;
  Button d;
  Button e;
  private int f;
  private int g;
  private int h;
  
  private void a()
  {
    if (this.h == 0) {
      SDcard.d();
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!AccountUtils.d())
    {
      ToastUtils.b(2131558507);
      return;
    }
    Intent localIntent = new Intent(paramContext, MyActivity.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, String paramString)
  {
    paramView.setOnClickListener(this);
    ((ImageView)paramView.findViewById(2131427596)).setImageResource(paramInt1);
    ((TextView)paramView.findViewById(2131427600)).setText(getString(paramInt2));
    ((TextView)paramView.findViewById(2131427601)).setText(paramString);
  }
  
  private void b()
  {
    PictureUpload.init(new AuthParams(this.a, AccountUtils.a(), AccountUtils.b()), 1, "house/f").debug(false);
  }
  
  private void e()
  {
    MobclickAgent.onEvent(this.a, "view_me");
    if (AccountUtils.d())
    {
      this.b.setText(AccountUtils.e());
      ImageLoader.a(this.c, AccountUtils.f());
      this.d.setVisibility(0);
      this.e.setText(2131558538);
    }
    for (;;)
    {
      a(findViewById(2131427486), 2130837582, 2131558534, "");
      a(findViewById(2131427487), 2130837583, 2131558536, "");
      a(findViewById(2131427488), 2130837581, 2131558535, String.valueOf(h()));
      return;
      this.b.setText(2131558539);
      ImageLoader.a(this.c);
      this.d.setVisibility(8);
      this.e.setText(2131558537);
    }
  }
  
  private void f()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = AccountUtils.a();
    IFoodRequest.a(String.format("/v2/favorite_foods/count?token=%s", arrayOfObject), new MyActivity.1(this, this), this);
  }
  
  private void g()
  {
    FoodRequest.a("/fb/v1/food_drafts/count", new MyActivity.2(this, this), this);
  }
  
  private int h()
  {
    try
    {
      From localFrom = new Select().a(DraftFood.class);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = AccountUtils.b();
      int j = localFrom.a("user_key = ? ", arrayOfObject).b().size();
      i = j;
      this.h = i;
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  private void i()
  {
    if (AccountUtils.d())
    {
      AccountUtils.c();
      MainActivity.a(this);
      return;
    }
    AuthActivity.a(this);
  }
  
  public boolean a(View paramView)
  {
    LargeImageActivity.a(this, "", AccountUtils.f());
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427486: 
      if (this.f > 0)
      {
        CollectionActivity.a(this);
        return;
      }
      ToastUtils.a(2131558443);
      return;
    case 2131427487: 
      if (this.g > 0)
      {
        ListUploadActivity.a(this);
        return;
      }
      ToastUtils.a(2131558637);
      return;
    case 2131427488: 
      if (this.h > 0)
      {
        ListDraftsActivity.a(this);
        return;
      }
      ToastUtils.a(2131558635);
      return;
    case 2131427489: 
      UploadStepOneActivity.a(this);
      return;
    }
    i();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903082);
    ButterKnife.a(this);
    b();
    e();
    a();
  }
  
  public void onResume()
  {
    super.onResume();
    f();
    g();
    a(findViewById(2131427488), 2130837581, 2131558535, String.valueOf(h()));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MyActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */