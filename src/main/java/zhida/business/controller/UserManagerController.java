package zhida.business.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhida.business.domain.model.UserInfo;
import zhida.business.domain.servcie.UserManagerService;
import zhida.business.domain.util.DESUtils;
import zhida.business.domain.util.UserInfoUtils;
import zhida.business.po.UserInfoPO;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/userManage")
public class UserManagerController extends BaseController{
    @Autowired
    private UserManagerService userManagerService;

    @PostMapping("/insert")
    public Map<String,String> insert(@RequestBody @Valid UserInfoPO userInfoPo) throws Exception {
        //参数二次校验
        Map checkParam = userInfoPo.checkUserInfo();
        if(!checkParam.isEmpty()){
            throw new Exception(checkParam.toString());
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoPo,userInfo);
        if(userManagerService.checkNameExist(userInfo)){
            throw new Exception("userName has exist!");
        }
        userInfo.setPassword(DESUtils.encrypt(userInfoPo.getPassword(), UserInfoUtils.SECRET_KEY));
        return userManagerService.insert(userInfo);
    }


    @GetMapping("/checkNameExist")
    public Boolean checkNameExist(@RequestParam("name") String name) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        return userManagerService.checkNameExist(userInfo);
    }

    @GetMapping("/query")
    public Map<String, Object> queryUserInfo() throws Exception {
        if(!"Y".equals(request.getParameter("isAdmin"))){
            return error("current user not have authority!");
        }
        return successList(userManagerService.queryUserInfo(request.getParameter("userName")));
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteUser(@RequestBody() Map map) throws Exception {
        if(!"Y".equals(request.getParameter("isAdmin"))){
            return error("current user not have authority!");
        }
        userManagerService.deleteUser((Integer) map.get("id"));
        return success();
    }

    @PostMapping("/setAdmin")
    public Map<String, Object> setAdmin(@RequestBody() Map map) throws Exception {
        if(!"Y".equals(request.getParameter("isAdmin"))){
            return error("current user not have authority!");
        }
        userManagerService.setAdmin((Integer) map.get("id"));
        return success();
    }

}





