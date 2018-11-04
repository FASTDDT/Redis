package help.Form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    @NotNull
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @NotNull
    @ApiModelProperty(value = "用户密码")
    private String password;
}
