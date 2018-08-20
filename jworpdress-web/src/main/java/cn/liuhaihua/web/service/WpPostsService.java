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

import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.exception.ServiceException;
import cn.liuhaihua.web.model.WpPosts;
import cn.liuhaihua.web.vo.PostParam;

/**
 * @ClassName: WpUsersService
 * @Description:文章服务类
 * @author Liuhaihua
 * @date 2018年6月29日
 *
 */
public interface WpPostsService {
	/**
	 * @Title: getPostListByPage
	 * @Description: 分页查询文章
	 * @param @param postParam
	 * @param @return
	 * @param @throws ServiceException    参数
	 * @return Page<WpPosts>    返回类型
	 * @throws
	 */
	public PageInfo<WpPosts> getPostListByPage(PostParam postParam) throws ServiceException;
}
