
package org.hy.commons.web.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ToOut", targetNamespace = "http://webservice.web.commons.hy.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ToOut {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "say", targetNamespace = "http://webservice.web.commons.hy.org/", className = "org.hy.commons.web.webservice.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://webservice.web.commons.hy.org/", className = "org.hy.commons.web.webservice.SayResponse")
    public String say(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
