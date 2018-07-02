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
package cn.liuhaihua.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.liuhaihua.web.mapper.BaseMapper;

/**
 * @ClassName: JWordpressWebApplication
 * @Description: Springboot应用程序启动类
 * @author Liuhaihua
 * @date 2018年6月26日
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "cn.liuhaihua.web.*", markerInterface = BaseMapper.class)
public class JWordpressWebApplication {

	/**
	 * @Title: main
	 * @Description: main启动方法
	 * @param @param args  
	 * @return void    
	 * @throws
	 */
	public static void main(String[] args) {
		 SpringApplication.run(JWordpressWebApplication.class, args);
	     System.out.println("JWordpressWebApplication启动成功");
	}

}
