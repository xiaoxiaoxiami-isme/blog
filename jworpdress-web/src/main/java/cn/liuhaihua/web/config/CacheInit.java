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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CacheInit
 * @Description: 系统启动时候加载一些启动数据
 * @author Liuhaihua
 * @date 2018年6月27日
 *
 */
@Component
@Order(1)
public class CacheInit implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(CacheInit.class);
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	/**
	 * @param args
	 * @throws Exception
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
    @Override
    public void run(String... args) throws Exception {
    	log.info(">>>>>>>>>>>>>加载缓存数据开始<<<<<<<<<<<<<<<<<<<<<<");
    	redisTemplate.opsForValue().set("test", "test");
    	Object test =redisTemplate.opsForValue().get("test");
    	log.info("取出缓存数据："+test.toString());
        log.info(">>>>>>>>>>>>>初始化缓存数据 结束<<<<<<<<<<<<<<<<<<<<<<");
    }
    
   
}