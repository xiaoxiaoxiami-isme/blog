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
package cn.liuhaihua.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.exception.ServiceException;
import cn.liuhaihua.web.mapper.WpPostsMapper;
import cn.liuhaihua.web.model.WpPosts;
import cn.liuhaihua.web.service.WpPostsService;
import cn.liuhaihua.web.util.PostConstant;
import cn.liuhaihua.web.vo.PostParam;

/**
 * @ClassName: WpPostsServiceImpl
 * @Description: 查询文章的服务实现类
 * @author Liuhaihua
 * @date 2018年8月10日
 *
 */
@Service
public class WpPostsServiceImpl implements WpPostsService {
	@Autowired
	private WpPostsMapper wpPostsMapper;
	/** 
	 * @param postParam
	 * @return
	 * @throws ServiceException
	 * @see cn.liuhaihua.web.service.WpPostsService#getPostListByPage(cn.liuhaihua.web.vo.PostParam)
	 */
	@Override
	public PageInfo<WpPosts> getPostListByPage(PostParam postParam) throws ServiceException {
		int pageNum = postParam.getPageNum();// 起始页
		int pageSize = postParam.getPageSize();// 每页显示条数
		if (pageNum <= 0){
			pageNum = 1;
		}
		if (pageSize <= 0) {
			pageSize = 10;
		}
		PageHelper.startPage(pageNum,pageSize);
		WpPosts   wpPosts =  new WpPosts();
		wpPosts.setPostType(PostConstant.POSTTYPE_POST);
		wpPosts.setPostStatus(PostConstant.POSTSTATUS_PUBLISH);
		PageInfo<WpPosts>   page =(PageInfo<WpPosts>) wpPostsMapper.select(wpPosts);
		return page;
	}

}
