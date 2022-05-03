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

    /**
     * 更新cookie
     * @param cookie 新的cookie
     * @return 是否成功
     */
    boolean setCookie(String cookie);
}
