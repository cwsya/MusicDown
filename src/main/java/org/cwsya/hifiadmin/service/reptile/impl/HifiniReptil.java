package org.cwsya.hifiadmin.service.reptile.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author cws
 */
public class HifiniReptil {
    private static HifiniReptileServiceImpl intstance;

    public static HifiniReptileServiceImpl getIntstance() {
        if (null==intstance){
            synchronized (HifiniReptil.class){
                if (null==intstance){
                    intstance=new HifiniReptileServiceImpl();
                }
            }
        }
        return intstance;
    }

    private HifiniReptil() {
    }
}
