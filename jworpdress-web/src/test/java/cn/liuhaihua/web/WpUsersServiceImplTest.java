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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taobao.stresstester.StressTestUtils;
import com.taobao.stresstester.core.StressResult;
import com.taobao.stresstester.core.StressTask;

import cn.liuhaihua.web.model.WpUsers;
import cn.liuhaihua.web.service.WpUsersService;

/**
 * @ClassName: WpUsersTest
 * @Description: 用户测试类
 * @author Liuhaihua
 * @date 2018年6月29日
 *
 */
public class WpUsersServiceImplTest extends BaseTest{
	@Autowired
	private WpUsersService wpUsersService;
	/**
	 * @Title: getUserDetail
	 * @Description: 测试获取用户信息方法
	 * @param     参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
    public void getUserDetail() {
		WpUsers user =wpUsersService.getUserDetail(1l);
		Assert.assertEquals("Harries", user.getDisplayName());
    }
	/**
	 * @Title: PressTest
	 * @Description: 压力测试，测试一下获取用户信息的方法的qps
	 * @param     参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public  void PressTest(){
		 int concurrencyLevel =100;//并发数
		 int totalRequest = 1000;//总请求数
		 StressResult result = StressTestUtils.test(concurrencyLevel, totalRequest, new StressTask() {
			@Override
			public Object doTask() throws Exception {
				getUserDetail();
				return "";
			}
		 });
		 System.out.println(StressTestUtils.format(result));
	}
}
