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
package cn.liuhaihua.web.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @ClassName: PostParam
 * @Description: 文章查询请求的参数类
 * @author Liuhaihua
 * @date 2018年8月10日
 *
 */
@Data
public class PostParam implements Serializable{

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	//当前页
	private int pageNum;

	//每页显示数量
	private int  pageSize;
	//文章ID
	private List<Long> postIds;
	//标签或者类型id
	private Long termId;
	/**
	 * 标签还是分类
	 */
	private String taxonomy;
	/**
	 * 文章排序类型
	 */
	private String sortType;
	/**
	 * 模糊搜索关键字
	 */
	private String keywords;
}
