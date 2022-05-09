package com.example.springbootbase.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouwei
 * @description: 星座枚举
 * @date 2022/5/7 9:36
 */
@Getter
public enum ConstellationEnum {

    ARIES("白羊座", 1),
    TAURUS("金牛座", 2),
    GEMINI("双子座", 3),
    CANCER("巨蟹座", 4),
    LEO("狮子座", 5),
    VIRGO("处女座", 6),
    LIBRA("天秤座", 7),
    SCORPIO("天蝎座", 8),
    SAGITTARIUS("射手座", 9),
    CAPRICORNUS("摩羯座", 10),
    AQUARIUS("水瓶座", 11),
    PISCES("双鱼座", 12);

    ConstellationEnum(String desc,Integer type){
        this.desc = desc;
        this.type = type;
    }

    private final String desc;
    private final Integer type;

    private static final Map<Integer, ConstellationEnum> MAP = new HashMap<>();

    static {
        MAP.put(ARIES.type, ARIES);
        MAP.put(TAURUS.type, TAURUS);
        MAP.put(GEMINI.type, GEMINI);
        MAP.put(CANCER.type, CANCER);
        MAP.put(LEO.type, LEO);
        MAP.put(VIRGO.type, VIRGO);
        MAP.put(LIBRA.type, LIBRA);
        MAP.put(SCORPIO.type, SCORPIO);
        MAP.put(SAGITTARIUS.type, SAGITTARIUS);
        MAP.put(CAPRICORNUS.type, CAPRICORNUS);
        MAP.put(AQUARIUS.type, AQUARIUS);
        MAP.put(PISCES.type, PISCES);
    }

    public static Boolean containsCode(Integer code) {
        return MAP.containsKey(code);
    }

}
