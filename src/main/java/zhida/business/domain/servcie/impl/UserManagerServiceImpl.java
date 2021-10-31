package zhida.business.domain.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhida.business.domain.model.UserInfo;
import zhida.business.domain.repo.UserRepo;
import zhida.business.domain.servcie.UserManagerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Map<String,String> insert(UserInfo userInfo) {
        int id = userRepo.insert(userInfo);
//        int id =1;
        Map resultMap = new HashMap();
        resultMap.put("result","success");
        resultMap.put("id",String.valueOf(id));
        return resultMap;
    }

    @Override
    public Boolean checkNameExist(UserInfo userInfo) {
        List<UserInfo> result = userRepo.selectByName(userInfo);
        Map resultMap = new HashMap();
        if(result!=null && result.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public List<UserInfo> queryUserInfo(String name) {
        return userRepo.queryUserInfo(name);
    }

    @Override
    public void deleteUser(Integer id) {

        userRepo.deleteUser(id);
    }

    @Override
    public void setAdmin(Integer id) {
        userRepo.setAdmin(id);
    }
}
