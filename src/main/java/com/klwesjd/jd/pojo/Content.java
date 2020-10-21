package com.klwesjd.jd.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: klw
 * @time: 2020-10-12 17:06
 */
@Data
@Component
public class Content {

    private String img;
    private String price;
    private String name;

    public Content(String img, String price, String name) {
        this.img = img;
        this.price = price;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Content() {

    }
}
