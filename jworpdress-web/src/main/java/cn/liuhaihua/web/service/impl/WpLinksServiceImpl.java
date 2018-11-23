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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liuhaihua.web.annotation.RedisCache;
import cn.liuhaihua.web.mapper.WpLinksMapper;
import cn.liuhaihua.web.model.WpLinks;
import cn.liuhaihua.web.service.WpLinksService;
import cn.liuhaihua.web.util.LinkConstant;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: WpLinksServiceImpl
 * @Description: 博客链接地址
 * @author Liuhaihua
 * @date 2018年11月16日
 *
 */
@Service
public class WpLinksServiceImpl implements WpLinksService {
	@Autowired
	private WpLinksMapper  wpLinksMapper;
	/** 
	 * @return
	 * @see cn.liuhaihua.web.service.WpLinksService#getLinks()
	 */
	@Override
	@RedisCache
	public List<WpLinks> getLinks(String linkrel) {
		if(StringUtils.isEmpty(linkrel) ){
			return wpLinksMapper.selectAll();
		}else{
			Example   example =  new Example(WpLinks.class);
			Criteria criteria = example.createCriteria();
			criteria.andEqualTo("linkRel", LinkConstant.LINK_REL_FRIEND);
			return wpLinksMapper.selectByExample(example);
		}
	}

}
