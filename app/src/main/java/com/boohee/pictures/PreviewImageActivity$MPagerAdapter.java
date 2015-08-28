package com.boohee.pictures;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

class PreviewImageActivity$MPagerAdapter
  extends FragmentPagerAdapter
{
  public PreviewImageActivity$MPagerAdapter(PreviewImageActivity paramPreviewImageActivity, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    if (PreviewImageActivity.access$000() == null) {
      return 0;
    }
    return PreviewImageActivity.access$000().size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return PreviewImageFragment.newInstance((String)PreviewImageActivity.access$000().get(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.PreviewImageActivity.MPagerAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */