package com.nature.hkail.refwait.test.dao;

import com.nature.hkail.refwait.dao.MerchantDao;
import com.nature.hkail.refwait.model.Merchant;
import com.nature.hkail.refwait.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * 商家信息DAO事务处理测试类
 */
public class MerchantDaoTest extends BaseTest {

    @Resource
    private MerchantDao merchantDao;

    @Test
    public void testInsertNewMerchant() {
        Merchant merchant = new Merchant();
        merchant.setAddress("S3");
        merchant.setIconUrl("图片URL");
        merchant.setLatitude(5.5);
        merchant.setLongitude(5.5);
        merchant.setMobilePhone("1110");
        merchant.setName("第六饭");
        merchant.setNotice("公告");
        merchant.setOpenid("ha");
        merchant.setTelephone("1234");
        int n = merchantDao.insertNewMerchant(merchant);
        System.out.println(n + " " + merchant.getId());
    }
}
