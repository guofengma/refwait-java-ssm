package com.nature.hkail.refwait.service.impl;

import com.nature.hkail.refwait.dao.MerchantDao;
import com.nature.hkail.refwait.model.Merchant;
import com.nature.hkail.refwait.service.CommonService;
import com.nature.hkail.refwait.service.MerchantService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuangKailie
 * @className MerchantServiceImpl
 * @date 2017-12-26 15:01:36
 * @description 商家信息业务处理接口实现类
 */
@Service("merchantService")
public class MerchantServiceImpl extends CommonService implements MerchantService {

    private Logger logger = Logger.getLogger(MerchantServiceImpl.class);

    @Resource
    private MerchantDao merchantDao;

    public List<Merchant> listNearMerchants(Double longitude, Double latitude) {
        List<Merchant> merchants = null;
        // 获取所有合格商家
        merchants = merchantDao.selectAllMerchantsByQual(1);
        // 初始化商家信息
        initMerchants(merchants, longitude, latitude);
        for (Merchant merchant:merchants) {
            System.out.println(merchant.toString());
        }
        return merchants;
    }

    public Long addNewMerchant(Merchant merchant) {
        System.out.println(merchant.getId() + " " + merchant.getTelephone());
        int n = merchantDao.insertNewMerchant(merchant);
        System.out.println(n);
        return null;
    }
}
