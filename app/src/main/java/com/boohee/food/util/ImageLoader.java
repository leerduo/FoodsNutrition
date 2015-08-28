package com.boohee.food.util;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.boohee.food.FoodApplication;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;

public class ImageLoader
{
  public static Picasso a()
  {
    Picasso.a(FoodApplication.a()).a(true);
    return Picasso.a(FoodApplication.a());
  }
  
  public static void a(ImageView paramImageView)
  {
    a(paramImageView, "", 2130837633, 2130837633);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    a(paramImageView, paramInt1, paramInt2, paramInt2);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramImageView == null) || (paramInt2 == 0) || (paramInt3 == 0)) {
      return;
    }
    a().a(paramInt1).a(paramInt2).b(paramInt3).a(paramImageView);
  }
  
  public static void a(ImageView paramImageView, Uri paramUri, int paramInt1, int paramInt2)
  {
    if ((paramImageView == null) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (paramUri == null)
    {
      a().a(paramInt1).a(paramImageView);
      return;
    }
    a().a(paramUri).a(paramInt1).b(paramInt2).a(paramImageView);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, 2130837633, 2130837633);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt)
  {
    a(paramImageView, paramString, paramInt, paramInt);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramImageView == null) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      a().a(paramInt1).a(paramImageView);
      return;
    }
    a().a(paramString).a(paramInt1).b(paramInt2).a(paramImageView);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramImageView == null) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      a().a(paramInt1).a(paramImageView);
      return;
    }
    try
    {
      if (paramString.startsWith("http"))
      {
        a().a(paramString).a(paramInt1).b(paramInt2).a(paramImageView);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Uri localUri = Uri.fromFile(new File(paramString));
    a().a(localUri).a(paramInt3, paramInt4).a(paramInt1).b(paramInt2).a(paramImageView);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramString.startsWith("http"))
    {
      a(paramImageView, paramString, paramInt1, paramInt2, 0, 0);
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    int k;
    if (paramBoolean) {
      k = 180;
    }
    while (Math.max(j, i) > k)
    {
      j /= 2;
      i /= 2;
      continue;
      k = 480;
    }
    a(paramImageView, paramString, paramInt1, paramInt2, j, i);
  }
  
  public static void b(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, 2130837638, 2130837638);
  }
  
  public static void c(ImageView paramImageView, String paramString)
  {
    paramImageView.startAnimation(AnimationUtils.loadAnimation(FoodApplication.a(), 2130968585));
    a(paramImageView, paramString, 2130837637, 2130837637);
    paramImageView.startAnimation(AnimationUtils.loadAnimation(FoodApplication.a(), 2130968584));
  }
  
  public static void d(ImageView paramImageView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("http")) {
        a(paramImageView, paramString, 2130837636, 2130837641);
      }
    }
    else {
      return;
    }
    a(paramImageView, Uri.fromFile(new File(paramString)), 2130837636, 2130837641);
  }
  
  public static void e(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, 2130837635, 2130837635);
  }
  
  public static void f(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, 2130837634, 2130837634);
  }
  
  public static void g(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, 2130837636, 2130837641, true);
  }
  
  public static void h(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, 2130837640, 2130837640, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.ImageLoader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */