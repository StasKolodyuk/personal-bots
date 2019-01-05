package by.kolodyuk.bots.common;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class KeyWordBot implements Bot {

    public abstract List<String> getAcceptedKeyWords();

    @Override
    public boolean accept(String command) {
        return getAcceptedKeyWords().stream()
                                    .anyMatch(keyWord -> StringUtils.containsIgnoreCase(command, keyWord));
    }
}
