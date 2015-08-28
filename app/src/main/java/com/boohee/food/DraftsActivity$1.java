package com.boohee.food;

import android.widget.Button;
import com.boohee.food.util.MobUtils.OnLoginListener;
import com.boohee.food.util.ToastUtils;

class DraftsActivity$1
  implements MobUtils.OnLoginListener
{
  DraftsActivity$1(DraftsActivity paramDraftsActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.d.setEnabled(true);
    this.a.d();
    ToastUtils.b(paramString);
    if (paramBoolean) {
      MainActivity.a(this.a);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DraftsActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */