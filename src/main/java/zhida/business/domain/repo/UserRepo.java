package zhida.business.domain.repo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zhida.business.domain.model.UserInfo;

import java.util.List;

@Repository
public interface UserRepo {
    List<UserInfo> getUserInfo(@Param("user") UserInfo userInfo);

    int insert(@Param("user") UserInfo userInfo);

    List<UserInfo> selectByName(@Param("user") UserInfo userInfo);

    List<UserInfo> queryUserInfo(@Param("name") String name);

    void deleteUser(@Param("id") Integer id);

    void setAdmin(@Param("id") Integer id);
}
