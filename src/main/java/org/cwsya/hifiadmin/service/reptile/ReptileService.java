package org.cwsya.hifiadmin.service.reptile;

/**
 * @author cws
 */
public interface ReptileService {
    /**
     * 爬取网页数据
     * @param url url
     * @return 页面信息
     */
    String getData(String url);
}
