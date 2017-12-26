package com.nature.hkail.refwait.util;

import com.alibaba.fastjson.JSONObject;
import com.nature.hkail.refwait.manager.MyX509TrustManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author HuangKailie
 * @className NetUtil
 * @date 2017-12-19 15:11:35
 * @description 网络处理工具类
 */
public class NetUtil {

    /**
     * @date 2017-12-19 15:12:29
     * @description 发起HTTPS请求并返回JSON格式数据
     * @param requestUrl 请求地址
     * @param requestMethod 请求方法（GET/POST）
     * @param requestBody 提交的数据
     * @return JSONObject JSON格式数据
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String requestBody) {
        JSONObject jsonObject = null;
        StringBuffer result = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;
        HttpsURLConnection httpsURLConnection = null;
        try {
            // 创建SSLContext对象
            TrustManager[] trustManagers = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
            // 从SSLContext对象中获取SSLSocketFactory对象
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // 建立网络连接
            URL url = new URL(requestUrl);
            // 打开HTTPS网络连接
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            // 设置超时时间
            httpsURLConnection.setReadTimeout(2000);
            // 伪装
            httpsURLConnection.setRequestProperty("User-Agent", "java");
            // 设置SSLSocketFactory;
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
            // 打开输出流
            httpsURLConnection.setDoOutput(true);
            // 打开输入流
            httpsURLConnection.setDoInput(true);
            // 关闭缓存
            httpsURLConnection.setUseCaches(false);
            // 设置请求方式
            httpsURLConnection.setRequestMethod(requestMethod);

            // 当请求方式为GET时
            if ("GET".equalsIgnoreCase(requestMethod))
                httpsURLConnection.connect();

            // 当有数据需要提交时
            if (requestBody != null) {
                outputStream = httpsURLConnection.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(requestBody.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            inputStream = httpsURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null)
                result.append(str);
            jsonObject = JSONObject.parseObject(result.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            System.out.println("SSLContext初始化失败！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("建立网络连接失败！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("打开HTTPS网络连接失败！");
            e.printStackTrace();
        } finally {
            // 关闭HTTPS网络连接
            if (httpsURLConnection != null)
                httpsURLConnection.disconnect();
            // 释放资源
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}
