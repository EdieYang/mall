package com.linkpets.result;

public enum ApiResultCode {


	SUCCESS(200,"成功"), // 成功
	FAIL(400,"失败"), // 失败
	UNAUTHORIZED(401,"未认证"), // 未认证（签名错误）
	NOT_FOUND(404,"接口不存在"), // 接口不存在
	INTERNAL_SERVER_ERROR(500,"服务器内部错误"),// 服务器内部错误
	JSON_PARSE_ERROR(10001,"Json解析错误"),
    LOGIC_ERROR(20001,"处理逻辑错误"),
    VERSION_ERROR(30001,"版本不一致"),
	VALID_USER_ACCOUNT(40001,"账户不存在"),
    VALID_USER_ACCOUNT_PASSWORD(40002,"密码错误"),

	COMMODITY_INVALID_NAME(11000,"商品名称不能为空"),
    COMMODITY_INVALID_TYPE(11001,"商品类型不能为空"),
    COMMODITY_INVALID_STATUS(11002,"商品状态不能为空"),
    COMMODITY_INVALID_PATTERN(11003,"商品模式不能为空"),
    COMMODITY_INVALID_DISPLAY_IMG(11004,"商品展示缩略图不能为空"),
    COMMODITY_INVALID_MARKET_PRICE(11005,"商品市场价不能为0"),
    COMMODITY_INVALID_SELLING_PRICE(11006,"商品售价不能为0"),
    COMMODITY_INVALID_PURCHASE_PRICE(11007,"商品结算价不能为0"),
    COMMODITY_INVALID_STOCK(11008,"商品库存不能为0"),
    COMMODITY_INVALID_RULES(11009,"商品购买须知不能为空"),
    COMMODITY_INVALID_USAGE(11010,"商品使用须知不能为空"),
    COMMODITY_INVALID_DETAIL(11011,"商品详情不能为空"),
    COMMODITY_INVALID_SHOP_ID(11012,"商户ID不能为空"),
    COMMODITY_INVALID_CS_CONTACT(11013,"客服联系方式不能为空"),
    COMMODITY_INVALID_CS_WXCODE(11014,"客服微信二维码不能为空"),
    COMMODITY_INVALID_SHARE_TITLE(11015,"商品分享标题不能为空"),
    COMMODITY_INVALID_SHARE_INFO(11016,"商品分享内容不能为空"),
    COMMODITY_INVALID_SHARE_WAP_IMG(11017,"商品WAP分享图片不能为空"),
    COMMODITY_INVALID_IMG(11018,"商品图片不能为空");



    private int code;
    private String msg;

    ApiResultCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}


