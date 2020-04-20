package com.xinzhili.doctor.database.sqlite.utils;

import android.database.sqlite.SQLiteDatabase;

import com.xinzhili.doctor.App;
import com.xinzhili.doctor.database.sqlite.greendao.DaoMaster;
import com.xinzhili.doctor.database.sqlite.greendao.DaoSession;
import com.xinzhili.doctor.database.sqlite.greendao.MyOpenHelper;
import com.xinzhili.mvp.common.Constant;

/**
 * 描述: greendao utils
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/20 16:24
 */
public class GreenDaoUtils {
    private MyOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static GreenDaoUtils greenDaoUtils;

    private GreenDaoUtils() {
    }

    public static GreenDaoUtils getSingleTon() {
        if (greenDaoUtils == null) {
            synchronized (GreenDaoUtils.class) {
                if (greenDaoUtils == null) {
                    greenDaoUtils = new GreenDaoUtils();
                }
            }
        }
        return greenDaoUtils;
    }

    private void initGreenDao() {
        mHelper = new MyOpenHelper(App.getInstance().getAppContext(), Constant.DATABASE_NAME, null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        if (mDaoMaster == null) {
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            initGreenDao();
        }
        return db;
    }

}
