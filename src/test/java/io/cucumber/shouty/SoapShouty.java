package io.cucumber.shouty;

import java.util.List;

/**
 * This implementation of ShoutyApi interacts with the Shouty
 * server using SOAP.
 *
 * All methods (except stop) should delegate to a Soap client.
 * The Soap client will be generated from wsdl provided by the
 * server. See `./wsdl2java`
 */
public class SoapShouty implements ShoutyApi {
    @Override
    public void setLocation(String personName, int locationInMetres) {
        throw new UnsupportedOperationException("Write me please");
    }

    @Override
    public void shout(String shouterName, String message) {
        throw new UnsupportedOperationException("Write me please");
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        throw new UnsupportedOperationException("Write me please");
    }

    @Override
    public void stop() {
        // No need to implement this
    }
}
