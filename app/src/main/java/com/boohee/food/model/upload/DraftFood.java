package com.boohee.food.model.upload;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.boohee.food.model.BaseModel;

@Table(a="draft_food")
public class DraftFood
  extends BaseModel
{
  public static final String BACK_IMG_URL = "back_img_url";
  public static final String BAR_CODE = "barcode";
  public static final String CREATE_TIME = "create_time";
  public static final String FONT_IMG_URL = "font_img_url";
  public static final String FOOD_NAME = "food_name";
  public static final String THUMB_IMG_URL = "thumb_img_url";
  public static final String USER_KEY = "user_key";
  @Column(a="back_img_url")
  public String back_img_url;
  @Column(a="barcode")
  public String barcode;
  @Column(a="create_time")
  public String create_time;
  @Column(a="food_name")
  public String food_name;
  @Column(a="front_img_url")
  public String front_img_url;
  @Column(a="thumb_img_url")
  public String thumb_img_url;
  @Column(a="user_key")
  public String user_key;
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.upload.DraftFood
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */