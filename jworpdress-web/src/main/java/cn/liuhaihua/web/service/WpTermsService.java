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

import cn.liuhaihua.web.vo.TermsVO;

/**
 * @ClassName: WpTerms
 * @Description: 分类，标签服务类
 * @author Liuhaihua
 * @date 2018年7月27日
 *
 */
public interface WpTermsService {
	/**
	 * @Title: getTerms
	 * @Description: 获取terms列表
	 * @param @param taxonomy--是标签还是分类
	 * @param @return    参数
	 * @return List<TermsVO>    返回类型
	 * @throws
	 */
	public List<TermsVO>   getTerms(String taxonomy);
	
	/**
	 * 
	 * @Title: getNavigate
	 * @Description: 首页分类导航栏
	 * @param @return    参数
	 * @return List<TermsVO>    返回类型
	 * @throws
	 */
	public List<TermsVO>   getNavigate();
}
