package zhida.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhida.business.domain.model.MoneyRecord;
import zhida.business.domain.model.UserInfo;
import zhida.business.domain.servcie.TempService;
import zhida.business.domain.util.DESUtils;
import zhida.business.domain.util.UserInfoUtils;

import java.util.*;

/**
 * @description:
 * @author: zhanglin
 * @date:  2021/6/20 10:20
 */
@RestController
@RequestMapping("/temp")
public class TempController {

    @Autowired
    private TempService tempService;

    @GetMapping("/money")
    public List<MoneyRecord> getMoney(){
        List<MoneyRecord> moneyRecordList = tempService.getRecord();
        return moneyRecordList;
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody UserInfo userInfo){
//        List<UserInfo> userInfoList = new ArrayList<>();
//        userInfoList.add(userInfo);
        userInfo.setPassword(DESUtils.encrypt(userInfo.getPassword(),UserInfoUtils.SECRET_KEY));
        List<UserInfo> userInfoList = tempService.getUserInfo(userInfo);
        Map<String,Object> loginResult = new HashMap();
        if(userInfoList!=null && userInfoList.size()==1){
            UserInfo currentUserInfo = userInfoList.get(0);

            loginResult.put("result","success");
            loginResult.put("userName",currentUserInfo.getName());
            loginResult.put("isAdmin",currentUserInfo.getIsAdmin());

            // 设置加密token及内存存储用户信息
            String uuidToken = UUID.randomUUID().toString().replaceAll("-","");
            UserInfoUtils.authTokens.put(uuidToken,currentUserInfo);

            String token = DESUtils.encrypt(uuidToken,UserInfoUtils.SECRET_KEY);
            loginResult.put("token",token);
        }else{
            loginResult.put("result","failed");
        }
        return loginResult;
    }
}
