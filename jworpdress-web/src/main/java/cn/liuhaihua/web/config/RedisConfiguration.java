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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisConfiguration
 * @Description: redis初始化配置
 * @author Liuhaihua
 * @date 2018年6月27日
 *
 */
@Configuration
@Component
public class RedisConfiguration {
	/**
	 * @Title: redisTemplate
	 * @Description: 初始化一个RedisTemplate<String, Object>  bean，后面可以直接使用
	 * @param @param factory
	 * @param @return    参数
	 * @return RedisTemplate<String,Object>    返回类型
	 * @throws
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		template.setHashValueSerializer(new JdkSerializationRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		return template;
	}
	/**
	 * 
	 * @Title: createTemplate
	 * @Description: 初始化一个RedisTemplate<String, Long>，后续直接使用
	 * @param @param factory
	 * @param @return    参数
	 * @return RedisTemplate<String,Long>    返回类型
	 * @throws
	 */
	@Bean
	public RedisTemplate<String, Long> createTemplate(RedisConnectionFactory factory) {
		final RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<>(Long.class));
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Long.class));
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
