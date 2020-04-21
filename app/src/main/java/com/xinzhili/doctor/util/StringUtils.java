package com.xinzhili.doctor.util;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;

/**
 * 字符串的工具类，包括校验，拼接...
 */
public class StringUtils {

    /**
     * 判断是否为手机号
     */
    public static boolean isPhoneNumber(String phone) {
        //由于电话号码更新太快了，实在不行就只校验第一位："^1\\d{10}$"
        Pattern p = Pattern.compile("^1[34578]\\d{9}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 校验字符串长度
     */
    public static boolean length6_18(String str) {
        return !(str.length() < 6 || str.length() > 18);
    }

    /**
     * 校验字符串是否为字母或者数字
     */
    public static boolean aZ09(String str) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 校验字符串是否为数字
     */
    public static boolean isNumeric(String str) {
        if (str != null && !"".equals(str.trim())) {
            return str.matches("^[0-9]*$");
        }
        return false;
    }

    public static boolean isInetegerOrFloat(String str) {
        if (str != null && !"".equals(str.trim())) {
            return (str.matches("^[-\\+]?[\\d]*$") || str.matches("^[-\\+]?[.\\d]*$"));
        }
        return false;
    }


    /**
     * 校验密码6-20位，ascii码值从20-7E
     */
    public static boolean checkPwdForm(String str) {
        Pattern p = Pattern.compile("^[\\x20-\\x7E]{6,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 身份证正则校验
     */
    public static boolean checkIdNumberRegex(String idNumber) {
        if(idNumber!=null){
            return Pattern.matches("^([0-9]{17}[0-9Xx])|([0-9]{15})$", idNumber);
        }
      return  false;
    }

    /**
     * 校验银行卡卡号(比较算出的校验位和卡号里的校验位)
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        if(cardId.length() < 15 || cardId.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 用不含校验位的银行卡卡号，采用 Luhm 校验算法获得校验位(卡号最后一位为校验位)
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            throw new IllegalArgumentException("Bank card code must be number!");
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }


    /**
     * 校验是否为邮箱
     */
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 屏蔽几位邮箱号码
     */
    public static String addStarForEmail(String str, int count) {
        int ix = str.indexOf("@");
        if (ix > -1) {
            String front = "";
            if (ix > count) {
                front = str.substring(0, count);
            }
            str = front + "***" + str.substring(ix);
        }
        return str;
    }

    /**
     * 屏蔽几位手机号码
     */
    public static String addStarForPhone(String str) {
        int start = 3;
        int end = 6;
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (start <= i && i <= end) {
                c[i] = '*';
            }
        }
        str = String.valueOf(c);
        return str;
    }

    public static String removeStrConent(String str1, String str2) {
        String content = str1.replaceAll(str2 + ".", "");
        return content;
    }

    /**
     * 去掉所有空格
     */
    public static String removeStrSpace(String str) {
        String content = str.replaceAll(" ", "");
        return content;
    }


    public static Integer removeContent(String content, String str) {
        String result = content.replaceAll(str, "");
        return Integer.parseInt(result);
    }

    /**
     * 将:替换成-
     */
    public static String replaceStrColon(String str) {
        String content = str.replaceAll(":", "-");
        return content;
    }

    /**
     * 去掉所有:
     */
    public static String removeAllColon(String str) {
        String content = str.replaceAll(":", "");
        return content;
    }

    /**
     * 使用UTF-8解析url
     */
    public static String urlDecode(String url) {
        String decodeUrl = null;
        try {
            decodeUrl = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            decodeUrl = url;
            e.printStackTrace();
        }
        return decodeUrl;
    }

    /**
     * 切割字符串（获取手机号后三位）
     */
    public static String getLastThreePhotoNumber(String photoNumber) {
        String str = "001";
        try {
            str = photoNumber.substring(8, 11);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 去掉.0
     */
    public static String formatData(double data) {
        if (data == (long) data) {
            return String.format("%d", (long) data);
        } else {
            return String.format("%s", data);
        }

    }

    /**
     * 去掉.0
     */
    public static String formatStringData(String data) {
        double resultData = Double.parseDouble(data);
        if (resultData == (long) resultData) {
            return String.format("%d", (long) resultData);
        } else {
            return String.format("%s", resultData);
        }

    }

    /**
     * 是否包含中文
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        return m.find() ? true : false;
    }

    /**
     * 月日时分秒，0-9前补0
     */
    @NonNull
    public static String fillZero(int number) {
        return number < 10 ? "0" + number : "" + number;
    }

    /**
     * 截取掉前缀0以便转换为整数
     *
     * @see #fillZero(int)
     */
    public static int trimZero(@NonNull String text) {
        try {
            if (text.startsWith("0")) {
                text = text.substring(1);
            }
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String formatPhoneNum(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum) || phoneNum.length() != 11) {
            return phoneNum;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(phoneNum.substring(0, 3)).append(" ").append(phoneNum.substring(3, 7)).append(" ").append(phoneNum.substring(7));
        return stringBuilder.toString();
    }

    /**
     * （1）过滤出字母的正则表达式
     * [^(A-Za-z)]
     * <p>
     * （2）过滤出数字的正则表达式
     * [^(0-9)]
     * <p>
     * （3）过滤出中文的正则表达式
     * [^(\\u4e00-\\u9fa5)]
     * <p>
     * （4）过滤出字母、数字和中文的正则表达式
     * [^(a-zA-Z0-9\\u4e00-\\u9fa5)]
     */

    public static String formStringToChara(String s) {
        return s.replaceAll("[^A-Za-z]", "");
    }

    public static String formAllStringToChara(String s) {
        return s.replaceAll("[^(/a-zA-Z\\u4e00-\\u9fa5)]", "");
    }

    public static String formStringToNum(String s) {
        return s.replaceAll(formAllStringToChara(s), "");
    }

    public static boolean isNull(String str) {
        return null == str || "null".equals(str) || "".equals(str);
    }

    public static String getSubString(String str, int count) {
        if (str.length() > count) {
            return str.substring(str.length() - count);
        } else {
            return str;
        }
    }

    public static String getDay(long time) {

        Calendar today = Calendar.getInstance();
        Calendar old = Calendar.getInstance();
        old.setTimeInMillis(time);

        //此处好像是去除0
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        old.set(Calendar.HOUR, 0);
        old.set(Calendar.MINUTE, 0);
        old.set(Calendar.SECOND, 0);
        //老的时间减去今天的时间
        long intervalMilli = old.getTimeInMillis() - today.getTimeInMillis();
        int xcts = (int) (intervalMilli / (24 * 60 * 60 * 1000));
        // -2:前天 -1：昨天 0：今天 1：明天 2：后天， out：显示日期
        if (xcts >= -1 && xcts <= 1) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

            String prefix = "今天";
            switch (xcts) {
                case -2:
                    prefix = "前天";
                    break;
                case -1:
                    prefix = "昨天";
                    break;
                case -0:
                    prefix = "今天";
                    break;
                case 1:
                    prefix = "明天";
                    break;
                case 2:
                    prefix = "后天";
                    break;
            }

            return prefix + " " + dateFormat.format(new Date(time));
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.getDefault());
            return dateFormat.format(new Date(time));
        }
    }

    public static String formatDate(long time, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return dateFormat.format(new Date(time));
    }

    /**
     * 将string的list转换成以逗号分隔的字符串
     * @param list List<String></String>
     * @return String
     */
    public static String splitListStringByComma(List<String> list){
        if (null == list || list.size() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if (i == list.size() - 1){
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 将string的list转换成以逗号分隔的字符串
     * @param list List<String></String>
     * @return String
     */
    public static String splitListStringByComma(List<String> list, String symbol){
        if (null == list || list.size() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if (i == list.size() - 1){
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(symbol);
            }
        }
        Dlog.e(sb.toString());
        return sb.toString();
    }

    /**
     * 将Integer的list转换成以逗号分隔的字符串
     * @param list List<Integer></String>
     * @return String
     */
    public static String splitListIntegerByComma(List<Integer> list){
        if (null == list || list.size() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if (i == list.size() - 1){
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(",");
            }
        }
        return sb.toString();
    }

    public static List<String> splitDoctorSearchHistory(String resultData) {
        List<String> stringList =  new ArrayList<>();
         String[] a1 = resultData.split(";");
        for(int i=0;i< a1.length;i++) {
            stringList.add(a1[i]);
        }
        return  stringList;
    }


    //后台返回的数据转换成年月
    public static String setSinceToYear(String since){
        since=StringUtils.isNull(since) ? "0" : since;

        int year,month;
        if(since.contains(".")){
            year= Integer.parseInt(since.substring(0,since.indexOf(".")))/12;

            month= Integer.parseInt(since.substring(0,since.indexOf(".")))%12;
        }else {
            year= Integer.parseInt(since)/12;

            month= Integer.parseInt(since)%12;
        }


        return (year==0?"": (year+"年"))+(month==0?"": (month+"个月"));
    }

    public static String getKummerBundWheelView(int kummerbund) {
        double result = kummerbund / 33.33;
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        String resultStr = decimalFormat.format(result);
        resultStr = String.format("%.1f", Double.parseDouble(resultStr));
        resultStr = resultStr.replace("0", "");
        resultStr = resultStr.replace(".", "尺");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(resultStr);
        stringBuffer.append("  ");
        stringBuffer.append(kummerbund);
        stringBuffer.append("cm");
        return stringBuffer.toString();
    }


    public static String getKummerBundTextView(int kummerbund) {
        double result = kummerbund / 33.33;
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        String resultStr = decimalFormat.format(result);
        resultStr = String.format("%.1f", Double.parseDouble(resultStr));
        resultStr = resultStr.replace("0", "");
        resultStr = resultStr.replace(".", "尺");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(resultStr);
        stringBuffer.append("  ");
        stringBuffer.append(kummerbund);
        stringBuffer.append("cm");
        return stringBuffer.toString();
    }

    //将string list转换成 string 字符串
    public static String list2string(List<String> list){
        if (null == list || list.size() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s: list){
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
