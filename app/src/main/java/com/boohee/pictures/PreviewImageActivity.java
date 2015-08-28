package com.boohee.pictures;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.List;

public class PreviewImageActivity
  extends FragmentActivity
{
  private static List<String> mPictures;
  private FragmentManager mFManager;
  private PreviewImageActivity.MPagerAdapter mPagerAdapter;
  private ViewPager mViewPager;
  
  private void init()
  {
    this.mFManager = getSupportFragmentManager();
    initActionBar();
    initViewPager();
  }
  
  private void initActionBar()
  {
    ActionBar localActionBar = getActionBar();
    localActionBar.setDisplayHomeAsUpEnabled(true);
    localActionBar.setDisplayShowHomeEnabled(true);
  }
  
  private void initViewPager()
  {
    this.mViewPager = ((ViewPager)findViewById(R.id.view_pager));
    this.mPagerAdapter = new PreviewImageActivity.MPagerAdapter(this, this.mFManager);
    this.mViewPager.setAdapter(this.mPagerAdapter);
  }
  
  public static void startMe(Context paramContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      Toast.makeText(paramContext, "no image", 0).show();
      return;
    }
    mPictures = paramList;
    paramContext.startActivity(new Intent(paramContext, PreviewImageActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_display_picture);
    init();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.PreviewImageActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */