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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.liuhaihua.web.mapper.WpCommentsMapper;
import cn.liuhaihua.web.model.WpComments;
import cn.liuhaihua.web.model.WpUsers;
import cn.liuhaihua.web.service.WpCommentsService;
import tk.mybatis.mapper.entity.Example;

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

}
