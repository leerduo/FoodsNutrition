package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JSONType
{
  boolean alphabetic() default true;
  
  boolean asm() default true;
  
  String[] ignores() default {};
  
  Class<?> mappingTo() default "Ljava/lang/Void;";
  
  String[] orders() default {};
  
  Feature[] parseFeatures() default {};
  
  SerializerFeature[] serialzeFeatures() default {};
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.annotation.JSONType
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */