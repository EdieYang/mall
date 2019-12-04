package com.linkpets.utils;

import com.linkpets.mallEnum.SerialNumberEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Component
public class CommonUtil {

    public static String CONTRACT_CACHE_LOCATION;

    public static String ACTIVE_ENVIRONMENT;

    public static String PROJECT_VERSION;

    public static String SERVER_PORT;

    public static String SAPPLICATION_NAME;


    @Value("${spring.profiles.active}")
    private String active_environment;

    @Value("${project.version}")
    private String project_version;

    @Value("${server.port}")
    private String server_port;

    @Value("${spring.application.name}")
    private String sapplication_name;

    // 私盐
    public static final String PRIVATE_SALT = "linkpet";

    // 用户默认密码
    public static final String DEFULT_USER_PASSWORD = "000000";

    // 订单号默认格式,长度为8位
    private static final String DEFULT_ORDER_NUMBER_FORMAT = "00000000";

    // 商品编号默认格式,长度为4位
    private static final String DEFULT_COMMODITY_NUMBER_FORMAT = "0000";

    // 流水号(短)默认格式,长度为4位
    private static final String DEFULT_SHORT_NUMBER_FORMAT = "0000";

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    public static CommonUtil commonUtil;

    @PostConstruct
    public void init() {
        commonUtil = this;
        ACTIVE_ENVIRONMENT = active_environment;
        PROJECT_VERSION = project_version;
        SERVER_PORT = server_port;
        SAPPLICATION_NAME = sapplication_name;
    }


    /**
     * 生成指定长度随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomStr(int length) {
        //先定义取值范围
        String chars = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMabcdefghijklmnopqrstuvwxyz";
        StringBuffer value = new StringBuffer();
        for (int i = 0; i < length; i++) {
            value.append(chars.charAt((int) (Math.random() * chars.length())));
        }
        return value.toString();
    }

    /**
     * 生成流水号
     * @param serialNumberEnum
     * @return
     */
    public static String getSerialNumberByPrefix(SerialNumberEnum serialNumberEnum) {
        String dateValue = DateFormatUtils.getFormatDateStr("yyyyMMdd");
        String numHeader = serialNumberEnum.getPrefix() + dateValue;
        String redisKey = serialNumberEnum.getPrefix() + "-number";
        if (!commonUtil.redisUtil.hHasKey(redisKey, dateValue)) {
            commonUtil.redisUtil.hset(redisKey, dateValue, 0);
        }
        String defaultNumberFormat = "";
        switch (serialNumberEnum) {
            case COMMODITY_PREFIX:
                defaultNumberFormat = DEFULT_COMMODITY_NUMBER_FORMAT;
                break;
            case SHOP_PREFIX:
                defaultNumberFormat = DEFULT_SHORT_NUMBER_FORMAT;
                break;
            default:
                break;
        }
        DecimalFormat df2 = new DecimalFormat(defaultNumberFormat);
        int num = (int) commonUtil.redisUtil.hincr(redisKey, dateValue, 1);

        return String.valueOf(num).length() > defaultNumberFormat.length() ? numHeader + num
                : numHeader + df2.format(num);
    }

    /**
     * 获取流水号长度
     *
     * @param prefix
     * @return
     */
    public static int getSerialNumberLengthByPrefix(String prefix) {
        return (prefix + "yyyyMMdd" + DEFULT_COMMODITY_NUMBER_FORMAT).length();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
