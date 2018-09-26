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
package cn.liuhaihua.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.liuhaihua.web.vo.TermsVO;

public interface WpTermsMapper extends BaseMapper<TermsVO>{
	/**
	 * @Title: queryTermListByTaxonomy
	 * @Description: 查询分类集合
	 * @param @param taxonomy
	 * @param @return    参数
	 * @return List<TermsVO>    返回类型
	 * @throws
	 */
	@Select(" select wtt.term_taxonomy_id as termTaxonomyId,wtt.term_id as termId,wtt.count,wtt.parent,wt.`name` "
			+ "from wp_term_taxonomy  wtt LEFT JOIN  wp_terms wt  on wtt.term_id=wt.term_id "
			+ "where wtt.taxonomy=#{taxonomy}   ORDER BY wtt.count  desc ")
	public List<TermsVO> queryTermListByTaxonomy(@Param("taxonomy") String taxonomy);
	
	/**
	 * @Title: queryTermListByObjectId
	 * @Description: 根据文章id查询所属的标签和分类集合
	 * @param @param taxonomy
	 * @param @param objectId
	 * @param @return    参数
	 * @return List<TermsVO>    返回类型
	 * @throws
	 */
	@Select(" select wtt.term_taxonomy_id as termTaxonomyId,wtt.term_id as termId,wtt.count,wtt.parent,wt.`name` ,wtt.taxonomy "
			+ " from wp_term_taxonomy  wtt LEFT JOIN  wp_terms wt  on wtt.term_id=wt.term_id "
			+ " LEFT JOIN  wp_term_relationships  wtr  on wtt.term_taxonomy_id =wtr.term_taxonomy_id "
			+ "where  wtr.object_id=#{objectId} ")
	public List<TermsVO> queryTermListByObjectId(@Param("objectId") Long objectId);
	
	/**
	 * @Title: getRelatePostByTerms
	 * @Description:根据标签和分类查询相关的文章
	 * @param terms
	 * @return    参数
	 */
	@Select(" SELECT DISTINCT wtr.object_id  FROM	wp_term_taxonomy wtt "
			+ " LEFT JOIN wp_terms wt ON wtt.term_id = wt.term_id "
			+ " LEFT JOIN wp_term_relationships wtr ON wtt.term_taxonomy_id = wtr.term_taxonomy_id "
			+ " WHERE	wtr.term_taxonomy_id in (#{termsIds}) ORDER BY RAND() LIMIT #{count}")
	public List<Long> queryRelatePostByTerms(@Param("termsIds") String termsIds,@Param("count") int count);
	
	
}
 