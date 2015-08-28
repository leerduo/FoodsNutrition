package com.boohee.food.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.boohee.food.BaseActivity;
import com.boohee.food.adapter.UploadAdapter;
import com.boohee.food.model.upload.UploadFood;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.view.BooheeListView;
import com.boohee.food.volley.FoodRequest;
import java.util.ArrayList;
import java.util.List;

public class ListUploadActivity
  extends BaseActivity
{
  BooheeListView b;
  private List<UploadFood> c = new ArrayList();
  private UploadAdapter d;
  private int e = 0;
  private int f = 1;
  
  private void a()
  {
    this.d = new UploadAdapter(this, this.c, this.b);
    this.b.setAdapter(this.d);
    this.b.setOnLoadMoreListener(new ListUploadActivity.1(this));
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, ListUploadActivity.class));
  }
  
  private void b()
  {
    int i = 1 + this.e;
    if ((i > 1) && (i > this.f)) {
      return;
    }
    c();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = AccountUtils.a();
    FoodRequest.a(String.format("/fb/v1/food_drafts?page=%d&token=%s", arrayOfObject), new ListUploadActivity.2(this, this), this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903078);
    ButterKnife.a(this);
    a();
    b();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.ListUploadActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */