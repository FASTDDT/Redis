package help.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import help.Enum.CodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于包装API的返回数据
 *
 * @author 尹思莲
 * @date 2018年03月08日15:37:46
 */
@ApiModel(value = "包装API的返回数据")
@Data
public class Result<T> {

    @ApiModelProperty(value = "<a href='http://cf.dawanju.net/pages/viewpage.action?pageId=15271434'>错误码</a>")
    private int code = CodeEnum.SUCCESS.getCode();

    @ApiModelProperty(value = "错误信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;

    @ApiModelProperty(value = "数据结果")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonIgnore
    private Map<String, Object> mapData;

    /**
     * 兼容直接添加key value的形式
     */
    @SuppressWarnings("unchecked")
    public void addData(String key, Object value) {
        if (mapData == null) {
            mapData = new HashMap<>(5);
        }
        this.mapData.put(key, value);
        data = (T) mapData;
    }

    public void setRestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setRestCodeEnum(CodeEnum restCodeEnum) {
        this.setRestCode(restCodeEnum.getCode(), restCodeEnum.getDisc());
    }

    public static <T> Result<T> getSuccessResult(T data) {
        Result<T> restResult = new Result<>();
        restResult.setRestCodeEnum(CodeEnum.SUCCESS);
        restResult.setData(data);
        return restResult;
    }

    public static Result getFailResult(int code, String desc) {
        Result restResult = new Result();
        restResult.setRestCode(code, desc);
        return restResult;
    }

    public static Result getFailResult(CodeEnum restCodeEnum) {
        return getFailResult(restCodeEnum.getCode(), restCodeEnum.getDisc());
    }

}
