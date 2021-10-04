package zhida.business.domain.servcie;

import zhida.business.domain.model.MoneyRecord;
import zhida.business.domain.model.UserInfo;

import java.util.List;

public interface TempService {

    List<MoneyRecord> getRecord();

    List<UserInfo> getUserInfo(UserInfo userInfo);

}
