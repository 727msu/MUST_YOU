package edu.collage.campus.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResult<T> {


    enum EnumCode {
        SUCCESS(200200, "succeed"),
        FAIlED(200401, "failure"),

        ERROR(200501, "error"),

        EXCEPTION(400400, "Exception");

        // 枚举值的属性
        private final int code;
        private final String message;

        // 构造函数
        EnumCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    RestResult(EnumCode enumCode, T data) {
        this.code = enumCode.code;
        this.msg = enumCode.message;
        this.data = data;
    }

    public RestResult(EnumCode enumCode) {
        this.code = enumCode.code;
        this.msg = enumCode.message;
    }

    String msg;

    Integer code;

    T data;


    public static RestResult<String> succeed() {
        return new RestResult<>(EnumCode.SUCCESS);
    }

    public static RestResult<String> failed() {
        return new RestResult<>(EnumCode.FAIlED);
    }


    public static RestResult<String> error() {
        return new RestResult<>(EnumCode.ERROR);
    }


    public static RestResult<String> succeed(String data) {
        return new RestResult<>(EnumCode.SUCCESS, data);
    }


    public static RestResult<String> failed(String data) {
        return new RestResult<>(EnumCode.FAIlED, data);
    }


    public static RestResult<String> error(String data) {
        return new RestResult<>(EnumCode.ERROR, data);
    }

    public static RestResult<String> exception(String data) {
        return new RestResult<>(EnumCode.EXCEPTION, data);
    }
}



