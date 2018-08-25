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
package cn.liuhaihua.web;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.liuhaihua.web.service.WpTermsService;
import cn.liuhaihua.web.util.FastJsonUtil;
import cn.liuhaihua.web.vo.TermsVO;

/**
 * @ClassName: WpTemsServiceImplTest
 * @Description: 标签测试类
 * @author Liuhaihua
 * @date 2018年6月29日
 *
 */
public class WpTemsServiceImplTest extends BaseTest{
	@Autowired
	private WpTermsService wpTermsService;
	/**
	 * @Title: getNavigate
	 * @Description: 获取分类和标签方法
	 * @param     参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
    public void getNavigate() {
		List<TermsVO> list =wpTermsService.getNavigate();
		System.out.println(FastJsonUtil.json2String(list));
    }
	
}
