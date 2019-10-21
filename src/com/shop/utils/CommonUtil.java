package com.shop.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：CommonUtil
 * @Description：
 * @Author：wuxingxing
 * @Date：2019/10/17 22:40
 */
public class CommonUtil {
    /**
     * 把request转为map
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map<?, ?> properties = request.getParameterMap();
        // 返回值Map
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<?> entries = properties.entrySet().iterator();

        Map.Entry<String, Object> entry;
        String name = "";
        String value = "";
        Object valueObj =null;
        while (entries.hasNext()) {
            entry = (Map.Entry<String, Object>) entries.next();
            name = (String) entry.getKey();
            valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }
}