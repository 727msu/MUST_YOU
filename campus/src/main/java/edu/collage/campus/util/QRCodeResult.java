package edu.collage.campus.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QRCodeResult<T> {

    enum EnumCode {
        SUCCESS(20010200, "The Verification code succeeds Procedure"),
        NOT_FOUND(20010401, "The Verification code in data not found"),

        VERIFITY_EXPIRED(20010402, "The Verification code datetime is expired"),
        SERVER_ERROR(20010501, "The Verification code service has error");
        // 枚举值的属性
        private final int code;
        private final String message;

        // 构造函数
        EnumCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }


    String msg;

    Integer code;

    T data;


    public static QRCodeResult<String> succeed() {
        return new QRCodeResult<>(EnumCode.SUCCESS, "验证码校验服务通过");
    }

    public static QRCodeResult<String> failed() {
        return new QRCodeResult<>(EnumCode.VERIFITY_EXPIRED, "二维码已过期");
    }


    public static QRCodeResult<String> notFound() {
        return new QRCodeResult<>(EnumCode.NOT_FOUND, "二维码数据未找到");
    }

    public static QRCodeResult<String> ServerFailed() {
        return new QRCodeResult<>(EnumCode.SERVER_ERROR, "二维码服务错误");
    }


    QRCodeResult(EnumCode enumCode, T data) {
        this.code = enumCode.code;
        this.msg = enumCode.message;
        this.data = data;
    }

}
