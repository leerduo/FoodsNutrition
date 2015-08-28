package com.boohee.food.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import de.hdodenhof.circleimageview.CircleImageView;

public class DrawerFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DrawerFragment paramDrawerFragment, Object paramObject)
  {
    View localView1 = paramFinder.a(paramObject, 2131427484, "field 'civAvatar', method 'onClick', and method 'onLongClick'");
    paramDrawerFragment.a = ((CircleImageView)localView1);
    localView1.setOnClickListener(new DrawerFragment..ViewInjector.1(paramDrawerFragment));
    localView1.setOnLongClickListener(new DrawerFragment..ViewInjector.2(paramDrawerFragment));
    View localView2 = paramFinder.a(paramObject, 2131427485, "field 'tvNickName' and method 'onClick'");
    paramDrawerFragment.b = ((TextView)localView2);
    localView2.setOnClickListener(new DrawerFragment..ViewInjector.3(paramDrawerFragment));
    paramFinder.a(paramObject, 2131427550, "method 'onItemClick'").setOnClickListener(new DrawerFragment..ViewInjector.4(paramDrawerFragment));
    paramFinder.a(paramObject, 2131427556, "method 'onItemClick'").setOnClickListener(new DrawerFragment..ViewInjector.5(paramDrawerFragment));
    paramFinder.a(paramObject, 2131427559, "method 'onItemClick'").setOnClickListener(new DrawerFragment..ViewInjector.6(paramDrawerFragment));
    paramFinder.a(paramObject, 2131427553, "method 'onItemClick'").setOnClickListener(new DrawerFragment..ViewInjector.7(paramDrawerFragment));
    paramFinder.a(paramObject, 2131427565, "method 'onItemClick'").setOnClickListener(new DrawerFragment..ViewInjector.8(paramDrawerFragment));
    paramFinder.a(paramObject, 2131427562, "method 'onItemClick'").setOnClickListener(new DrawerFragment..ViewInjector.9(paramDrawerFragment));
  }
  
  public static void reset(DrawerFragment paramDrawerFragment)
  {
    paramDrawerFragment.a = null;
    paramDrawerFragment.b = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.DrawerFragment..ViewInjector
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */