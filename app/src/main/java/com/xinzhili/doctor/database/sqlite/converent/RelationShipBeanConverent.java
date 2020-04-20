package com.xinzhili.doctor.database.sqlite.converent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinzhili.doctor.bean.RelationshipBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hello on 18/9/14.
 */

public class RelationShipBeanConverent implements PropertyConverter<List<RelationshipBean>, String> {

    private final Gson mGson = new Gson();


    @Override
    public List<RelationshipBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        Type type = new TypeToken<ArrayList<RelationshipBean>>() {
        }.getType();
        ArrayList<RelationshipBean> itemList = mGson.fromJson(databaseValue, type);
        return itemList;
    }


    @Override
    public String convertToDatabaseValue(List<RelationshipBean> entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        String dbString = mGson.toJson(entityProperty);
        return dbString;
    }
}
