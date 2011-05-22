
/**
 * ParseExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:18:42 CET)
 */

package fit5030.ass.two.searchclient.webservice;

public class ParseExceptionException extends java.lang.Exception{
    
    private fit5030.ass.two.searchclient.webservice.SimpleAjaxStub.ParseExceptionE faultMessage;

    
        public ParseExceptionException() {
            super("ParseExceptionException");
        }

        public ParseExceptionException(java.lang.String s) {
           super(s);
        }

        public ParseExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ParseExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(fit5030.ass.two.searchclient.webservice.SimpleAjaxStub.ParseExceptionE msg){
       faultMessage = msg;
    }
    
    public fit5030.ass.two.searchclient.webservice.SimpleAjaxStub.ParseExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    