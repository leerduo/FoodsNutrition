package com.boohee.food.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.boohee.food.model.upload.UploadFood;
import com.boohee.food.upload.UploadStateActivity;
import com.boohee.food.util.ImageLoader;
import com.boohee.food.view.BooheeListView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class UploadAdapter
  extends SimpleBaseAdapter<UploadFood>
  implements AdapterView.OnItemClickListener
{
  private BooheeListView c;
  
  public UploadAdapter(Context paramContext, List<UploadFood> paramList, BooheeListView paramBooheeListView)
  {
    super(paramContext, paramList);
    this.c = paramBooheeListView;
    this.c.setOnItemClickListener(this);
  }
  
  public static final String a(Context paramContext, int paramInt)
  {
    try
    {
      String str = paramContext.getResources().getStringArray(2131165187)[paramInt];
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public int a()
  {
    return 2130903115;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<UploadFood>.ViewHolder paramSimpleBaseAdapter)
  {
    UploadFood localUploadFood = (UploadFood)getItem(paramInt);
    if (localUploadFood == null) {
      return paramView;
    }
    ImageLoader.d((CircleImageView)paramSimpleBaseAdapter.a(2131427585), localUploadFood.thumb_img_url);
    TextView localTextView = (TextView)paramSimpleBaseAdapter.a(2131427581);
    if (TextUtils.isEmpty(localUploadFood.food_name)) {}
    for (String str1 = localUploadFood.barcode;; str1 = localUploadFood.food_name)
    {
      localTextView.setText(str1);
      try
      {
        str2 = a(this.a, localUploadFood.state);
        if ((TextUtils.isEmpty(localUploadFood.message)) || ("null".equals(localUploadFood.message))) {
          break label208;
        }
        str3 = str2 + ":" + localUploadFood.message;
        ((TextView)paramSimpleBaseAdapter.a(2131427599)).setText(str3);
        View localView = paramSimpleBaseAdapter.a(2131427598);
        if (localUploadFood.state != 1) {
          break;
        }
        i = 0;
        localView.setVisibility(i);
        return paramView;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2;
          localException.printStackTrace();
          continue;
          int i = 8;
          continue;
          String str3 = str2;
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    UploadFood localUploadFood = (UploadFood)getItem(paramInt);
    UploadStateActivity.a(this.a, localUploadFood);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.UploadAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */