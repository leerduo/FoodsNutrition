package com.boohee.food.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.boohee.food.fragment.TopicFragment;
import com.boohee.food.model.TopicDetail;
import java.util.List;

public class TopicAdapter
  extends FragmentPagerAdapter
{
  private List<TopicDetail> a;
  
  public TopicAdapter(List<TopicDetail> paramList, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.a = paramList;
  }
  
  public TopicFragment a(int paramInt)
  {
    return new TopicFragment();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    TopicFragment localTopicFragment = (TopicFragment)super.instantiateItem(paramViewGroup, paramInt);
    localTopicFragment.a((TopicDetail)this.a.get(paramInt));
    return localTopicFragment;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.TopicAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */