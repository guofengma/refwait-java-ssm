package com.nature.hkail.refwait.service;

import com.nature.hkail.refwait.model.Merchant;

/**
 * @author HuangKailie
 * @className MerchantService
 * @date 2017年12月26日15:00:50
 * @description 商家信息业务处理接口
 */
public interface MerchantService {

    /**
     * @date 2017年12月26日15:36:44
     * @description 添加新商家信息
     * @param merchant 商家信息对象
     * @return Long 商家ID号
     */
    Long addNewMerchant(Merchant merchant);
}
