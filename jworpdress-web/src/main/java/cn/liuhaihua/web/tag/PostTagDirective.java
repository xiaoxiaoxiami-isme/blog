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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;

import cn.liuhaihua.web.service.WpPostsService;
import cn.liuhaihua.web.util.PostConstant;
import cn.liuhaihua.web.vo.PostParam;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @ClassName: PostTagDirective
 * @Description: 文章标签
 * @author Liuhaihua
 * @date 2018年8月25日
 *
 */
@Component
public class PostTagDirective implements TemplateDirectiveModel {
    private static final String METHOD_KEY = "method";

    @Autowired
    private WpPostsService wpPostsService;

    @SuppressWarnings("rawtypes")
	@Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
        	PostParam postParam  =  new PostParam();
            String method = map.get(METHOD_KEY).toString();
            int pageSize = 10;
            if (map.containsKey("pageSize")) {
                String pageSizeStr = map.get("pageSize").toString();
                pageSize = Integer.parseInt(pageSizeStr);
                postParam.setPageSize(pageSize);
            }
            switch (method) {
                case "recentList":
                    // 近期文章
                	postParam.setSortType(PostConstant.SORTTYPE_DATE);
                    environment.setVariable("recentList", builder.build().wrap(wpPostsService.getPostListByPage(postParam).getList()));
                    break;
                case "recommendedList":
                    // 评论数量
                	postParam.setSortType(PostConstant.SORTTYPE_COMMMENT);
                    environment.setVariable("recommendedList", builder.build().wrap(wpPostsService.getPostListByPage(postParam).getList()));
                    break;
                case "randomList":
                    // 随机文章
                	postParam.setSortType(PostConstant.SORTTYPE_RANDOM);
                    environment.setVariable("randomList", builder.build().wrap(wpPostsService.getPostListByPage(postParam).getList()));
                    break;
                case "hotList":
                    // 热门文章,按阅读量
                	postParam.setSortType(PostConstant.SORTTYPE_VIEW);
                    environment.setVariable("hotList", builder.build().wrap(wpPostsService.getPostListByPage(postParam).getList()));
                    break;
                default:
                    break;
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}
