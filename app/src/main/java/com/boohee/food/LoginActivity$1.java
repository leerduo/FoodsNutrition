package com.boohee.food;

import android.widget.Button;
import com.boohee.food.util.MobUtils.OnLoginListener;
import com.boohee.food.util.ToastUtils;

class LoginActivity$1
  implements MobUtils.OnLoginListener
{
  LoginActivity$1(LoginActivity paramLoginActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.d.setEnabled(true);
    this.a.d();
    ToastUtils.b(paramString);
    if (paramBoolean) {
      MyActivity.a(this.a);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LoginActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */