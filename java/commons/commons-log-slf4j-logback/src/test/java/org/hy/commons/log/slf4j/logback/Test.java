package org.hy.commons.log.slf4j.logback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test
{
    /**
     * 日志记录
     */
//    private Logger logger = LoggerFactory.getLogger("traceInfo");
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    /**
     * 目录信息
     */
    private Logger categoryInfo = LoggerFactory.getLogger("categoryInfo");

    /**
     * 目录与目录的关联关系
     */
    private Logger productInfo = LoggerFactory.getLogger("productInfo");

    public void print()
    {
        // 日志记录
        if (logger.isDebugEnabled())
        {
            logger.debug("Entry: print().");
        }
        categoryInfo.info("categoryInfo");
        productInfo.info("productInfo");
        // 日志记录
        if (logger.isDebugEnabled())
        {
            logger.debug("Exit: print().");
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    	logger.debug("xxxxxxxxxxx000");
        new Test().print();

    }

} 