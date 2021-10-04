package zhida.business.domain.servcie;

import zhida.business.domain.model.UserInfo;

import java.util.Map;

public interface UserManagerService {
    Map<String,String> insert(UserInfo userInfo);

    Boolean checkNameExist(UserInfo userInfo);
}
