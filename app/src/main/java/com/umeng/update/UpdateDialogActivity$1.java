package com.umeng.update;

import android.view.View;
import android.view.View.OnClickListener;

class UpdateDialogActivity$1
  implements View.OnClickListener
{
  UpdateDialogActivity$1(UpdateDialogActivity paramUpdateDialogActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (this.b == paramView.getId()) {
      this.a.a = 5;
    }
    for (;;)
    {
      this.a.finish();
      return;
      if (this.c == paramView.getId()) {
        this.a.a = 7;
      } else if (this.a.c) {
        this.a.a = 7;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.UpdateDialogActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */