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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liuhaihua.web.mapper.WpTermsMapper;
import cn.liuhaihua.web.service.WpTermsService;
import cn.liuhaihua.web.util.BusinessConstants;
import cn.liuhaihua.web.vo.TermsVO;

/**
 * @ClassName: WpTermsServiceImpl
 * @Description: 标签和分类服务类
 * @author Liuhaihua
 * @date 2018年7月27日
 *
 */
@Service
public class WpTermsServiceImpl implements WpTermsService {
	@Autowired
	private WpTermsMapper  wpTermsMapper;
	/** 
	 * @param taxonomy
	 * @return
	 * @see cn.liuhaihua.web.service.WpTermsService#getTerms(java.lang.String)
	 */
	@Override
	public List<TermsVO> getTerms(String taxonomy) {
		List<TermsVO>  list = wpTermsMapper.queryTermListByTaxonomy(taxonomy);
		return list;
	}
	/**
	 * @Title: getChild
	 * @Description:递归查找子菜单
	 * @param @param id
	 * @param @param rootTermsVO
	 * @param @return    参数
	 * @return List<TermsVO>    返回类型
	 * @throws
	 */
	public  List<TermsVO> getChild(String id, List<TermsVO> allList){
		// 子菜单
	    List<TermsVO> childList = new ArrayList<>();
	    for (TermsVO TermsVO : allList) {
	        // 遍历所有节点，将父菜单id与传过来的id比较
	        if (StringUtils.isNotBlank(TermsVO.getParent())) {
	            if (TermsVO.getParent().equals(id)) {
	                childList.add(TermsVO);
	            }
	        }
	    }
	    // 把子菜单的子菜单再循环一遍
	    for (TermsVO TermsVO : childList) {
            // 递归
            TermsVO.setChild(getChild(TermsVO.getTermId(), allList));
	    } // 递归退出条件
	    if (childList.size() == 0) {
	        return null;
	    }
	    return childList;
	}
	/** 
	 * @return
	 * @see cn.liuhaihua.web.service.WpTermsService#getNavigate()
	 */
	@Override
	public List<TermsVO> getNavigate() {
		 List<TermsVO> list =this.getTerms(BusinessConstants.category);
		// 最后的结果
	    List<TermsVO> resultList = new ArrayList<TermsVO>();
    	 // 先找到所有的一级菜单
        for (int i = 0; i < list.size(); i++) {
            // 一级菜单parent =0
            if (list.get(i).getParent().equals("0")) {
            	resultList.add(list.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (TermsVO termsVO : resultList) {
        	termsVO.setChild(getChild(termsVO.getTermId(), list));
        }
        return resultList;
	}

}
