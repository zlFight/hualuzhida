package zhida.business.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zhida.business.domain.util.DateTimeUtils;
import zhida.business.domain.util.ResponseMsgUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController extends ResponseMsgUtil {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.apiPath}")
    private String getWaetherUrl;

    /**
     * 根据区域编码获取实时天气预报
     *
     * @param qybm
     * @return 实时天气查询结果
     */
    @GetMapping("/get/dalian/gjz")
    public Map<String, Object> getRealWeather(@RequestParam String qybm) {
        try {
            Map<String, String> paramMap = new HashMap<>(1);
            paramMap.put("qybm", qybm);
            Map<String, Object> resultMap = restTemplate.getForObject(getWaetherUrl, JSONObject.class,new HashMap());
            if (resultMap != null && !resultMap.isEmpty()) {
                    resultMap.put("date", DateTimeUtils.getNowDateStr());
                    resultMap.put("week", DateTimeUtils
                            .getWeekByDateStr(DateTimeUtils.getNowDateStr(), "yyyy-MM-dd"));
            }
            return success(resultMap);
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}
