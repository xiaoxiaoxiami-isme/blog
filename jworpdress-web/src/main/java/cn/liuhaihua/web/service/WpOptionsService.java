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
package cn.liuhaihua.web.service;

import java.util.List;
import java.util.Map;

import cn.liuhaihua.web.model.WpOptions;

/**
 * @ClassName: SysConfigService
 * @Description: 网站前台配置服务类
 * @author Liuhaihua
 * @date 2018年7月11日
 *
 */
public interface WpOptionsService {
	  /**
     * 启动应用是获取系统配置
     *
     * @return
     */
	List<WpOptions> autoloadConfig();
	/**
	 * @Title: getSiteInfo
	 * @Description: 获取网站需求
	 * @param @return    参数
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String, Object> getSiteInfo();
}
