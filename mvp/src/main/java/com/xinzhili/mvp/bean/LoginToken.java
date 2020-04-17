package com.xinzhili.mvp.bean;

/**
 * 描述: LoginToken
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:10
 */
public class LoginToken {

    /**
     * access_token : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0NzAyNTMzNjIsInVzZXJfbmFtZSI6IjE4NjAwMDAwMDAxIiwiYXV0aG9yaXRpZXMiOlsiUEFUSUVOVF9SRUFEIiwiUEFUSUVOVF9XUklURSJdLCJqdGkiOiIyMjYyMjYyMi1jYzVmLTQxZWUtOWQ5OC0wNGUwZjU0NWVhNzUiLCJjbGllbnRfaWQiOiJwYXRpZW50X2FwcCIsInNjb3BlIjpbIlBBVElFTlQiXX0.fzr2ztcArKtq5OKuviRT4PV-zI-9-GzqQn7xPTJuMOGaBKlQJ9wYVsEyNKxIuNHMn9yMSmzrAD3x9UkGPj8-q8gvnfH6KKBzsLbyeofUVplCDWAXLcl8DVmNfQeoS9fjhY7mCoK3GW7KFQ52oJImchpjVv3pJ_KetEhijrE41RvyPd2KuBtrfRX8sz_XsGczHRmYQDD2qD4Kek0QoLSNCJV7dQtYq1P8MltFSlszEbmXEG9piLVGVkzoEUy8yoPrQbSVj9DAg3Uf5_jIwpNDYPLqKpuWjr3pnbIw0VNwzX44JgV-7OI2tqelDDBNU8NlgizMxZduH10wq3h-ONtEMA
     * token_type : bearer
     * refresh_token : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIxODYwMDAwMDAwMSIsInNjb3BlIjpbIlBBVElFTlQiXSwiYXRpIjoiMjI2MjI2MjItY2M1Zi00MWVlLTlkOTgtMDRlMGY1NDVlYTc1IiwiZXhwIjoxNDcyODAyMTYyLCJhdXRob3JpdGllcyI6WyJQQVRJRU5UX1JFQUQiLCJQQVRJRU5UX1dSSVRFIl0sImp0aSI6IjBmYjk4M2ExLWU1YmMtNDFhNS04MGM2LTI1MTY3MDY4MDk2ZCIsImNsaWVudF9pZCI6InBhdGllbnRfYXBwIn0.ZyMXh6kBAJsvqzCEn2a82PfFFPu4t4WzV9uULpqVU56LLYmnPSpUMXSbc_1kgW_fzKf6ssJTmStq6o5eqw1UD9iESFavWMUXfaCUTojfwGQjNr9QKKX9WsdBBmhCuxn-9aZghbkcBjqUCE114bSuILii72P7S3djolxMvp_5EelNwQ5zCNJlTZPEBy_AjqWOtvXr1r0CLVzJsuBjdzpYE9NcYPy0dJpbDUr9d-G0vHsWOgUMvYKPT_NwZmxhvTKbj_FEXey2wYCVP5_mZp2uWywwtLaxlQizRQYVP1zVHQo0vkwPqlzj1pHggm53egrcY-BJbM15l003MsyfjalHuw
     * expires_in : 43199
     * scope : DOCTOR
     * jti : 22622622-cc5f-41ee-9d98-04e0f545ea75
     */

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;
    private String error;
    private String error_description;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
