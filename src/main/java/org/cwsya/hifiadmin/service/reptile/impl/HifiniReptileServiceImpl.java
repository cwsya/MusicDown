package org.cwsya.hifiadmin.service.reptile.impl;

import org.cwsya.hifiadmin.service.reptile.ReptileService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Objects;

/**
 * hifini的爬虫
 * @author cws
 */
public class HifiniReptileServiceImpl implements ReptileService {
    private final String url1= "https://www.hifini.com/thread-";
    private final String url2= ".htm";

    /**
     * cookie
     */
    private String cookie = "bbs_sid=g5qdmdmc5i4k38739t2dj991al; bbs_token=AMXpGb_2FLZCbrTZcRWasU4wLr3tJWeaoGQPTOiFneCQFBHodEch3MlvRZk2eLNLL9m1KUNFVNXluuV_2Bii3iKf7ZpckYI_3D";

    @Override
    public String getData(String url) {
        Document dataAll;
        try {

            dataAll = Jsoup.connect(url1 + url + url2).header("Cookie", cookie).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String html ="<style>"+Objects.requireNonNull(dataAll.getElementById("body")).getElementsByTag("style").html()+"</style>";
        Element data = dataAll.getElementsByAttributeValue("isfirst", "1").get(0);
        Objects.requireNonNull(data.getElementById("player4")).remove();
        Objects.requireNonNull(data.getElementsByTag("script")).remove();
        Objects.requireNonNull(data.getElementById("tag")).remove();
        return data.html() + html;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
