package org.hy.commons.web.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.hy.commons.io.maven.util.MavenUtil;

/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //MavenUtil.createProjectPackage();
        Endpoint.publish("http://localhost:7777/xxx", new ToOut());
    }
}
