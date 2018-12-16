package help.Enum;

public enum CodeEnum implements BaseEnum {
    SUCCESS("成功", 1000001),
    FAILURE("失败", 1000002),
    PARAM_EMPTY("参数为空", 1000003),
    NOT_LOGINED("未登录", 1000004),
    NO_AUTHORITY("没有权限", 1000005),
    NO_USER("用户不存在", 1000006),
    ;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;


    /**
     * 构造器
     *
     * @param desc 描述
     * @param code 状态码
     */
    CodeEnum(String desc, Integer code) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDisc() {
        return desc;
    }

}
