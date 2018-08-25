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
package cn.liuhaihua.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: 日期操作类
 * @author Liuhaihua
 * @date 2018年8月25日
 *
 */
public class DateUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS_EN = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSSEN = "yyyyMMddHHmmss";

    /**
     * yyyyMMddHHmmssSSS
     */
    public static final String MILLISECOND = "yyyyMMddHHmmssSSS";
    /**
     * 字符串日期转换为Date日期
     *
     * @param dateStr
     *         字符串日期
     * @param pattern
     *         参考DateConst.java
     * @return Date类型的日期
     */
    public static Date str2Date(String dateStr, String pattern) {
        Date resultDate = null;
        if (dateStr != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                resultDate = sdf.parse(dateStr);
            } catch (ParseException e) {
                LOG.error("日期转换异常", e);
            }
        }
        return resultDate;
    }

    /**
     * Date日期转换为字符串日期
     *
     * @param date
     *         Date日期
     * @param pattern
     *         参考DateConst.java
     * @return 字符串类型的日期
     */
    public static String date2Str(Date date, String pattern) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            dateStr = sdf.format(date);
        }
        return dateStr;
    }

    /**
     * 获取两个日期间隔的天数
     *
     * @param before
     *         较前的时间
     * @param after
     *         较后的时间
     * @return 返回两者相差的天数
     */
    public static int getGapDay(Date before, Date after) {
        return (null == before || null == after) ? 0 : Long.valueOf(Math.abs(after.getTime() - before.getTime()) / (24 * 60 * 60 * 1000)).intValue();
    }
}
