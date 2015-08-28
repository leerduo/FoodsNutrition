package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.MobUtils;
import com.boohee.food.util.ToastUtils;

public class LoginActivity
  extends BaseActivity
{
  EditText b;
  EditText c;
  Button d;
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, LoginActivity.class));
  }
  
  public void booheeLogin(View paramView)
  {
    String str1 = this.b.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      ToastUtils.b(getString(2131558509));
      return;
    }
    String str2 = this.c.getText().toString();
    if (TextUtils.isEmpty(str2))
    {
      ToastUtils.b(getString(2131558508));
      return;
    }
    this.d.setEnabled(false);
    c();
    MobUtils.a(this, str1, str2, new LoginActivity.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    ButterKnife.a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    if (AccountUtils.d()) {
      finish();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LoginActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */