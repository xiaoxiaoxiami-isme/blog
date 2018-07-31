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

import cn.liuhaihua.web.mapper.WpOptionsMapper;
import cn.liuhaihua.web.model.WpOptions;
import cn.liuhaihua.web.service.WpOptionsService;
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
	/** 
	 * @return
	 * @see cn.liuhaihua.web.service.WpOptionsService#autoloadConfig()
	 */
	@Override
	public List<WpOptions> autoloadConfig() {
		Example example = new Example(WpOptions.class);
		Criteria c = example.createCriteria();
		c.andEqualTo("autoload", "yes");
		List<WpOptions>  list = wpOptionsMapper.selectByExample(example);
		return list;
	}

}