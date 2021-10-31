package zhida.business.domain.servcie;

import zhida.business.domain.model.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserManagerService {
    Map<String,String> insert(UserInfo userInfo);

    Boolean checkNameExist(UserInfo userInfo);

    List<UserInfo> queryUserInfo(String name);

    void deleteUser(Integer id);

    void setAdmin(Integer id);
}
