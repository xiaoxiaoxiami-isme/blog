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
package cn.liuhaihua.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liuhaihua.web.exception.ServiceException;
import cn.liuhaihua.web.mapper.WpUsersMapper;
import cn.liuhaihua.web.model.WpUsers;
import cn.liuhaihua.web.service.WpUsersService;

/**
 * @ClassName: WpUsersServiceImpl
 * @Description: 用户服务类
 * @author Liuhaihua
 * @date 2018年6月29日
 *
 */
@Service
public class WpUsersServiceImpl implements WpUsersService{
	@Autowired
	private WpUsersMapper wpUsersMapper;
	/** 
	 * @param id
	 * @return
	 * @see cn.liuhaihua.web.service.WpUsersService#getUserDetail(java.lang.Long)
	 */
	@Override
	public WpUsers getUserDetail(Long id)  throws ServiceException{
		try{
			WpUsers record = new WpUsers();
			record.setId(id);
			WpUsers wpUsers = wpUsersMapper.selectOne(record);
			return wpUsers;
		}catch(Exception e){
			throw new ServiceException("查询用户信息失败");
		}
	}

}
