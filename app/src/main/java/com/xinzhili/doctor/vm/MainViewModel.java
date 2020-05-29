package com.xinzhili.doctor.vm;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/25 11:41
 */
public class MainViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();

    public MutableLiveData<String> getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public static class MainViewModelFactory implements ViewModelProvider.Factory{

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)(new MainViewModel());
        }
    }
}
