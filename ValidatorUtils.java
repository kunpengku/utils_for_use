package com.example.test_redis.demo;

import java.util.regex.Pattern;

/**
 * 常用正则表达式
 */
public class ValidatorUtils {

    private ValidatorUtils() {
    }

    /**
     * 纯数字,非空
     * + 的意思是 1个或多个， 所以是非空的
     */
    public static boolean isNumeric(String str) {
        return str.matches("[0-9]+");
    }

    /**
     * 纯数字,非空
     * \d 等价于 [0-9] , 等于是另一种写法。
     */
    public static boolean isNumericV2(String str) {
        return str.matches("\\d+");
    }

    /**
     * (?![0-9]+$) 是一个 零宽 前行断言， 表示 这个字符串 不能是 纯数字的
     * (?![a-zA-Z]+$) 表示 这个字符串 不能是 纯字母的
     * [0-9A-Za-z~!@$%^&*()_+]{8,20} 表示 这个字符是由 括号内的字符组成，8-20个。
     *
     * 整体的意思是 ，这个字符串 8-20个字符组成，不能纯数字，不能纯字母。特殊字符仅限于 ~!@$%^&*()_+
     * 所以 可以通过的组合有
     * 1，数字+字母
     * 2，数字+特殊字符
     * 3，字母+特殊字符
     * 4，全是特殊字符
     * 5，数字+字母+特殊字符
     */
    public static boolean isStrongPassword(String password) {
        return password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z~!@$%^&*()_+]{8,20}$");
    }

    /**
     * 只包含中文基本字符
     * 想要匹配中文，就需要只要中文的编码范围，根据Unicode规定，中文的编码范围为
     * U+4e00-U+9fff . 网上查到的最常用的范围是 4E00-9FA5 ，基本差别不大，只有几十个差距，用哪个应该问题都不大。
     * 这个范围能够包含2万多个汉字，完全可以包含日常使用的汉字了。
     */
    public static boolean isChinese(String str) {
        return str.matches("^[\\u4e00-\\u9fa5]+$");
    }

    /**
     * 不包含英文字母
     */
    public static boolean isNotEnglish(String str) {
        return str.matches("[^a-zA-Z]+");
    }

    /**
     * 由数字、26个英文字母或者下划线组成的字符串，非空
     * \w 代表 [a-zA-Z_0-9]
     */
    public static boolean isEnglishCharactar(String str) {
        return str.matches("^\\w+$");
    }

    /**
     * 手机号校验
     */
    public static boolean validateMobile(String mobile) {
        return Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}$", mobile);
    }


    /**
     * 这个一个非常复杂的email检查，实际工作中，可能输入的邮箱 是 很有限很具体的，那就应该
     * 写一个简单的，特定的对邮箱的正则检查
     * http://emailregex.com/index.html
     */
    public static boolean validateEmail(String email) {
        return Pattern.matches(
                "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
                email);
    }

    /**
     * 这就是一个简单的版本，基本够用。
     */
    public static boolean validateEmailSimple(String email) {
        return Pattern.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", email);
    }
}
