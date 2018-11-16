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

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.exception.ServiceException;
import cn.liuhaihua.web.mapper.WpCommentsMapper;
import cn.liuhaihua.web.model.WpComments;
import cn.liuhaihua.web.service.WpCommentsService;
import cn.liuhaihua.web.util.DateUtil;
import cn.liuhaihua.web.vo.CommentVO;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: WpCommentsService
 * @Description: 评论服务的实现类
 * @author Liuhaihua
 * @date 2018年8月25日
 *
 */
@Service
public class WpCommentsServiceImpl implements WpCommentsService {
	@Autowired
	private WpCommentsMapper wpCommentsMapper;
	/** 
	 * @return
	 * @see cn.liuhaihua.web.service.WpCommentsService#getRecentComments()
	 */
	@Override
	public List<WpComments> getRecentComments(int pageSize) {
		PageHelper.startPage(0, pageSize);
		Example  example =  new Example(WpComments.class);
		example.setOrderByClause(" comment_date  DESC ");
		Page<WpComments>  page =(Page<WpComments>) wpCommentsMapper.selectByExample(example);
		return page.getResult();
	}
	/** 
	 * @param postId
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @see cn.liuhaihua.web.service.WpCommentsService#getCommentsByPostId(java.lang.Long, int, int)
	 */
	@Override
	public PageInfo<WpComments> getCommentsByPostId(CommentVO commentVO) {
		Long postId =commentVO.getSid();
        int pageSize=commentVO.getPageSize();
		int currentPage=commentVO.getPageNumber();
		PageHelper.startPage(currentPage, pageSize);
		Example  example =  new Example(WpComments.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("commentPostId", postId);
		example.setOrderByClause(" comment_date  DESC ");
		Page<WpComments>  page =(Page<WpComments>) wpCommentsMapper.selectByExample(example);
		return page.toPageInfo();
	}
	/** 
	 * @param wpComments
	 * @see cn.liuhaihua.web.service.WpCommentsService#insertComment(cn.liuhaihua.web.model.WpComments)
	 */
	@Override
	public void insertComment(WpComments wpComments) throws ServiceException{
			wpComments.setCommentDate(new Date());
			wpComments.setCommentDateGmt(DateUtil.getGMTDate());
			wpComments.setCommentApproved("1");
			wpComments.setCommentKarma(0);
			wpComments.setCommentType("");
			wpComments.setUserId(0l);
			wpCommentsMapper.insert(wpComments);
	}

}
