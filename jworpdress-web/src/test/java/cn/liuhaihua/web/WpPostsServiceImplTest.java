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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.service.WpPostsService;
import cn.liuhaihua.web.util.FastJsonUtil;
import cn.liuhaihua.web.vo.PostParam;
import cn.liuhaihua.web.vo.PostVO;

/**
 * @ClassName: WpPostsServiceImplTest
 * @Description: 用户测试类
 * @author Liuhaihua
 * @date 2018年6月29日
 *
 */
public class WpPostsServiceImplTest extends BaseTest{
	@Autowired
	private WpPostsService wpPostsService;
	/**
	 * @Title: getUserDetail
	 * @Description: 测试获取用户信息方法
	 * @param     参数
	 * @return void    返回类型
	 * @throws
	 */
	@Test
    public void getPostListByPage() {
		PostParam postParam  =  new PostParam();
		PageInfo<PostVO> page =wpPostsService.getPostListByPage(postParam);
		System.out.println("分页大小:"+page.getTotal()+"|"+FastJsonUtil.json2String(page.getList()));
		
		postParam.setPageNum(2);
		PageInfo<PostVO> page1 =wpPostsService.getPostListByPage(postParam);
		System.out.println("分页大小:"+page.getTotal()+"|"+FastJsonUtil.json2String(page1.getList()));
	}
	
}
