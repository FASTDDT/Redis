package help.Form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegistForm {

    @NotBlank(message = "手机号不能为空！")
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "手机号格式错误！")
    private String phone;
//    @Size(max = 5,min = 2,message = "............")
    private Integer nickname;
    @Email(message = "输入正确的邮箱！")
    @NotBlank(message = "email")
    private String email;
}
