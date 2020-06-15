#include <string>
#include <jni.h>
#include <jni.h>

/**
 * jstring 转 char
 */
char *JString2CStr(JNIEnv *env, jstring jstr) {
    char *rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    //这里填写是工作空间的编码，若是默认中文则是GB2312
    jstring strencode = env->NewStringUTF("UTF-8");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte *ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);  //字符串拼接函数...
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    return rtn;
}
//*****************************************************

extern "C"
JNIEXPORT jstring JNICALL
Java_com_xinzhili_doctor_jni_JniUtil_hello(
        JNIEnv *env,
        jobject thiz,
        jstring name) {
    //因为 char *ch="hello"; 这样声明的字符串是常量，是不允许修改的
    char ch[20] = "hello ";
    char *str = strcat(ch, (char *) env -> GetStringUTFChars(name, JNI_FALSE));
    return env->NewStringUTF(str);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_xinzhili_doctor_jni_JniUtil_strFromJni(JNIEnv *env, jobject thiz) {
    char ch[20] = "天下無賊";
    return env->NewStringUTF(ch);
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_xinzhili_doctor_jni_JniUtil_aBoolean(JNIEnv *env, jobject thiz) {
}

//Java_com_xinzhili._strFromJni(
//        JNIEnv* env,
//        jobject,
//        jstring javaStr){
//
//    char str[20] = "hello";
//    char *string = JString2CStr(env, javaStr);
//    //char *strcat(char *dest, const char *src)
//    //dest -- 指向目标数组，该数组包含了一个 C 字符串，且足够容纳追加后的字符串。
//    //src -- 指向要追加的字符串，该字符串不会覆盖目标字符串。
//    //该函数返回一个指向最终的目标字符串 dest 的指针。
//    strcat(str,string);
//    return env->NewStringUTF(str);
//
//    //因为 char *ch="hello"; 这样声明的字符串是常量，是不允许修改的
////    char ch[20] = "hello";
////    char *str = strcat(ch, (char *) env -> GetStringUTFChars(javaStr, JNI_FALSE));
////    return env->NewStringUTF(str);
//}
