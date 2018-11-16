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
package cn.liuhaihua.web.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @ClassName: WpLinks
 * @Description: 链接实体类
 * @author Liuhaihua
 * @date 2018年11月16日
 *
 */
@Data
@Table(name = "wp_links")
public class WpLinks {
	/**
	 * 链接ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  linkId;
	/**
	 * 链接url
	 */
	private  String linkUrl;
	/**
	 * 链接name
	 */
	private  String linkName;
	/**
	 * 链接图片
	 */
	private  String linkImage;
	/**
	 * 链接打开方式
	 */
	private  String linkTarget;
	/**
	 * 链接rss
	 */
	private  String linkRss;
	/**
	 * 链接描述
	 */
	private  String linkDescription;
	/**
	 * 链接是否可见
	 */
	private  String linkVisible;
	/**
	 * 链接引用
	 */
	private  String linkRel;
	/**
	 * 链接备注
	 */
	private  String linkNotes;
	/**
	 * 链接所有者
	 */
	private  Long  linkOwner;
	/**
	 * 链接分级
	 */
	private  Long  linkRating;
	/**
	 * 链接更新时间
	 */
	private  Date linkUpdated;


}
