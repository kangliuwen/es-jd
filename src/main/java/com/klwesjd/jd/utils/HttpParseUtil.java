package com.klwesjd.jd.utils;

import com.klwesjd.jd.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: klw
 * @time: 2020-10-12 16:45
 */
@Component
public class HttpParseUtil {

    public List<Content> parseJD(String keyWord) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyWord;
        //解析网页
        Document parse = Jsoup.parse(new URL(url), 30000);
        Element element = parse.getElementById("J_goodsList");
        Elements lis = element.getElementsByTag("li");
        List<Content> jdListContent = new ArrayList<>();
        for (Element el : lis) {
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String name = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImg(img);
            content.setName(name);
            content.setPrice(price);
            jdListContent.add(content);
        }
        return jdListContent;
    }
}
