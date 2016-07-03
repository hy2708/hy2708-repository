
package org.hy.commons.web.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ToOutService", targetNamespace = "http://webservice.web.commons.hy.org/", wsdlLocation = "http://localhost:7777/xxx?wsdl")
public class ToOutService
    extends Service
{

    private final static URL TOOUTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.hy.commons.web.webservice.ToOutService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.hy.commons.web.webservice.ToOutService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:7777/xxx?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:7777/xxx?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        TOOUTSERVICE_WSDL_LOCATION = url;
    }

    public ToOutService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ToOutService() {
        super(TOOUTSERVICE_WSDL_LOCATION, new QName("http://webservice.web.commons.hy.org/", "ToOutService"));
    }

    /**
     * 
     * @return
     *     returns ToOut
     */
    @WebEndpoint(name = "ToOutPort")
    public ToOut getToOutPort() {
        return super.getPort(new QName("http://webservice.web.commons.hy.org/", "ToOutPort"), ToOut.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ToOut
     */
    @WebEndpoint(name = "ToOutPort")
    public ToOut getToOutPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.web.commons.hy.org/", "ToOutPort"), ToOut.class, features);
    }

}
