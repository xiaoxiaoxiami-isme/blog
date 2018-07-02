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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 
 * @ClassName: ApplicationConfiguration
 * @Description: druid配置类
 * @author Liuhaihua
 * @date 2018年6月26日
 *
 */
@Configuration
@Component
public class DruidConfiguration {
	// 其中 dataSource 框架会自动为我们注入
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * @Title: dataSource
	 * @Description: 加载数据源
	 * @param @return    参数
	 * @return DataSource    返回类型
	 * @throws
	 */
	@Bean(name = "dataSource")
	@Qualifier(value = "dataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * @Title: DruidStatViewServle2
	 * @Description: 注册一个StatViewServlet
	 * @param @return    参数
	 * @return ServletRegistrationBean    返回类型
	 * @throws
	 */
	@Bean
	public ServletRegistrationBean DruidStatViewServle2() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");
		// 添加初始化参数：initParams
		/** 白名单，如果不配置或value为空，则允许所有 */
		// servletRegistrationBean.addInitParameter("allow","127.0.0.1,192.0.0.1");
		/** 黑名单，与白名单存在相同IP时，优先于白名单 */
		// servletRegistrationBean.addInitParameter("deny","192.0.0.1");
		/** 用户名 */
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		/** 密码 */
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		/** 禁用页面上的“Reset All”功能 */
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
	
	/**
	 * @Title: druidStatFilter2
	 * @Description: 注册一个：WebStatFilter
	 * @param @return    参数
	 * @return FilterRegistrationBean    返回类型
	 * @throws
	 */
	@Bean
	public FilterRegistrationBean druidStatFilter2() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		/** 过滤规则 */
		filterRegistrationBean.addUrlPatterns("/*");
		/** 忽略资源 */
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
		return filterRegistrationBean;
	}
}
