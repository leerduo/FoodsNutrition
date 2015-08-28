package com.boohee.food.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.astuetz.PagerSlidingTabStrip.CustomTabProvider;
import java.util.List;

public class FragmentAdapter
  extends FragmentStatePagerAdapter
  implements PagerSlidingTabStrip.CustomTabProvider
{
  private Context a;
  private List<Fragment> b;
  private String[] c;
  private int[] d;
  
  public FragmentAdapter(FragmentManager paramFragmentManager, Context paramContext, List<Fragment> paramList, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramFragmentManager);
    this.a = paramContext;
    this.b = paramList;
    this.c = paramArrayOfString;
    this.d = paramArrayOfInt;
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903113, null);
    TextView localTextView = (TextView)localView.findViewById(2131427595);
    ImageView localImageView = (ImageView)localView.findViewById(2131427596);
    localTextView.setText(this.c[paramInt]);
    if (this.d[paramInt] == 0)
    {
      localImageView.setImageResource(2130837587);
      return localView;
    }
    localImageView.setImageResource(2130837590);
    return localView;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.b.get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return this.c[paramInt];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.FragmentAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */