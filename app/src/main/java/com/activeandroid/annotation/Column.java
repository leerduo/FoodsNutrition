package com.activeandroid.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Column
{
  String a() default "";
  
  int b() default -1;
  
  boolean c() default false;
  
  Column.ConflictAction d() default Column.ConflictAction.FAIL;
  
  Column.ForeignKeyAction e() default Column.ForeignKeyAction.NO_ACTION;
  
  Column.ForeignKeyAction f() default Column.ForeignKeyAction.NO_ACTION;
  
  boolean g() default false;
  
  Column.ConflictAction h() default Column.ConflictAction.FAIL;
  
  String[] i() default {};
  
  Column.ConflictAction[] j() default {};
  
  boolean k() default false;
  
  String[] l() default {};
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.annotation.Column
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */