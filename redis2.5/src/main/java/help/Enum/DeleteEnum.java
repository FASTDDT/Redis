package help.Enum;

public enum DeleteEnum implements BaseEnum {
    IS_DELETE("已删除", 1),
    NOT_DELETE("未删除",0),
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
     * @param desc 描述
     * @param code 状态码
     */
    DeleteEnum(String desc, Integer code) {
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
