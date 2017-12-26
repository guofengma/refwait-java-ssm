package com.nature.hkail.refwait.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author HuangKailie
 * @className BaseTest
 * @date 2017-12-19 11:28:17
 * @description 基本测试类（用于被继承）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class BaseTest {

}
