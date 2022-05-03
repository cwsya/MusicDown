package org.cwsya.hifiadmin.service.reptile;

import org.cwsya.hifiadmin.service.reptile.impl.HifiniReptil;

/**
 * 爬虫工厂
 * @author cws
 */
public class ReptileFactory {
    public static ReptileService create(String name){
        if ("hifini".equals(name)){
            return HifiniReptil.getIntstance();
        }
        return null;
    }
}
