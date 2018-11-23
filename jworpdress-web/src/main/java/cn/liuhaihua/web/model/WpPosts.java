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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @ClassName: WpPosts
 * @Description: 文章实体类
 * @author Liuhaihua
 * @date 2018年8月3日
 *
 */
@Data
@Table(name = "wp_posts")
public class WpPosts implements Serializable{
	/**
	 * @Fields field:
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	/**
	 * 作者信息
	 */
	private Long  postAuthor;
	/**
	 * 文章日期
	 */
	private Date  postDate;
	/**
	 * 文章GMT日期
	 */
	private Date  postDateGmt;
	/**
	 *  文章内容
	 */
	private String postContent;
	/**
	 * 文章标题
	 */
	private String postTitle;
	/**
	 * 文章摘要
	 */
	private String postExcerpt;
	/**
	 * 文章状态（publish/auto-draft/inherit等）
	 */
	private String postStatus;
	/**
	 * 评论状态（open/closed）
	 */
	private String commentStatus;
	/**
	 * PING状态（open/closed）
	 */
	private String pingStatus;
	/**
	 * 文章密码
	 */
	private String postPassword;
	/**
	 * 文章缩略名
	 */
	private String postName;
	/**
	 * 是否ping
	 */
	private String toPing;
	/**
	 *  已经PING过的链接
	 */
	private String pinged;
	/**
	 * 文章修改时间
	 */
	private Date  postModified;
	/**
	 * 文章修改的GMT时间
	 */
	private Date  postModifiedGmt;
	/**
	 * 是否过滤
	 */
	private String postContentFiltered;
	/**
	 * 父文章，主要用于PAGE
	 */
	private String postParent;
	/**
	 * 这是每篇文章的一个地址
	 */
	private String guid;
	/**
	 * 排序ID
	 */
	private int  menuOrder;
	/**
	 * 文章类型（post/page等）
	 */
	private String postType;
	/**
	 * MIME类型
	 */
	private String postMimeType;
	/**
	 * 评论总数
	 */
	private Long commentCount;
}
