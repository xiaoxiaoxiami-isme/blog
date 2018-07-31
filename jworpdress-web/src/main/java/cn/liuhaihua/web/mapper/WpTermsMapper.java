package cn.liuhaihua.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.liuhaihua.web.vo.TermsVO;

public interface WpTermsMapper extends BaseMapper<TermsVO>{
	@Select(" select wtt.term_taxonomy_id as termTaxonomyId,wtt.term_id as termId,wtt.count,wtt.parent,wt.`name` "
			+ "from wp_term_taxonomy  wtt LEFT JOIN  wp_terms wt  on wtt.term_id=wt.term_id "
			+ "where wtt.taxonomy=#{taxonomy} ")
	public List<TermsVO> queryTermListByTaxonomy(@Param("taxonomy") String taxonomy);
}
 