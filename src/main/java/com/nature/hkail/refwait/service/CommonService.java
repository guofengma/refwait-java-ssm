package com.nature.hkail.refwait.service;

import com.nature.hkail.refwait.model.Merchant;
import com.nature.hkail.refwait.util.CommonUtil;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/**
 * @author HuangKailie
 * @date 2017-12-30 11:01:00
 * @description 公共业务处理类
 * @className CommonService
 */
public class CommonService {

    /**
     * @date 2017-12-30 11:04:34
     * @description 商家信息初始化，设置与顾客相距距离
     * @param merchantList 商家信息列表
     * @param longitude 顾客位置经度
     * @param latitude 顾客位置纬度
     */
    public void initMerchants(List<Merchant> merchantList, Double longitude, Double latitude) {
        // 用于格式化数据，保留两位小数
        DecimalFormat df = new DecimalFormat(".##");
        // 距离
        Double distance;
        Iterator<Merchant> merchantIterable = merchantList.iterator();
        Merchant merchant = null;
        while (merchantIterable.hasNext()) {
            merchant = merchantIterable.next();
            // 调用CommonUtil工具类中的latitudeLongitudeDist方法根据两地经纬度计算距离并使用DecimalFormat格式化数据，并将数据类型转换成Double
            distance = Double.valueOf(df.format(CommonUtil.latitudeLongitudeDist(longitude, latitude, merchant.getLongitude(), merchant.getLatitude())));
            merchant.setDistance(distance);
        }
    }
}
