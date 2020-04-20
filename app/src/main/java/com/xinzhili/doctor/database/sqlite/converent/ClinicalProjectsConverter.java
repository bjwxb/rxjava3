package com.xinzhili.doctor.database.sqlite.converent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinzhili.doctor.bean.ClinicalProjectsBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * 描述: doctorUser->临床试验
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/1/19 18:25
 */
public class ClinicalProjectsConverter implements PropertyConverter<List<ClinicalProjectsBean>, String> {
    private final Gson mGson = new Gson();

    @Override
    public List<ClinicalProjectsBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        Type type = new TypeToken<ArrayList<ClinicalProjectsBean>>() {
        }.getType();
        return mGson.fromJson(databaseValue, type);
    }

    @Override
    public String convertToDatabaseValue(List<ClinicalProjectsBean> entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        return mGson.toJson(entityProperty);
    }
}
