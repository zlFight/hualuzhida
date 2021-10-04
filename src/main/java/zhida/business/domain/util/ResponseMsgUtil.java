package zhida.business.domain.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @文件名 ResponseMsgUtil
 * @描述 ResponseMsgUtil类
 * @Author xuzhiming
 * @创建时间 2020-08-03 11:49
 */
public class ResponseMsgUtil extends ConstantUtils {

    public static Map<String, Object> success() {
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put(HTTP_KEY_CODE, CRUD_VALUE_SUCCESS);
        resultMap.put(HTTP_KEY_MSG, MSG_KEY_FIND_SUCCESS);
        return resultMap;
    }

    public static Map<String, Object> success(Integer msg) {
        Map<String, Object> resultMap = success();
        resultMap.put(SELECT_DATA_KEY, msg);
        return resultMap;
    }

    public static Map<String, Object> success(String msg) {
        Map<String, Object> resultMap = success();
        resultMap.put(SELECT_DATA_KEY, msg);
        return resultMap;
    }

    public static Map<String, Object> success(PageInfo pageInfo) {
        Map<String, Object> resultMap = success();
        resultMap.put(DATA_LENGTH_KEY, pageInfo.getTotal());
        resultMap.put(SELECT_DATA_KEY, pageInfo.getList());
        return resultMap;
    }

    public static Map<String, Object> success(List<Map<String, Object>> data) {
        Map<String, Object> resultMap = success();
        resultMap.put(SELECT_DATA_KEY, data);
        return resultMap;
    }

    public static Map<String, Object> success(Map<String, Object> data) {
        Map<String, Object> resultMap = success();
        resultMap.put(SELECT_DATA_KEY, data);
        return resultMap;
    }

    public static Map<String, Object> error(String msg) {
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put(HTTP_KEY_CODE, CRUD_VALUE_ERROR);
        resultMap.put(HTTP_KEY_MSG, msg);
        return resultMap;
    }

    public static Map<String, Object> error(Object data, String msg) {
        Map<String, Object> resultMap = error(msg);
        resultMap.put(SELECT_DATA_KEY, data);
        return resultMap;
    }
}
