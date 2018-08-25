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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.exception.ServiceException;
import cn.liuhaihua.web.mapper.WpPostsMapper;
import cn.liuhaihua.web.mapper.WpTermsMapper;
import cn.liuhaihua.web.model.WpPosts;
import cn.liuhaihua.web.service.WpPostsService;
import cn.liuhaihua.web.util.PostConstant;
import cn.liuhaihua.web.vo.PostParam;
import cn.liuhaihua.web.vo.PostVO;
import cn.liuhaihua.web.vo.TermsVO;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

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
	@Autowired
	private WpTermsMapper wpTermsMapper;
	/** 
	 * @param postParam
	 * @return
	 * @throws ServiceException
	 * @see cn.liuhaihua.web.service.WpPostsService#getPostListByPage(cn.liuhaihua.web.vo.PostParam)
	 */
	@Override
	public PageInfo<PostVO> getPostListByPage(PostParam postParam) throws ServiceException {
		int pageNum = postParam.getPageNum();// 起始页
		int pageSize = postParam.getPageSize();// 每页显示条数
		if (pageNum <= 0){
			pageNum = 1;
		}
		if (pageSize <= 0) {
			pageSize = 10;
		}
		
		PageHelper.startPage(pageNum,pageSize);
//		WpPosts   wpPosts =  new WpPosts();
//		wpPosts.setPostType(PostConstant.POSTTYPE_POST);
//		wpPosts.setPostStatus(PostConstant.POSTSTATUS_PUBLISH);
//		Page<WpPosts>   page =(Page<WpPosts>) wpPostsMapper.select(wpPosts);
		Example   example =  new Example(WpPosts.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("postType", PostConstant.POSTTYPE_POST);
		criteria.andEqualTo("postStatus",PostConstant.POSTSTATUS_PUBLISH);
		if(!StringUtils.isEmpty(postParam.getSortType())){
			if(postParam.getSortType().equals(PostConstant.SORTTYPE_COMMMENT)){
				example.setOrderByClause(" comment_count  desc  ");
			}else if(postParam.getSortType().equals(PostConstant.SORTTYPE_DATE)){
				example.setOrderByClause(" post_date  desc  ");
			}else if(postParam.getSortType().equals(PostConstant.SORTTYPE_RANDOM)){
				example.setOrderByClause("  RAND()  ");
			}else if(postParam.getSortType().equals(PostConstant.SORTTYPE_VIEW)){
				example.setOrderByClause(" post_date  desc  ");
			}
		}
		Page<WpPosts>   page =(Page<WpPosts>) wpPostsMapper.selectByExample(example);
		return processPostsList(page.toPageInfo());
	}
	/**
	 * @Title: processPostsList
	 * @Description: 处理page list增加文章的标签 分类 以及概要
	 * @param @param page    参数
	 * @return void    返回类型
	 * @throws
	 */
	public  PageInfo<PostVO>  processPostsList(PageInfo<WpPosts>  page){
		List<PostVO>  listpostnew = new ArrayList<PostVO>(); 
		for(WpPosts wpPosts:page.getList()){
			PostVO postvo =  new PostVO();
			List<TermsVO>  termsList =	wpTermsMapper.queryTermListByObjectId(wpPosts.getId());
			BeanUtils.copyProperties(wpPosts, postvo);
			postvo.setTermsList(termsList);
			listpostnew.add(postvo);
		}
		PageInfo<PostVO>  pagenew = new  PageInfo<PostVO>();
		BeanUtils.copyProperties(page, pagenew);
		pagenew.setList(listpostnew);
		return pagenew;
		
	}

}
