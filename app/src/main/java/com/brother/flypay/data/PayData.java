package com.brother.flypay.data;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 15:53
 */
public class PayData extends BmobObject {
    /*支付的标题*/
    private String paytitle;
    /*支付地点*/
    private String address;
    /*支付类型*/
    private String type;
    /*花费*/
    private Float money;
    /*支付人的名字*/
    private String payperson;
    /*支付凭证截图*/
    private BmobFile pic;
    /*支付描述*/
    private String describe;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPaytitle() {
        return paytitle;
    }

    public void setPaytitle(String paytitle) {
        this.paytitle = paytitle;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getPayperson() {
        return payperson;
    }

    public void setPayperson(String payperson) {
        this.payperson = payperson;
    }

    public BmobFile getPic() {
        return pic;
    }

    public void setPic(BmobFile pic) {
        this.pic = pic;
    }
}
