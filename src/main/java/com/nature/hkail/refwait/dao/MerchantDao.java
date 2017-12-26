package com.nature.hkail.refwait.dao;

import com.nature.hkail.refwait.model.Merchant;
import org.springframework.stereotype.Repository;

/**
 * @author HuangKailie
 * @className MerchantDao
 * @date 2017年12月26日11:20:34
 * @description 商家信息DAO事务处理接口
 */
@Repository("merchantDao")
public interface MerchantDao {

    /**
     * @date 2017年12月26日11:21:24
     * @description 插入新商家信息
     * @param merchant 商家信息对象
     * @return int 成功插入的信息数
     */
    int insertNewMerchant(Merchant merchant);
}
