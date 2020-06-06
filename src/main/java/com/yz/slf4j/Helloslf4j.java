package com.yz.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 参考文档
 * https://blog.csdn.net/zxssoft/article/details/83211461
 * https://blog.csdn.net/sinat_25076521/article/details/80513543
 */
public class Helloslf4j {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Helloslf4j.class);

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

        logger.warn("hello {} {}", "www.teng.com", "good");
    }
}
