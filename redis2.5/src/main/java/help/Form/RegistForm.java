package help.Form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RegistForm {

    @NotNull(message = "手机号不能为空！")
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "手机号格式错误！")
    private String phone;
    @NotNull(message = "............")
    @Length(max=6,message = "昵称太长了。。。")
    private String nickname;
    @Email(message = "输入正确的邮箱！")
    private String email;
}
