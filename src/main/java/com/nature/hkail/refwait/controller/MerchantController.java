package com.nature.hkail.refwait.controller;

import com.nature.hkail.refwait.model.Merchant;
import com.nature.hkail.refwait.service.MerchantService;
import com.nature.hkail.refwait.util.JSchUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuangKailie
 * @className MerchantController
 * @date 2017-12-26 15:02:25
 * @description 商家信息控制类
 */
@Controller
@RequestMapping(value = "/merchant")
public class MerchantController {

    private Logger logger = Logger.getLogger(MerchantController.class);

    @Resource
    private JSchUtil jSchUtil;

    @Resource
    private MerchantService merchantService;

    /**
     * @date 2017-12-30 11:31:13
     * @description 根据经纬度获取附近商家信息
     * @param longitude 经度
     * @param latitude 纬度
     * @return [JSON]List<Merchant> 商家信息集合
     */
    @RequestMapping(value = "/listNearMerchants", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<Merchant> listNearMerchants(@RequestParam Double longitude, @RequestParam Double latitude) {
        List<Merchant> merchants = null;
        merchants = merchantService.listNearMerchants(longitude, latitude);
        return merchants;
    }

    /**
     * @date 2017-12-30 10:39:10
     * @description 商家注册
     * @param icon 商家图标
     * @param name 商家名称
     * @param openid 商家微信用户OPENID
     * @param telephone 商家电话
     * @param mobilePhone 商家手机号
     * @param address 商家地址
     * @param longitude 商家位置经度
     * @param latitude 商家位置纬度
     * @return String 注册成功返回"success"
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String register(@RequestParam MultipartFile icon, @RequestParam String name, @RequestParam String openid, @RequestParam String telephone, @RequestParam String mobilePhone, @RequestParam String address, @RequestParam Double longitude, @RequestParam Double latitude) {
        System.out.println(name);
        System.out.println(openid);
        System.out.println(telephone);
        System.out.println(mobilePhone);
        System.out.println(address);
        System.out.println(longitude);
        System.out.println(latitude);
        String url = null;
        try {
            url = jSchUtil.uploadFile(icon);
            System.out.println(url + " " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Merchant merchant = new Merchant();
        merchant.setOpenid(openid);
        merchant.setName(name);
        if (!"".equals(telephone))
            merchant.setTelephone(telephone);
        merchant.setMobilePhone(mobilePhone);
        merchant.setLongitude(longitude);
        merchant.setLatitude(latitude);
        merchant.setAddress(address);
        merchant.setIconUrl(url);
        merchantService.addNewMerchant(merchant);
        return "success";
    }
}