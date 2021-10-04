package zhida.business.domain.util;

import java.util.HashMap;
import java.util.Map;


/**
 *  @author: zhanglin
 *  @Date: 2021/9/5 10:22
 *  @Description: 常量类
 */

public class ConstantUtils {
    /**
     * 请求连接符
     */
    public static final String REQUEST_CONNECTOR_QUESTION = "?";

    /**
     * 连接符 横线
     */
    public static final String REQUEST_CONNECTOR_LINE = "-";

    /**
     * 数据长度key
     */
    public static final String DATA_LENGTH_KEY = "total";
    /**
     * 分页步长key
     */
    public static final String PAGE_STEP_KEY = "pageSize";

    /**
     * 分页步长默认值 10
     */
    public static final Integer PAGE_STEP_VALUE = 10;

    /**
     * 分页页数默认值 1
     */
    public static final Integer PAGE_NUMBER_VALUE = 1;

    /**
     * 分页页数key
     */
    public static final String PAGE_NUMBER_KEY = "pageNum";

    /**
     * 返回消息处理，状态key
     */
    public static final String HTTP_KEY_CODE = "state";

    /**
     * 返回消息处理，状态value 成功 200
     */
    public static final Integer HTTP_VALUE_SUCCESS = 200;

    /**
     * 返回消息处理，状态value 失败 500
     */
    public static final Integer HTTP_VALUE_ERROR = 500;

    /**
     * 返回crud消息处理，状态value 成功 1
     */
    public static final Integer CRUD_VALUE_SUCCESS = 1;

    /**
     * 返回crud消息处理，状态value 失败 0
     */
    public static final Integer CRUD_VALUE_ERROR = 0;

    /**
     * 返回消息处理，查询数据集合key
     */
    public static final String SELECT_DATA_KEY = "data";

    /**
     * 返回消息处理，消息key
     */
    public static final String HTTP_KEY_MSG = "message";

    /**
     * 异常处理，返回路径key
     */
    public static final String HTTP_KEY_PATH = "path";

    /**
     * 异常处理，返回时间戳key
     */
    public static final String HTTP_KEY_TIM = "timeStamp";

    /**
     * http contenttype json
     */
    public static final String HTTP_CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

    /**
     * 权限验证返回消息
     */
    public static final String HTTP_MSG_AUTH_FAIL = "没有访问权限";

    /**
     * 查询失败消息key
     */
    public static final String MSG_KEY_FIND_FILE = "selectFail";

    /**
     * 查询成功消息key
     */
    public static final String MSG_KEY_FIND_SUCCESS = "selectSuccess";
    /**
     * 星期中英文对照关系
     */
    public static final Map<String, String> WEEK_CONTRAST = new HashMap<>(7);
    static {
        WEEK_CONTRAST.put("MONDAY", "星期一");
        WEEK_CONTRAST.put("TUESDAY", "星期二");
        WEEK_CONTRAST.put("WEDNESDAY", "星期三");
        WEEK_CONTRAST.put("THURSDAY", "星期四");
        WEEK_CONTRAST.put("FRIDAY", "星期五");
        WEEK_CONTRAST.put("SATURDAY", "星期六");
        WEEK_CONTRAST.put("SUNDAY", "星期日");
    }

}
