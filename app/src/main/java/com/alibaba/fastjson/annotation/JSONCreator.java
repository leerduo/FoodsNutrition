package com.alibaba.fastjson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.METHOD})
public @interface JSONCreator {}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.annotation.JSONCreator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */