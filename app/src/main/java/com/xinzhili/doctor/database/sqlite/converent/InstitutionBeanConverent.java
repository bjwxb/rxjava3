package com.xinzhili.doctor.database.sqlite.converent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinzhili.doctor.bean.InstitutionBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;


/**
 * Created by hello on 18/9/14.
 */

public class InstitutionBeanConverent implements PropertyConverter<InstitutionBean, String> {

    private final Gson mGson = new Gson();


    @Override
    public InstitutionBean convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        Type type = new TypeToken<InstitutionBean>() {
        }.getType();
        InstitutionBean institutionBean = mGson.fromJson(databaseValue, type);
        return institutionBean;
    }


    @Override
    public String convertToDatabaseValue(InstitutionBean entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        String str = mGson.toJson(entityProperty);
        return str;
    }
}
