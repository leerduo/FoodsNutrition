package com.boohee.food.upload;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.boohee.food.BaseActivity;
import com.boohee.food.adapter.DraftsAdapter;
import com.boohee.food.model.upload.DraftFood;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.view.BooheeListView;
import java.util.ArrayList;
import java.util.List;

public class ListDraftsActivity
  extends BaseActivity
{
  BooheeListView b;
  private List<DraftFood> c = new ArrayList();
  private DraftsAdapter d;
  
  private void a()
  {
    this.c.clear();
    this.d.notifyDataSetChanged();
    From localFrom = new Select().a(DraftFood.class);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = AccountUtils.b();
    List localList = localFrom.a("user_key = ? ", arrayOfObject).b("create_time desc").b();
    if ((localList != null) && (localList.size() > 0))
    {
      this.c.addAll(localList);
      this.d.notifyDataSetChanged();
      return;
    }
    ToastUtils.b(getString(2131558635));
    this.b.postDelayed(new ListDraftsActivity.1(this), getResources().getInteger(2131492873));
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, ListDraftsActivity.class));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903077);
    ButterKnife.a(this);
    this.d = new DraftsAdapter(this, this.c, this.b);
    this.b.setAdapter(this.d);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.ListDraftsActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */