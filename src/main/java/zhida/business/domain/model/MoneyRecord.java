package zhida.business.domain.model;

import lombok.Data;

import java.util.Date;



/**
 * @description:
 * @author: zhanglin
 * @date:  2021/6/20 13:55
 */

@Data
public class MoneyRecord {
    private long id;

    private long amount;

    private String purposeOrSource;

    private Date createTime;
}
