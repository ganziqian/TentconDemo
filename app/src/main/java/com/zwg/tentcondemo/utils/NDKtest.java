package com.zwg.tentcondemo.utils;

/**
 * 创建人： ganziqian
 * 时  间： 2017/8/5.
 * 作  用：
 */

public class NDKtest {

    public native static String getJNIString();

    static {
        System.loadLibrary("TentconDemo");

    }

    public NDKtest() {

    }


    public String getH(){

        return getJNIString();
    }
}
