package com.activeandroid;

import com.activeandroid.serializer.CalendarSerializer;
import com.activeandroid.serializer.FileSerializer;
import com.activeandroid.serializer.SqlDateSerializer;
import com.activeandroid.serializer.TypeSerializer;
import com.activeandroid.serializer.UtilDateSerializer;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

class ModelInfo$1
  extends HashMap<Class<?>, TypeSerializer>
{
  ModelInfo$1(ModelInfo paramModelInfo)
  {
    put(Calendar.class, new CalendarSerializer());
    put(java.sql.Date.class, new SqlDateSerializer());
    put(java.util.Date.class, new UtilDateSerializer());
    put(File.class, new FileSerializer());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.ModelInfo.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */