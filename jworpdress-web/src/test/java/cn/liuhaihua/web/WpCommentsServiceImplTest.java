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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taobao.stresstester.StressTestUtils;
import com.taobao.stresstester.core.StressResult;
import com.taobao.stresstester.core.StressTask;

import cn.liuhaihua.web.model.WpComments;
import cn.liuhaihua.web.model.WpUsers;
import cn.liuhaihua.web.service.WpCommentsService;
import cn.liuhaihua.web.util.FastJsonUtil;

/**
 * @ClassName: WpCommentsServiceImplTest
 * @Description: 用户评论测试类
 * @author Liuhaihua
 * @date 2018年6月29日
 *
 */
public class WpCommentsServiceImplTest extends BaseTest{
	@Autowired
	private WpCommentsService wpCommentsService;
	/**
	 * @Title: getRecentComments
	 * @Description: 测试获取最近10条评论信息
	 * @param     参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
    public void getRecentComments() {
		List<WpComments>  list =wpCommentsService.getRecentComments(10);
		System.out.println("comments:"+FastJsonUtil.json2String(list));
    }
	
}
