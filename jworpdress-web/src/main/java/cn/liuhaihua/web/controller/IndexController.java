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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.liuhaihua.web.util.RedisConstant;
import cn.liuhaihua.web.util.TemplateConstant;
import cn.liuhaihua.web.vo.SeoVO;
import cn.liuhaihua.web.vo.WebConfig;
/**
 * @ClassName: IndexController
 * @Description: 首页
 * @author Liuhaihua
 * @date 2018年7月10日
 *
 */
@Controller
public class IndexController {
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	/**
     * 首页
     * @param vo
     * @param model
     * @return
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("/")
    public ModelAndView home(Model model) {
    	WebConfig  config  =  new  WebConfig();
    	Map<String,String> map =(Map<String, String>) redisTemplate.opsForValue().get(RedisConstant.autoloadConfig);
    	config.setHomeDesc(map.get("homeDesc"));
    	config.setHomeKeywords(map.get("homeKeywords"));
    	config.setSiteName(map.get("blogname"));
    	config.setSiteUrl(map.get("siteurl"));
        model.addAttribute("config", config);
        SeoVO  seoVO  =   new  SeoVO();
        seoVO.setTitle("HARRIES BLOG™-追心中的海，逐世界的梦");
        seoVO.setKeywords("IT教程，互联网资讯，创业资讯，知识问答，生活感悟，编程技术，运维管理，分布式缓存，开发框架，数据库，集成工具，投资资讯，自动化，操作系统， 虚拟化，监控软件");
        seoVO.setDescription("HARRIES BLOG™是国内领先的IT技术博客，分布式缓存博客，编程技术博客,创业指导博客,IT投资资讯博客,IT运维博客,IT教程博客，互联网资讯博客，,云");
        model.addAttribute("seoVO", seoVO);
        
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }
}
