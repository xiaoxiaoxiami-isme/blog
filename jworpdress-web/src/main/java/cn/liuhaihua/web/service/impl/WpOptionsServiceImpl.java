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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liuhaihua.web.annotation.RedisCache;
import cn.liuhaihua.web.mapper.WpCommentsMapper;
import cn.liuhaihua.web.mapper.WpOptionsMapper;
import cn.liuhaihua.web.mapper.WpPostsMapper;
import cn.liuhaihua.web.mapper.WpTermsMapper;
import cn.liuhaihua.web.model.WpOptions;
import cn.liuhaihua.web.service.WpOptionsService;
import cn.liuhaihua.web.util.DateUtil;
import cn.liuhaihua.web.util.TermsConstants;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName: WpOptionsServiceImpl
 * @Description: 配置信息加载类
 * @author Liuhaihua
 * @date 2018年7月13日
 *
 */
@Service
public class WpOptionsServiceImpl implements WpOptionsService {
	@Autowired
	private WpOptionsMapper wpOptionsMapper;
	@Autowired
	private WpPostsMapper  wpPostsMapper;
	@Autowired
	private WpTermsMapper  wpTermsMapper;
	@Autowired
	private WpCommentsMapper wpCommentsMapper;
	/** 
	 * @return
	 * @see cn.liuhaihua.web.service.WpOptionsService#autoloadConfig()
	 */
	@Override
	@RedisCache(expire=1l,unit=TimeUnit.DAYS)
	public List<WpOptions> autoloadConfig() {
		Example example = new Example(WpOptions.class);
		Criteria c = example.createCriteria();
		c.andEqualTo("autoload", "yes");
		List<WpOptions>  list = wpOptionsMapper.selectByExample(example);
		return list;
	}
	  /**
     * 获取网站详情
     *
     * @return
     */
    @Override
	@RedisCache(expire=1l,unit=TimeUnit.DAYS)
    public Map<String, Object> getSiteInfo() {
        Map<String, Object> map = new  HashMap<String, Object>();
        map.put("postCount", wpPostsMapper.selectCount(null));
        map.put("recordeTime", DateUtil.date2Str(new Date(), "yyyy年MM月dd日HH点"));
        Date buildSiteDate = DateUtil.str2Date("2012-10-27 00:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS_EN);
        // 获取建站天数
        map.put("buildSiteDate", DateUtil.getGapDay(buildSiteDate, new Date()));
        int  tagCount =wpTermsMapper.queryTermListByTaxonomy(TermsConstants.post_tag).size();
        int  categoryCount =wpTermsMapper.queryTermListByTaxonomy(TermsConstants.category).size();
        map.put("tagCount", tagCount);
        map.put("categoryCount", categoryCount);
        map.put("commmentCount",  wpCommentsMapper.selectCount(null));
        return map;
    }

}
