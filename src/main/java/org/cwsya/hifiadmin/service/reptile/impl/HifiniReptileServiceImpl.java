package org.cwsya.hifiadmin.service.reptile.impl;

import org.cwsya.hifiadmin.service.reptile.ReptileService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;


/**
 * @author cws
 */
public class HifiniReptileServiceImpl implements ReptileService {
    Logger logger= LoggerFactory.getLogger(getClass());
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
            dataAll = Jsoup.connect(url1 + url + url2).header("Cookie", cookie).timeout(10*1000).get();
        } catch (IOException e) {
            logger.error("爬取请求失败---->hifini-"+url);
            throw new RuntimeException(e);
        }

        String html ="<style>"+Objects.requireNonNull(dataAll.getElementById("body")).getElementsByTag("style").html()+"</style>";
        Element data;
        try {
            data = dataAll.getElementsByAttributeValue("isfirst", "1").get(0);
        }catch (Exception e){
            logger.error("页面解析失败---->hifini-"+url);
            return null;
        }

        try {
            assert data != null;
            Objects.requireNonNull(data.getElementById("player4")).remove();
            Objects.requireNonNull(data.getElementsByTag("script")).remove();
            Objects.requireNonNull(data.getElementById("tag")).remove();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data.html() + html;
    }


    @Override
    public boolean setCookie(String cookie) {
        this.cookie = cookie;
        return true;
    }
}
