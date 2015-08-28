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
import com.boohee.food.BaseActivity;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.FoodRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class UploadStepOneActivity
  extends BaseActivity
{
  TextView b;
  EditText c;
  Button d;
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, UploadStepOneActivity.class));
  }
  
  private void a(String paramString)
  {
    c();
    FoodRequest.a(String.format("/fb/v1/foods/barcode?barcode=%s", new Object[] { paramString }), new UploadStepOneActivity.1(this, this, paramString), this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    IntentResult localIntentResult = IntentIntegrator.a(paramInt1, paramInt2, paramIntent);
    if (localIntentResult != null)
    {
      String str = localIntentResult.a();
      if (TextUtils.isEmpty(str))
      {
        ToastUtils.b(getString(2131558622));
        return;
      }
      a(str);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427517: 
      new IntentIntegrator(this).a(getString(2131558638)).a(2130903092).b(2130903093).b(IntentIntegrator.b);
      return;
    }
    UploadStepTwoActivity.a(this, this.b.getText().toString(), this.c.getText().toString());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903089);
    ButterKnife.a(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepOneActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */