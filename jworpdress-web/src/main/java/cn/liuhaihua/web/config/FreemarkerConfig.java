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
package cn.liuhaihua.web.config;
 
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import cn.liuhaihua.web.tag.CustomTagDirective;
import cn.liuhaihua.web.tag.PostTagDirective;
/**
 * @ClassName: FreemarkerConfig
 * @Description: freemarker模板配置类
 * @author Liuhaihua
 * @date 2018年7月10日
 *
 */
@Configuration
public class FreemarkerConfig {
	@Autowired
	private CustomTagDirective customTagDirective;
	@Autowired
	private PostTagDirective postTagDirective;
    @Autowired  
    protected freemarker.template.Configuration configuration;  
    @Autowired  
    protected org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver resolver;  
    @Autowired  
    protected org.springframework.web.servlet.view.InternalResourceViewResolver springResolver;  
    
    @PostConstruct  
    public void  setSharedVariable(){  
        resolver.setSuffix(".ftl");   
        resolver.setCache(false); 
        resolver.setRequestContextAttribute("request"); //为模板调用时，调用request对象的变量名</span>  
        resolver.setOrder(0);  
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        try {
            //自定义标签
        	 configuration.setSharedVariable("customTag", customTagDirective);
        	 configuration.setSharedVariable("articleTag", postTagDirective);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
