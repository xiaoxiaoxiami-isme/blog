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
package cn.liuhaihua.web.util;

/**
 * @ClassName: PostConstant
 * @Description: 文章的常量类
 * @author Liuhaihua
 * @date 2018年8月10日
 *
 */
public class PostConstant {
	  /**
	   * 页面
	   */
	  public  static  String    POSTTYPE_PAGE ="page";  
	  /**
	   * 文章
	   */
	  public  static  String    POSTTYPE_POST ="post";  
	  /**
	   * 已发布
	   */
	  public  static String POSTSTATUS_PUBLISH="publish";
	  /**
	   * 自动草稿
	   */
	  public  static String POSTSTATUS_AUTO_DRAFT="auto-draft";
	  /**
	   * 修订版本
	   */
	  public  static String POSTSTATUS_INHERIT="inherit";
	  /**
	   * 待审
	   */
	  public  static String POSTSTATUS_PENDING="pending";
	  /**
	   * 草稿
	   */
	  public  static String POSTSTATUS_DRAFT="draft";
	  /**
	   * 回收站
	   */
	  public  static String POSTSTATUS_TRASH="trash";
	  /**
	   * 定时
	   */
	  public  static String POSTSTATUS_FUTURE="future";
	  /**
	   * 私有
	   */
	  public  static String POSTSTATUS_PRIVATE="private";
	  
	  /**
	   * 按文章评论
	   */
	  public static String SORTTYPE_COMMMENT="comment";
	  /**
	   * 按访问量
	   */
	  public static String SORTTYPE_VIEW="view";
	  /**
	   * 按照日期排序
	   */
	  public static String SORTTYPE_DATE="date";
	  /**
	   * 随机文章
	   */
	  public static String SORTTYPE_RANDOM="random";

}
