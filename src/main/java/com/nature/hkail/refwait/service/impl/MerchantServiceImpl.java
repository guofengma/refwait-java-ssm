package com.nature.hkail.refwait.service.impl;

import com.nature.hkail.refwait.dao.MerchantDao;
import com.nature.hkail.refwait.model.Merchant;
import com.nature.hkail.refwait.service.MerchantService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author HuangKailie
 * @className MerchantServiceImpl
 * @date 2017年12月26日15:01:36
 * @description 商家信息业务处理接口实现类
 */
@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    private Logger logger = Logger.getLogger(MerchantServiceImpl.class);

    @Resource
    private MerchantDao merchantDao;

    public Long addNewMerchant(Merchant merchant) {
        System.out.println(merchant.getId() + " " + merchant.getTelephone());
        int n = merchantDao.insertNewMerchant(merchant);
        System.out.println(n);
        return null;
    }
}
