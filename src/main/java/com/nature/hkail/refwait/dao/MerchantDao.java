package com.nature.hkail.refwait.dao;

import com.nature.hkail.refwait.model.Merchant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuangKailie
 * @className MerchantDao
 * @date 2017-12-26 11:20:34
 * @description 商家信息DAO事务处理接口
 */
@Repository("merchantDao")
public interface MerchantDao {

    /**
     * @date 2017-12-30 10:30:36
     * @description 根据合格情况查询符合条件的所有商家信息
     * @param qual 0：不合格，1：合格，2：审核中，default：全部
     * @return List<Merchant> 商家信息列表
     */
    List<Merchant> selectAllMerchantsByQual(@Param("qual") Integer qual);

    /**
     * @date 2017-12-26 11:21:24
     * @description 插入新商家信息
     * @param merchant 商家信息对象
     * @return int 成功插入的信息数
     */
    int insertNewMerchant(Merchant merchant);
}
