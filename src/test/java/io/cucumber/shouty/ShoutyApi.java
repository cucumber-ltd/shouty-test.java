package io.cucumber.shouty;

import java.util.List;

/**
 * This interface represents the interactions a Shouty client
 * can perform. It is used directly by {@link ShoutSteps}
 */
public interface ShoutyApi {
    void setLocation(String personName, int locationInMetres);

    void shout(String shouterName, String message);

    List<String> getMessagesHeardBy(String personName);

    void stop();
}
