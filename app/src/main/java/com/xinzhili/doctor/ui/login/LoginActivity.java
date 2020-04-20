package com.xinzhili.doctor.ui.login;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.xinzhili.doctor.BuildConfig;
import com.xinzhili.doctor.MainActivity;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseActivity;
import com.xinzhili.doctor.base.BaseContract;
import com.xinzhili.doctor.contract.LoginContract;
import com.xinzhili.doctor.presenter.LoginPresenter;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.view.ClearEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 15:29
 */
public class LoginActivity extends BaseActivity implements LoginContract.IView {


    @BindView(R.id.et_account)
    ClearEditText etAccount;
    @BindView(R.id.iv_account_complete)
    ImageView ivAccountComplete;
    @BindView(R.id.et_password)
    ClearEditText etPassword;
    @BindView(R.id.iv_show_hide_password)
    ImageView ivShowHidePassword;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login_agreement)
    TextView tvLoginAgreement;
    @BindView(R.id.ll_protocal_privacl)
    LinearLayout llProtocalPrivacl;

    private boolean showPassword = false;
    private LoginPresenter mPresenter;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return mPresenter;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void initViews() {
        initInputObserver();

        if (BuildConfig.DEBUG){
            etAccount.setText("18514748006");
            etPassword.setText("111111");
        }
    }

    //初始化用戶名、密码输入监听
    private void initInputObserver(){
        InitialValueObservable<CharSequence> accountObservable = RxTextView.textChanges(etAccount);
        InitialValueObservable<CharSequence> pwdObservable = RxTextView.textChanges(etPassword);

        //observable 普通的写法
//        Observable.combineLatest(accountObservable, pwdObservable, new BiFunction<CharSequence, CharSequence, Boolean>() {
//            @Override
//            public Boolean apply(CharSequence phone, CharSequence pwd) {
//                return isPhoneValid(phone.toString()) && isPasswordValid(pwd.toString());
//            }
//        }).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) {
//                btnLogin.setEnabled(aBoolean);
//            }
//        });
        Disposable disposable = Observable.combineLatest(accountObservable, pwdObservable,
                ((phone, pwd) -> isPhoneValid(phone.toString()) && isPasswordValid(pwd.toString())))
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        btnLogin.setEnabled(true);
                    } else {
                        btnLogin.setEnabled(false);
                    }
                });

        mCompositeDisposable.add(disposable);
    }

    @Override
    public void initData() {

    }

    /**
     * 检查手机号是否有效
     *
     * @param phone phone
     * @return boolean
     */
    private boolean isPhoneValid(String phone) {
        return !TextUtils.isEmpty(phone) && phone.length() == 11;
    }

    /**
     * 检查密码是否有效
     *
     * @param password password
     * @return boolean
     */
    private boolean isPasswordValid(String password) {
        return !TextUtils.isEmpty(password) && password.length() > 5;
    }

    @Override
    public void loginSuccess() {
        MainActivity.actionStart(mContext);
        finish();
    }

    @Override
    public String getAccount() {
        return etAccount.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    private void login(){
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "password");
        map.put("device_token", "1111111111111111111");
        map.put("username", getAccount());
        map.put("password", getPassword());
        map.put("device_type", "android");
        mPresenter.doLogin(map);
    }

    @OnClick({R.id.iv_show_hide_password, R.id.tv_forget_password, R.id.btn_login, R.id.tv_login_agreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_show_hide_password:
                showPassword = !showPassword;
                if (showPassword) {// 显示密码
                    ivShowHidePassword.setImageResource(R.drawable.icon_login_show_password);
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().toString().length());
                } else {// 隐藏密码
                    ivShowHidePassword.setImageResource(R.drawable.icon_login_hide_password);
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etPassword.setSelection(etPassword.getText().toString().length());
                }
                break;
            case R.id.tv_forget_password:
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_login_agreement:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }
}
