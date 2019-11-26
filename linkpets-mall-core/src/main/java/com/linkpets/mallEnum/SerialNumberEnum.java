package com.linkpets.mallEnum;

public enum SerialNumberEnum {

    COMMODITY_PREFIX("CO","商品KEY"),
    ACTIVITY_PREFIX("AO","活动KEY"),
    SHOP_PREFIX("SO","商铺KEY");

    SerialNumberEnum(String prefix,String title){
        this.prefix=prefix;
        this.title=title;
    }

    private String prefix;

    private String title;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
