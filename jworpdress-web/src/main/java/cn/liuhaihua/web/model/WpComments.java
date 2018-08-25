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

import lombok.Data;

/**
 * @ClassName: WpComments
 * @Description: 评论实体类
 * @author Liuhaihua
 * @date 2018年8月25日
 *
 */
@Data
public class WpComments {
	/**
	 * 评论ID
	 */
	private Long commentId;
	/**
	 * 文中ID
	 */
	private Long commentPostId;
	/**
	 * 评论作者
	 */
	private String commentAuthor;
	/**
	 * 评论人联系邮箱
	 */
	private String commentAuthorEmail;
	/**
	 * 评论人网址
	 */
	private String commentAuthorUrl;
	/**
	 * 评论人IP
	 */
	private String commentAuthorIp;
	/**
	 * 评论日期
	 */
	private Date  commentDate;
	/**
	 * 评论GMT日期
	 */
	private Date  commentDateGmt;
	/**
	 * 评论内容
	 */
	private String commentContent;
	/**
	 * 评论的karma值
	 */
	private Integer  commentKarma;
	/**
	 * 评论许可（0，1，或'spam'）
	 */
	private String   commentApproved;
	/**
	 * 评论代理（浏览器，操作系统等）
	 */
	private String  commentAgent;
	/**
	 * 有意义的评论类型（pingback|trackback），常规评论类型时为空
	 */
	private String  commentType;
	/**
	 * 父评论的编号
	 */
	private Long   commentParent;
	/**
	 * 评论者登录后的用户编号（未登录则为0）
	 */
	private Long   userId;
}
