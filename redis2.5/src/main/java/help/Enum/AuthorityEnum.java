package help.Enum;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName AuthorityEnum
 * @since 2018/12/6 11:59
 */
public enum  AuthorityEnum implements BaseEnum {
    ROLE_USER("USER",1),
    ROLE_DBA("DBA",2),
    ROLE_ADMIN("ADMIN",3),
    ;

    String desc;
    Integer code;
    /**
     * 构造器
     * @param desc 描述
     * @param code 状态码
     */

    AuthorityEnum(String desc, Integer code) {
        this.code=code;
        this.desc=desc;
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
