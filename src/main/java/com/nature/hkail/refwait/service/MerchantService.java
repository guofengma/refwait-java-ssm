package com.nature.hkail.refwait.service;

import com.nature.hkail.refwait.model.Merchant;

import java.util.List;

/**
 * @author HuangKailie
 * @className MerchantService
 * @date 2017-12-26 15:00:50
 * @description 商家信息业务处理接口
 */
public interface MerchantService {

    /**
     * @date 2017-12-30 10:59:40
     * @description 根据经纬度获取附近商家
     * @param longitude 经度
     * @param latitude 纬度
     * @return List<Merchant> 商家信息列表
     */
    List<Merchant> listNearMerchants(Double longitude, Double latitude);

    /**
     * @date 2017-12-26 15:36:44
     * @description 添加新商家信息
     * @param merchant 商家信息对象
     * @return Long 商家ID号
     */
    Long addNewMerchant(Merchant merchant);
}
