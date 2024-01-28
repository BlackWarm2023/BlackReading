package com.bk.commen.vo;

/**
 * @Description: TODO
 * @author: BlackWarm
 * @date: 2024年 01月 19日  18:33
 */
public enum CodeNum {
    SUCCESS(20000),
    ERROR(20001),
    FAIL(20002),
    JWTWX(20005);

    private final int num;
    CodeNum(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
}
