package cn.liuhaihua.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonUtil {
    /**
     * 将传入的实体类对象转换为JSON格式字符串对象。对需要转换的属性字段要提供get方法，否则该字段不被转换。如果转换过程出错，则返回""。
     *
     * @return
     */
    public static String json2String(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 将传入的JSON字符串对象转换为org.codehaus.jackson.JsonNode对象。如果传入字符串格式不正确则返回null。
     *
     * @param string
     *
     * @return
     */
    public static <T> T  string2Json(String string,Class<T> clazz) {
        return JSON.parseObject(string, clazz);
    }
    
    /**
     * 打印json串，移除指定字段
     * @param obj
     * @param strings
     * @return
     */
    public static String json2String(Object obj,String ...strings) {
    	JSONObject jsonObject=JSON.parseObject(json2String(obj));  
    	if(strings != null) {
    		for(String string : strings) {
    			jsonObject.remove(string);
    		}
    	}
    	
    	return jsonObject.toJSONString();
    }
    
    /**
     * 打印json串，移除指定字段
     * @param obj
     * @param strings
     * @return
     */
    public static String json2String(String obj,String ...strings) {
    	JSONObject jsonObject=JSON.parseObject(obj);  
    	if(strings != null) {
    		for(String string : strings) {
    			jsonObject.remove(string);
    		}
    	}
    	
    	return jsonObject.toJSONString();
    }
}
