package com.boohee.food.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.boohee.food.model.Category;
import com.boohee.food.util.ImageLoader;
import java.util.List;

public class CategoryAdapter
  extends SimpleBaseAdapter<Category>
{
  private String c;
  
  public CategoryAdapter(Context paramContext, String paramString, List<Category> paramList)
  {
    super(paramContext, paramList);
    this.c = paramString;
  }
  
  public int a()
  {
    int i = 2130903102;
    if ("season".equals(this.c)) {
      i = 2130903103;
    }
    return i;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<Category>.ViewHolder paramSimpleBaseAdapter)
  {
    Category localCategory = (Category)getItem(paramInt);
    if (localCategory == null) {
      return paramView;
    }
    ((TextView)paramSimpleBaseAdapter.a(2131427581)).setText(localCategory.name);
    ImageView localImageView = (ImageView)paramSimpleBaseAdapter.a(2131427551);
    if ("cooking".equals(this.c))
    {
      paramView.setBackgroundResource(2130837563);
      localImageView.setVisibility(8);
      return paramView;
    }
    if ("season".equals(this.c)) {
      ((TextView)paramSimpleBaseAdapter.a(2131427582)).setText(localCategory.description);
    }
    paramView.setBackgroundResource(2130837564);
    ImageLoader.e(localImageView, localCategory.image_url);
    return paramView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.CategoryAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */