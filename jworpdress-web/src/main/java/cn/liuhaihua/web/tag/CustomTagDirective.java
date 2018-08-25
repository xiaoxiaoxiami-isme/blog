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
package cn.liuhaihua.web.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.liuhaihua.web.service.WpCommentsService;
import cn.liuhaihua.web.service.WpTermsService;
import cn.liuhaihua.web.util.TermsConstants;
import cn.liuhaihua.web.vo.TermsVO;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class CustomTagDirective implements TemplateDirectiveModel {
    private static final String METHOD_KEY = "method";
  
    @Autowired
    private WpTermsService wpTermsService;
    @Autowired
    private WpCommentsService wpCommentsService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
            String method = map.get(METHOD_KEY).toString();
            int pageSize = 10;
            if (map.containsKey("pageSize")) {
                String pageSizeStr = map.get("pageSize").toString();
                pageSize = Integer.parseInt(pageSizeStr);
            }
            switch (method) {
                case "navigate":
                	//首页导航目录
                    environment.setVariable("navigate", builder.build().wrap(wpTermsService.getNavigate()));
                    break;
                case "tagsList":
                    //截取前面30条标签
                	List<TermsVO>  tagsList =wpTermsService.getTerms(TermsConstants.post_tag);
                	if(tagsList.size()>30){
                		tagsList = tagsList.subList(0,30);
                	}
                    environment.setVariable("tagsList", builder.build().wrap(tagsList));
                    break;
                case "categoryList":
                	//截取前面30条分类
                	List<TermsVO>  categoryList =wpTermsService.getTerms(TermsConstants.category);
                	if(categoryList.size()>30){
                		categoryList = categoryList.subList(0,30);
                	}
                    environment.setVariable("categoryList", builder.build().wrap(categoryList));
                    break;
                case "parentResources":
                    // 所有父级资源
                    environment.setVariable("parentResources", builder.build().wrap(""));
                    break;
                case "recentComments":
                    // 近期评论
                    environment.setVariable("recentComments", builder.build().wrap(wpCommentsService.getRecentComments(pageSize)));
                    break;
                case "siteInfo":
                    // 站点属性
                    environment.setVariable("siteInfo", builder.build().wrap(""));
                    break;
                case "menus":
                    Integer userId = null;
                    if (map.containsKey("userId")) {
                        String userIdStr = map.get("userId").toString();
                        if(StringUtils.isEmpty(userIdStr)){
                            return;
                        }
                        userId = Integer.parseInt(userIdStr);
                    }
                    Map<String, Object> params = new HashMap<>(2);
                    params.put("type", "menu");
                    params.put("userId", userId);
                    environment.setVariable("menus", builder.build().wrap(""));
                    break;
                default:
                    break;
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}
