package com.shop.common.page;

import com.shop.common.SQLFilter;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * layui分页查询工具类
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private Integer page;//layui分页参数page页码
    private Integer limit;//layui分页参数limit条数
    public Query(Map<String, Object> params) {
        this.putAll(params);//设置各类查询条件
        if(params.containsKey("page") && params.containsKey("limit")){
            this.page = Integer.parseInt(params.get("page").toString());
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        if(params.containsKey("order")) {
            String order = (String) params.get("order");
            if (StringUtils.isNotBlank(order)) {
                this.put("order", SQLFilter.sqlInject(order));//排序字段，默认倒序
            }
        }
        if(params.containsKey("field")) {
            String order = (String) params.get("field");
            if (StringUtils.isNotBlank(order)) {
                this.put("field", SQLFilter.sqlInject(order));//排序字段，默认倒序
            }
        }
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        this.limit = (this.page - 1) * this.limit;
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
