package com.xinzhili.doctor.database.sqlite.converent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinzhili.doctor.bean.UserBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;


/**
 * Created by hello on 18/9/14.
 */

public class UserBeanConverent implements PropertyConverter<UserBean, String> {

    private final Gson mGson = new Gson();


    @Override
    public UserBean convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        Type type = new TypeToken<UserBean>() {
        }.getType();
        UserBean userBean = mGson.fromJson(databaseValue, type);
        return userBean;
    }


    @Override
    public String convertToDatabaseValue(UserBean entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        String str = mGson.toJson(entityProperty);
        return str;
    }

}
