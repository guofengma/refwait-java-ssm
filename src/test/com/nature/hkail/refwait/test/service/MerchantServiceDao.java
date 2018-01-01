package com.nature.hkail.refwait.test.service;

import com.nature.hkail.refwait.model.Merchant;
import com.nature.hkail.refwait.service.MerchantService;
import com.nature.hkail.refwait.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuangKailie
 * @date 2017-12-30 11:18:00
 * @description
 * @className
 */
public class MerchantServiceDao extends BaseTest {

    @Resource
    private MerchantService merchantService;

    @Test
    public void testListNearMerchants() {
        List<Merchant> merchantList = merchantService.listNearMerchants(22.1241,113.3543);
    }
}
