package com.xinzhili.doctor.database.sqlite.converent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinzhili.doctor.bean.DepartmentBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;


/**
 * Created by hello on 18/9/14.
 */

public class DepartmentBeanConverent implements PropertyConverter<DepartmentBean, String> {

    private final Gson mGson = new Gson();


    @Override
    public DepartmentBean convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        Type type = new TypeToken<DepartmentBean>() {
        }.getType();
        DepartmentBean departmentBean = mGson.fromJson(databaseValue, type);
        return departmentBean;
    }


    @Override
    public String convertToDatabaseValue(DepartmentBean entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        String str = mGson.toJson(entityProperty);
        return str;
    }

}
