package com.nature.hkail.refwait.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HuangKailie
 * @className CommonUtil
 * @date 2017-12-21 17:36:21
 * @description 公共工具类
 */
public class CommonUtil {

	/**
	 * @date 2017-12-24 15:50:09
	 * @description 判断字符是否为中文
	 * @param c 字符
	 * @return boolean 是否为中文
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * @date 2017-12-24 15:50:20
	 * @description 判断字符串是否乱码
	 * @param strName 字符串
	 * @return boolean 是否为乱码
	 */
	public static boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|t*|r*|n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = ch.length;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) {
				if (!isChinese(c)) {
					count = count + 1;
				}
			}
		}
		float result = count / chLength;
		if (result > 0.4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @date 2017-12-24 15:50:52
	 * @description 生成6位数验证码
	 * @return int 6位数验证码
	 */
	public static int getVerificationCode() {
		return (int)(Math.random() * 900000) + 100000;
	}

	/**
	 * @date 2017-12-24 15:51:00
	 * @description 解决@RequestParam传值中文乱码
	 * @param str 需要解决中文乱码的字符串
	 * @return String 格式化后的字符串
	 */
	public static String encodeStr(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @date 2017-12-24 15:51:09
	 * @description 将经纬度转化为弧度
	 * @param f 经纬度
	 * @return float 弧度
	 */
	public static Double rad(Double f) {
		return f * Math.PI / 180.0;
	}

	/**
	 * @date 2017-12-24 15:51:18
	 * @description 基于余弦定理求两经纬度距离
	 * @param lon1 位置一的经度
	 * @param lat1 位置一的纬度
	 * @param lon2 位置二的经度
	 * @param lat2 位置二的纬度
	 * @return float 距离，单位km
	 */
	public static double latitudeLongitudeDist(Double lon1, Double lat1, Double lon2, Double lat2) {
		final double EARTH_RADIUS = 6378137; // 赤道半径（单位m）
		/*
		 * 将经纬度转换成弧度
		 */
		Double radLon1 = rad(lon1);
		Double radLat1 = rad(lat1);
		Double radLon2 = rad(lon2);
		Double radLat2 = rad(lat2);
		/*
		 * 判断方向
		 */
		if (radLat1 < 0)
			radLat1 = Math.PI / 2 + Math.abs(radLat1);
		if (radLat1 > 0)
			radLat1 = Math.PI / 2 - Math.abs(radLat1);
		if (radLon1 < 0)
			radLon1 = Math.PI * 2 - Math.abs(radLon1);
		if (radLat2 < 0)
			radLat2 = Math.PI / 2 + Math.abs(radLat2);
		if (radLat2 > 0)
			radLat2 = Math.PI / 2 - Math.abs(radLat2);
		if (radLon2 < 0)
			radLon2 = Math.PI * 2 - Math.abs(radLon2);
		double x1 = EARTH_RADIUS * Math.cos(radLon1) * Math.sin(radLat1);
		double y1 = EARTH_RADIUS * Math.sin(radLon1) * Math.sin(radLat1);
		double z1 = EARTH_RADIUS * Math.cos(radLat1);

		double x2 = EARTH_RADIUS * Math.cos(radLon2) * Math.sin(radLat2);
		double y2 = EARTH_RADIUS * Math.sin(radLon2) * Math.sin(radLat2);
		double z2 = EARTH_RADIUS * Math.cos(radLat2);

		double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));

		double theta = Math.acos((EARTH_RADIUS * EARTH_RADIUS + EARTH_RADIUS * EARTH_RADIUS - d * d)
				/ (2 * EARTH_RADIUS * EARTH_RADIUS));
		double dist = theta * EARTH_RADIUS;
		return dist / 1000;
	}
}
