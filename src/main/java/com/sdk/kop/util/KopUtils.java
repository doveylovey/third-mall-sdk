package com.sdk.kop.util;

import com.alibaba.fastjson.JSON;
import com.sdk.kop.constant.KopConstants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 考拉赚客工具类
 *
 * @author Administrator
 */
public class KopUtils {
    private KopUtils() {
        throw new AssertionError("No com.sdk.kop.util.KopUtils instances for you!");
    }

    /**
     * 对请求参数进行 MD5 加密
     *
     * @param secretKey
     * @param paramMap
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String createSign(String secretKey, TreeMap<String, String> paramMap)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String sign = secretKey;
        Iterator it = paramMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!"sign".equals(entry.getKey())) {
                sign = sign + entry.getKey() + entry.getValue();
            }
        }
        sign = sign + secretKey;
        sign = md5Encode2UpperCase(sign);
        return sign;
    }

    /**
     * 将加密结果进行转化
     *
     * @param sign
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String md5Encode2UpperCase(String sign)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] byteArray = sign.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; ++i) {
            int val = md5Bytes[i] & 255;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        String rs = hexValue.toString().toUpperCase();
        return rs;
    }

    /**
     * 将指定日期时间格式化成 yyyy-MM-dd HH:mm:ss 形式
     *
     * @return
     */
    public static String getFormatDateTime(LocalDateTime localDateTime) {
        String date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String datetime1 = date + time;
        String datetime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return datetime;
    }

    /**
     * 获取指定日期时间的秒值：10 位
     *
     * @param localDateTime
     * @return
     */
    public static long getSeconds(LocalDateTime localDateTime) {
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        long seconds = localDateTime.toEpochSecond(zoneOffset);
        return seconds;
    }

    /**
     * 获取指定日期时间的毫秒值：13 位
     *
     * @param localDateTime
     * @return
     */
    public static long getMilliSeconds(LocalDateTime localDateTime) {
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        Instant instant = localDateTime.toInstant(zoneOffset);
        long millisecond = instant.toEpochMilli();
        return millisecond;
    }

    /**
     * 使用 HttpClient 发送 post 请求
     *
     * @param request
     * @param methodName
     * @return
     * @throws Exception
     */
    public static String doPost(Object request, String methodName) throws Exception {
        TreeMap<String, String> initTreeMap = initCommonTreeMap(methodName);
        TreeMap<String, String> requestTreeMap = obj2TreeMap(request);
        initTreeMap.putAll(requestTreeMap);
        String sign = createSign(KopConstants.APPSECRET, initTreeMap);
        initTreeMap.put("sign", sign);
        // 参数
        String params = map2Url(initTreeMap);
        // 创建 Post 请求
        String uri = KopConstants.SERVER + "?" + params;
        System.out.println("请求地址：" + uri);
        HttpPost httpPost = new HttpPost(uri);
        // 设置 ContentType(注：如果只传普通参数，ContentType 不一定非要用 application/json)
        httpPost.setHeader("Accept", "application/json;charset=UTF-8");
        // 获得 Http 客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 响应结果
        CloseableHttpResponse response = null;
        try {
            // 由客户端发送 Post 请求得到响应结果
            response = httpClient.execute(httpPost);
            System.out.println("响应结果：" + JSON.toJSONString(response));
            StatusLine statusLine = response.getStatusLine();
            System.out.println("响应状态：" + statusLine.toString());
            if (statusLine != null && HttpStatus.SC_OK == statusLine.getStatusCode()) {
                // 从响应模型中获取响应实体
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    //System.out.println("响应内容长度为：" + responseEntity.getContentLength());
                    //System.out.println("响应内容为：" + EntityUtils.toString(responseEntity));
                    return EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 使用公共参数初始化一个 TreeMap
     *
     * @param methodName
     * @return
     */
    public static TreeMap<String, String> initCommonTreeMap(String methodName) {
        // 参考 https://www.cnblogs.com/longronglang/p/8670780.html
        TreeMap<String, String> map = new TreeMap<>(Comparator.naturalOrder());
        map.put("timestamp", KopUtils.getFormatDateTime(LocalDateTime.now()));
        map.put("v", KopConstants.VERSION);
        map.put("signMethod", KopConstants.SIGN_METHOD);
        map.put("unionId", KopConstants.ZHUANKE_ID);
        map.put("method", methodName);
        return map;
    }

    /**
     * 将对象的属性和值转化成 TreeMap 对象
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static TreeMap<String, String> obj2TreeMap(Object obj) throws IllegalAccessException {
        // 参考 https://www.cnblogs.com/longronglang/p/8670780.html
        TreeMap<String, String> map = new TreeMap<>(Comparator.naturalOrder());
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (field.get(obj) != null) {
                map.put(fieldName, field.get(obj).toString());
            }
        }
        map.remove("serialVersionUID");
        return map;
    }

    /**
     * 将对象的属性和值转化成请求的 url 字符串
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static String obj2Url(Object obj) throws Exception {
        Class<? extends Object> c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        Map<String, String> map = new TreeMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            if (value != null) {
                map.put(name, value.toString());
            }
        }
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> it = set.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Map.Entry<String, String> e = it.next();
            if (!"serialVersionUID".equals(e.getKey())) {
                sb.append(e.getKey()).append("=").append(URLEncoder.encode(e.getValue(), "utf-8")).append("&");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * 将 Map 的 key、value 转化成请求的 url 字符串
     *
     * @param source
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String map2Url(Map<String, String> source) throws UnsupportedEncodingException {
        Iterator<String> it = source.keySet().iterator();
        StringBuilder paramStr = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            String value = source.get(key);
            if (value == null || "".equals(value.trim())) {
                continue;
            }
            // 特别注意：使用 HttpClient 则需要对带空格的参数、值进行编码，而使用 RestTemplate 则不需要手动对其编码，RestTemplate 会自动对其编码
            //value = URLEncoder.encode(value, "utf-8");
            paramStr.append("&").append(key).append("=").append(value);
        }
        // 去掉第一个&
        return paramStr.substring(1);
    }
}
