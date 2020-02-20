package com.xtel.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;

public class LoggingClass {
    private static Logger logger;
    static{
        String path = new File("E:/eclipse/ProjectFinalRestApiVietLot/config/log4j.properties").getAbsolutePath();
        PropertyConfigurator.configure(path);
        logger = LogManager.getLogger(LoggingClass.class);
    }
    public static Logger getLogger(){
        return  logger;
    }

}
