package zhida.business.po;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Data
public class UserInfoPO {
    private Integer id;

    @NotNull(message = "用户名不能为空！")
    private String name;

    @NotNull(message = "密码不能为空！")
    private String password;

    private String isAdmin;

    @NotNull(message = "电话号码不能为空！")
    private String telephoneNum;

    @NotNull(message = "邮箱不能为空！")
    private String email;

    @NotNull(message = "身份证号码不能为空！")
    private String idCard;

    public Map<String,String> checkUserInfo(){
        String regPassword = "^[0-9a-zA-Z_]{1,12}$";
        Map checkResult = new HashMap();
        boolean isMatchPassword = Pattern.matches(regPassword, this.password);
        if(!isMatchPassword){
            checkResult.put("passwordBasic","密码长度为1-12，且只能由数字、字母、下划线组成");
        }
        String regPasswordRule = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{2,}$";
        if(!isMatchPassword){
            checkResult.put("password","密码需要至少包含一个字母和数字");
        }
        String regName = "^[0-9a-zA-Z_]{1,8}$";
        boolean isMatchName = Pattern.matches(regName, this.name);
        if(!isMatchName){
            checkResult.put("nameBasic","用户名长度为1-8，且只能由数字、字母、下划线组成");
        }
        return checkResult;
    }

}
