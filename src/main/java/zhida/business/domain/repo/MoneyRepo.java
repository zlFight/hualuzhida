package zhida.business.domain.repo;

import org.springframework.stereotype.Repository;
import zhida.business.domain.model.MoneyRecord;

import java.util.List;

@Repository
public interface MoneyRepo {
    List<MoneyRecord> getMoneyRecord();
}
