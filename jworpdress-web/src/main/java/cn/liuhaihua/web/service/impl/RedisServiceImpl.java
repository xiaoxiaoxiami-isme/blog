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

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

import cn.liuhaihua.web.service.RedisService;

/**
 * 
 * @ClassName: RedisServiceImpl
 * @Description:
 * @author Liuhaihua
 * @date 2018年11月23日
 *
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public <T> void set(String key, T value, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }

    @Override
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void del(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }

    @Override
    public void delBatch(Set<String> keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public void delBatch(String keyPrefix) {
        Set<String> keys = this.keySet(keyPrefix + "*");
        if (!CollectionUtils.isEmpty(keys)) {
            delBatch(keys);
        }
    }

    @Override
    public <T> void setList(String key, List<T> list) {
        String value = JSON.toJSONString(list);
        set(key, value);
    }

    @Override
    public <T> void setList(String key, List<T> list, long expire, TimeUnit timeUnit) {
        String value = JSON.toJSONString(list);
        set(key, value, expire, timeUnit);
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clz) {
        String json = get(key);
        if (json != null) {
            return JSON.parseArray(json, clz);
        }
        return null;
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public Set<String> keySet(String keyPrefix) {
        return redisTemplate.keys(keyPrefix + "*");
    }
}
