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

import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.model.WpPosts;
import cn.liuhaihua.web.service.WpPostsService;
import cn.liuhaihua.web.util.FastJsonUtil;
import cn.liuhaihua.web.util.PostConstant;
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
		System.out.println("分页大小111:"+page.getTotal()+"|"+FastJsonUtil.json2String(page.getList()));
		
		postParam.setSortType(PostConstant.SORTTYPE_COMMMENT);
		PageInfo<PostVO> page1 =wpPostsService.getPostListByPage(postParam);
		System.out.println("分页大小:"+page.getTotal()+"|"+FastJsonUtil.json2String(page1.getList()));
	}
	/**
	 * @Title: getRelatePost
	 * @Description: 相关文章
	 */
	@Test
    public void getRelatePost() {
		List<WpPosts> list =wpPostsService.getRelatePost(9l);
		System.out.println("相关文章:"+FastJsonUtil.json2String(list));
	}
	/**
	 *
	 * @Title: getNextPost
	 * @Description: 下一篇文章
	 */
	@Test
    public void getNextPost() {
		WpPosts  obj =wpPostsService.getNextPost(146l);
		System.out.println("下一篇文章:"+FastJsonUtil.json2String(obj));
	}
	/**
	 * 
	 * @Title: getPrevPost
	 * @Description: 上一篇文章
	 */
	@Test
    public void getPrevPost() {
		WpPosts  obj =wpPostsService.getPrevPost(146l);
		System.out.println("上一篇文章:"+FastJsonUtil.json2String(obj));
	}
	/**
	 * 
	 * @Title: getPostByID
	 * @Description: 获取单篇文章内容
	 */
	@Test
    public void getPostByID() {
		WpPosts  obj =wpPostsService.getPostByID(146l);
		System.out.println("文章:"+FastJsonUtil.json2String(obj));
	}
}
