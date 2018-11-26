/**
 * MIT License
 * Copyright (c) 2018 haihua.liu
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cn.liuhaihua.web.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.liuhaihua.web.util.ResponseStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: ResponseVO
 * @Description:返回通用类
 * @author Liuhaihua
 * @date 2018年10月11日
 *
 * @param <T>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseVO<T> implements Serializable{
    /**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
    private String message;
    private T data;

    public ResponseVO(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseVO(ResponseStatus status, T data) {
        this(status.getCode(), status.getMessage(), data);
    }

    public String toJson() {
        T t = this.getData();
        if (t instanceof List || t instanceof Collection) {
            return JSONObject.toJSONString(this, SerializerFeature.WriteNullListAsEmpty);
        } else {
            return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
        }
    }
}
