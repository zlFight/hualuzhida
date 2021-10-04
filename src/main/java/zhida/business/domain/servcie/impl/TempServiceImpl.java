package zhida.business.domain.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhida.business.domain.model.MoneyRecord;
import zhida.business.domain.model.UserInfo;
import zhida.business.domain.repo.MoneyRepo;
import zhida.business.domain.repo.UserRepo;
import zhida.business.domain.servcie.TempService;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhanglin
 * @date:  2021/6/20 13:55
 */

@Service
public class TempServiceImpl implements TempService {

    @Autowired
    private MoneyRepo moneyRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<MoneyRecord> getRecord() {
        List<MoneyRecord> temp = new ArrayList<MoneyRecord>();
        MoneyRecord moneyRecord = new MoneyRecord();
        moneyRecord.setAmount(10000);
        moneyRecord.setPurposeOrSource("test");
        temp.add(moneyRecord);

        return temp;
//        return moneyRepo.getMoneyRecord();
    }

    @Override
    public List<UserInfo> getUserInfo(UserInfo userInfo) {
        return userRepo.getUserInfo(userInfo);
    }

}
