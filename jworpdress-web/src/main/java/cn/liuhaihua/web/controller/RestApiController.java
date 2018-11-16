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
package cn.liuhaihua.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.exception.ServiceException;
import cn.liuhaihua.web.model.WpComments;
import cn.liuhaihua.web.service.WpCommentsService;
import cn.liuhaihua.web.util.RedisConstant;
import cn.liuhaihua.web.util.RequestUtil;
import cn.liuhaihua.web.util.ResponseStatus;
import cn.liuhaihua.web.vo.CommentVO;
import cn.liuhaihua.web.vo.ResponseVO;
/**
 * @ClassName: RestApiController
 * @Description: 提供restapi接口数据
 * @author Liuhaihua
 * @date 2018年7月10日
 *
 */
@RestController
@RequestMapping("/api")
public class RestApiController extends BaseController{
	@Autowired
	private WpCommentsService wpCommentsService;
    /**
     * @Title: listNotice
     * @Description:系统通知
     * @return    参数
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("/listNotice")
    public String listNotice() {
    	Map<String,String> map =(Map<String, String>) redisTemplate.opsForValue().get(RedisConstant.autoloadConfig);
        return map.get("sys_notice");
    }
    @RequestMapping("/comments")
    public ResponseVO<PageInfo<WpComments>> comments(CommentVO commentVO) {
    	try{
    		PageInfo<WpComments>  pageinfo = wpCommentsService.getCommentsByPostId(commentVO);
    		return  new ResponseVO<PageInfo<WpComments>>(ResponseStatus.SUCCESS,pageinfo);
    	}catch (Exception e) {
    		e.printStackTrace();
			return  new ResponseVO<PageInfo<WpComments>>(ResponseStatus.ERROR,null);
		}
    
    }
    /**
     * @Title: comment
     * @Description: 评论方法
     * @param wpComments
     * @return    参数
     */
    @PostMapping("/comment")
    public ResponseVO<String> comment(WpComments wpComments,HttpServletRequest request) {
        try {
        	wpComments.setCommentAgent(RequestUtil.getUserAgent(request));
        	wpComments.setCommentAuthorIp(RequestUtil.getClientIP(request));
        	wpCommentsService.insertComment(wpComments);
        	return new ResponseVO<String>(ResponseStatus.SUCCESS,"评论发表成功，系统正在审核，请稍后刷新页面查看！");
        } catch (ServiceException e) {
            e.printStackTrace();
            return new ResponseVO<String>(ResponseStatus.ERROR,e.getMessage());
        }
    }

}
