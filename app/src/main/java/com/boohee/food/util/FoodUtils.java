package com.boohee.food.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.boohee.food.FoodApplication;
import com.boohee.food.model.FoodIngredient;
import com.boohee.food.model.FoodLights;
import com.boohee.food.model.IngredientInfo;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FoodUtils
{
  public static final String[] a = { "calory@热量@大卡@500", "protein@蛋白质@克@505", "fat@脂肪@克@510", "carbohydrate@碳水化合物@克@515", "fiber_dietary@膳食纤维@克@520", "vitamin_a@维生素A@微克@525", "vitamin_c@维生素C@毫克@530", "vitamin_e@维生素E@毫克@535", "carotene@胡罗卜素@微克@540", "thiamine@维生素B1@毫克@545", "lactoflavin@维生素B2@毫克@550", "niacin@烟酸@毫克@555", "cholesterol@胆固醇@毫克@560", "magnesium@镁@毫克@565", "calcium@钙@毫克@570", "iron@铁@毫克@575", "zinc@锌@毫克@580", "copper@铜@毫克@585", "manganese@锰@毫克@590", "kalium@钾@毫克@595", "phosphor@磷@毫克@600", "natrium@钠@毫克@605", "selenium@硒@微克@615" };
  
  public static float a(float paramFloat)
  {
    return (float)(4.184D * paramFloat);
  }
  
  public static IngredientInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (int i = 0; i < a.length; i++)
    {
      String[] arrayOfString = a[i].split("@");
      if (paramString.equals(arrayOfString[0]))
      {
        IngredientInfo localIngredientInfo = new IngredientInfo();
        String str1 = arrayOfString[1];
        String str2 = arrayOfString[2];
        localIngredientInfo.order = Integer.parseInt(arrayOfString[3]);
        localIngredientInfo.name = str1;
        localIngredientInfo.code = paramString;
        localIngredientInfo.unit = str2;
        return localIngredientInfo;
      }
    }
    return null;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        float f1 = Float.parseFloat(paramString);
        if (PrefUtils.f()) {}
        for (;;)
        {
          return String.valueOf((int)f1);
          float f2 = a(f1);
          f1 = f2;
        }
        if (!TextUtils.isEmpty(paramString)) {
          return paramString;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      paramString = "";
    }
    return paramString;
  }
  
  public static String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = FoodApplication.a().getString(2131558470);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = a(paramBoolean2);
    arrayOfObject[1] = paramString;
    if (paramBoolean1) {}
    for (String str2 = "毫升";; str2 = "克")
    {
      arrayOfObject[2] = str2;
      return String.format(str1, arrayOfObject);
    }
  }
  
  public static String a(boolean paramBoolean)
  {
    int i = 2131558446;
    if ((!paramBoolean) || (PrefUtils.f())) {}
    for (;;)
    {
      return FoodApplication.a().getResources().getString(i);
      i = 2131558447;
    }
  }
  
  public static void a()
  {
    if (!PrefUtils.f()) {}
    for (boolean bool = true;; bool = false)
    {
      PrefUtils.b(bool);
      return;
    }
  }
  
  public static void a(int paramInt, ImageView paramImageView)
  {
    switch (paramInt)
    {
    default: 
      paramImageView.setBackgroundResource(2130837607);
      return;
    case 0: 
      paramImageView.setBackgroundResource(2130837607);
      return;
    case 1: 
      paramImageView.setBackgroundResource(2130837608);
      return;
    case 2: 
      paramImageView.setBackgroundResource(2130837610);
      return;
    }
    paramImageView.setBackgroundResource(2130837609);
  }
  
  public static void a(List<IngredientInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Collections.sort(paramList, new FoodUtils.1());
  }
  
  public static void a(List<IngredientInfo> paramList, FoodIngredient paramFoodIngredient)
  {
    if ((paramList == null) || (paramFoodIngredient == null)) {}
    for (;;)
    {
      return;
      paramList.clear();
      try
      {
        Field[] arrayOfField = paramFoodIngredient.getClass().getDeclaredFields();
        for (int i = 0; i < arrayOfField.length; i++)
        {
          IngredientInfo localIngredientInfo = a(arrayOfField[i].getName());
          if (localIngredientInfo != null)
          {
            Object localObject = arrayOfField[i].get(paramFoodIngredient);
            if ((localObject == null) || ("".equals(localObject.toString())) || ("null".equals(localObject)))
            {
              localObject = "--";
              localIngredientInfo.unit = "";
            }
            localIngredientInfo.value = localObject.toString();
            paramList.add(localIngredientInfo);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(List<IngredientInfo> paramList, FoodLights paramFoodLights)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramFoodLights == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        Field[] arrayOfField = paramFoodLights.getClass().getDeclaredFields();
        int i = 0;
        if (i >= arrayOfField.length) {
          break;
        }
        String str = arrayOfField[i].getName();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          IngredientInfo localIngredientInfo = (IngredientInfo)localIterator.next();
          if (str.equals(localIngredientInfo.code)) {
            localIngredientInfo.memo = String.valueOf(arrayOfField[i].get(paramFoodLights));
          }
        }
        else
        {
          i++;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public static void b(int paramInt, ImageView paramImageView)
  {
    switch (paramInt)
    {
    default: 
      paramImageView.setBackgroundResource(2130837643);
      return;
    case 0: 
      paramImageView.setBackgroundResource(2130837643);
      return;
    case 1: 
      paramImageView.setBackgroundResource(2130837647);
      return;
    case 2: 
      paramImageView.setBackgroundResource(2130837649);
      return;
    }
    paramImageView.setBackgroundResource(2130837648);
  }
  
  public static boolean b()
  {
    return PrefUtils.f();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.FoodUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */