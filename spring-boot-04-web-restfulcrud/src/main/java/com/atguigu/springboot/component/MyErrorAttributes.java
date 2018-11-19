package com.atguigu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给容器中加入自定义的 ErrorAttributes
 * @author wangsen
 * @createtime 2018-10-26 15:15
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    // 返回的 map 就是页面和 Json 能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest,
                                                  boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "=========");
        // 异常处理器能够携带的数据
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);

        map.put("ext", ext);
        return map;
    }
}
