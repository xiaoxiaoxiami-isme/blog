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
package cn.liuhaihua.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: RequestUtil
 * @Description: 请求处理类
 * @author Liuhaihua
 * @date 2018年11月15日
 *
 */
public class RequestUtil {
	/**
	 * @Title: getClientIP
	 * @Description: 获取客户端浏览器IP
	 * @param request    参数
	 */
	public  static String getClientIP(HttpServletRequest request){
		String ip =request.getRemoteHost();
		return ip;
	}
	/**
	 * @Title: getUserAgent
	 * @Description:获取客户端代理
	 * @param request
	 * @return    参数
	 */
	public  static String getUserAgent(HttpServletRequest request){
        String userAgent=request.getHeader("User-Agent");
        return userAgent;
	}
}
