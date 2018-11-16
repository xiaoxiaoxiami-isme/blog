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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.model.WpLinks;
import cn.liuhaihua.web.service.WpLinksService;
import cn.liuhaihua.web.service.WpPostsService;
import cn.liuhaihua.web.util.TemplateConstant;
import cn.liuhaihua.web.util.TermsConstants;
import cn.liuhaihua.web.vo.PostParam;
import cn.liuhaihua.web.vo.PostVO;
/**
 * @ClassName: IndexController
 * @Description: 首页
 * @author Liuhaihua
 * @date 2018年7月10日
 *
 */
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private WpPostsService wpPostsService;
	@Autowired
	private WpLinksService wpLinksService;
	/**
     * 首页
     * @param vo
     * @param model
     * @return
     */
	@RequestMapping("/")
    public ModelAndView home(Model model) {
    	super.loadConfig(model);
        PostParam postParam  =  new PostParam();  
        PageInfo<PostVO>  page = wpPostsService.getPostListByPage(postParam);
        model.addAttribute("page", page);
        model.addAttribute("url", "index");
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }
	/**
	 * @Title: about
	 * @Description: 关于作者
	 * @param model
	 * @return    参数
	 */
	@RequestMapping("/about")
    public ModelAndView about(Model model) {
    	super.loadConfig(model);
        return  new ModelAndView(TemplateConstant.ABOUT);
    }
	/**
	 * @Title: links
	 * @Description: 链接
	 * @param model
	 * @return    参数
	 */
	@RequestMapping("/links")
    public ModelAndView links(Model model) {
    	super.loadConfig(model);
    	List<WpLinks>   linkList = wpLinksService.getLinks();
    	model.addAttribute("linkList", linkList);
        return  new ModelAndView(TemplateConstant.LINKS);
    }
    /**
     * 文章详情
     *
     * @param model
     * @param articleId
     * @return
     */
    @GetMapping("/archives/{postId}")
    public ModelAndView article(Model model, @PathVariable("postId") Long postId) {
    	super.loadConfig(model);
    	PostVO postVO = wpPostsService.getPostByID(postId);
        if (postVO == null ) {
            return new ModelAndView(TemplateConstant.ERROR_404);
        }
        model.addAttribute("article", postVO);
        // 上一篇
        model.addAttribute("prev", wpPostsService.getPrevPost(postId));
        //下一篇
        model.addAttribute("next", wpPostsService.getNextPost(postId));
        // 相关文章
        model.addAttribute("relatedList", wpPostsService.getRelatePost(postId));
        model.addAttribute("articleDetail", true);
        return  new ModelAndView(TemplateConstant.POST_URL);
    }
    /**
     * 首页（分页）
     *
     * @param pageNumber
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("/index/{pageNum}")
    public ModelAndView page(@PathVariable("pageNum") Integer pageNum,Model model) {
    	super.loadConfig(model);
        PostParam postParam  =  new PostParam();  
        postParam.setPageNum(pageNum);
        PageInfo<PostVO>  page = wpPostsService.getPostListByPage(postParam);
        model.addAttribute("page", page);
        model.addAttribute("url", "index");
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }
    /**
     * 分类列表
     *
     * @param typeId
     * @param model
     * @return
     */
    @GetMapping("/type/{typeId}")
    public ModelAndView type(@PathVariable("typeId") Long typeId, Model model) {
    	super.loadConfig(model);
        PostParam postParam  =  new PostParam();  
        postParam.setTermId(typeId);
        postParam.setTaxonomy(TermsConstants.category);
        PageInfo<PostVO>  page = wpPostsService.getTermsListByPage(postParam);
        model.addAttribute("page", page);
        model.addAttribute("url", "type/" + typeId);
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }
    /**
     * 分类列表（分页）
     *
     * @param typeId
     * @param pageNumber
     * @param model
     * @return
     */
    @GetMapping("/type/{typeId}/{pageNumber}")
    public ModelAndView type(@PathVariable("typeId") Long typeId, @PathVariable("pageNumber") Integer pageNumber, Model model) {
    	super.loadConfig(model);
        PostParam postParam  =  new PostParam();  
        postParam.setTermId(typeId);
        postParam.setTaxonomy(TermsConstants.category);
        postParam.setPageNum(pageNumber);
        PageInfo<PostVO>  page = wpPostsService.getTermsListByPage(postParam);
        model.addAttribute("page", page);
        model.addAttribute("url", "type/" + typeId);
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }
    /**
     * 分类列表
     *
     * @param typeId
     * @param model
     * @return
     */
    @GetMapping("/tag/{tagId}")
    public ModelAndView tag(@PathVariable("tagId") Long tagId, Model model) {
    	super.loadConfig(model);
        PostParam postParam  =  new PostParam();  
        postParam.setTermId(tagId);
        postParam.setTaxonomy(TermsConstants.post_tag);
        PageInfo<PostVO>  page = wpPostsService.getTermsListByPage(postParam);
        model.addAttribute("page", page);
        model.addAttribute("url", "tag/" + tagId);
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }
    /**
     * 标签列表（分页）
     *
     * @param tagId
     * @param pageNumber
     * @param model
     * @return
     */
    @GetMapping("/tag/{tagId}/{pageNumber}")
    public ModelAndView tag(@PathVariable("tagId") Long tagId, @PathVariable("pageNumber") Integer pageNumber, Model model) {
    	super.loadConfig(model);
        PostParam postParam  =  new PostParam();  
        postParam.setTermId(tagId);
        postParam.setTaxonomy(TermsConstants.post_tag);
        postParam.setPageNum(pageNumber);
        PageInfo<PostVO>  page = wpPostsService.getTermsListByPage(postParam);
        model.addAttribute("page", page);
        model.addAttribute("url", "tag/" + tagId);
        return  new ModelAndView(TemplateConstant.INDEX_URL);
    }

}
