package org.hy.commons.web.webservice.example.client;

import org.hy.commons.web.webservice.ToOut;
import org.hy.commons.web.webservice.ToOutService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ToOutService toOutService = new ToOutService();
        ToOut toOut =  toOutService.getToOutPort();
        String string =toOut.say("shen");
        System.out.println(string);
    }
}
