package com.nature.hkail.refwait.manager;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author HuangKailie
 * @className MyX509TrustManager
 * @date 2017-12-19 15:17:59
 * @description 信任管理器
 */
public class MyX509TrustManager implements X509TrustManager {

    /**
     * @date 2017-12-19 15:17:59
     * @description 检查客户端证书
     * @param x509Certificates
     * @param s
     * @throws CertificateException
     */
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    /**
     * @date 2017-12-19 15:17:59
     * @description 检查服务器证书
     * @param x509Certificates
     * @param s
     * @throws CertificateException
     */
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    /**
     * @date 2017-12-19 15:17:59
     * @description 返回受信任的X509证书数组
     * @return X509Certificate[]
     */
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
