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
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @ClassName: WpUsers
 * @Description: 用户实体表
 * @author Liuhaihua
 * @date 2018年6月27日
 *
 */
@Data
@Table(name = "wp_users")
public class WpUsers implements Serializable{
	/**
	 * @Fields field:
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 登录名
	 */
	private String  userLogin;
	/**
	 * 登陆密码
	 */
	private String  userPass;
	/**
	 * 用户昵称
	 */
	private String  userNicename;
	/**
	 * 用户邮箱
	 */
	private String  userEmail;
	/**
	 * 个人网址
	 */
	private String  userUrl;
	/**
	 * 注册时间
	 */
	private Date userRegistered;
	/**
	 * 激活码
	 */
	private String  userActivationKey;
	/**
	 * 用户状态
	 */
	private int  userStatus;
	/**
	 * 用户显示名称
	 */
	private String  displayName;
}
