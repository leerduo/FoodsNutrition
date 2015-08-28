package com.boohee.food.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.boohee.food.model.upload.DraftFood;
import com.boohee.food.upload.UploadEditActivity;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.view.BooheeListView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class DraftsAdapter
  extends SimpleBaseAdapter<DraftFood>
  implements AdapterView.OnItemClickListener
{
  private BooheeListView c;
  
  public DraftsAdapter(Context paramContext, List<DraftFood> paramList)
  {
    super(paramContext, paramList);
  }
  
  public DraftsAdapter(Context paramContext, List<DraftFood> paramList, BooheeListView paramBooheeListView)
  {
    this(paramContext, paramList);
    if (paramBooheeListView != null)
    {
      this.c = paramBooheeListView;
      this.c.setOnItemClickListener(this);
    }
  }
  
  public int a()
  {
    return 2130903105;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<DraftFood>.ViewHolder paramSimpleBaseAdapter)
  {
    DraftFood localDraftFood = (DraftFood)getItem(paramInt);
    if (localDraftFood == null) {
      return paramView;
    }
    ImageLoader.g((CircleImageView)paramSimpleBaseAdapter.a(2131427585), localDraftFood.front_img_url);
    TextView localTextView = (TextView)paramSimpleBaseAdapter.a(2131427581);
    if (TextUtils.isEmpty(localDraftFood.food_name)) {}
    for (String str = this.a.getString(2131558636);; str = localDraftFood.food_name)
    {
      localTextView.setText(str);
      ((TextView)paramSimpleBaseAdapter.a(2131427508)).setText(localDraftFood.barcode);
      return paramView;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    DraftFood localDraftFood = (DraftFood)getItem(paramInt);
    if (localDraftFood != null) {
      UploadEditActivity.a(this.a, localDraftFood);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.DraftsAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */