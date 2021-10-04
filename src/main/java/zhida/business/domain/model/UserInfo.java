package zhida.business.domain.model;

import lombok.Data;

/**
 * @description:
 * @author: zhanglin
 * @date:  2021/7/6 22:04
 */

@Data
public class UserInfo {
    private Integer id;

    private String name;

    private String password;

    private String isAdmin;

    private String telephoneNum;

    private String email;

    private String idCard;
}
