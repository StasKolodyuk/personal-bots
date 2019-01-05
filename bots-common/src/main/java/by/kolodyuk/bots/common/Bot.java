package by.kolodyuk.bots.common;

public interface Bot {

    boolean accept(String command);
    String reply(String command);
}
