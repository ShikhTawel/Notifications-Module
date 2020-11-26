package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class NotificationTemplate implements Serializable {
    private String subject;
    private String content;
    private TreeSet<Language> availableLanguages;
    private ArrayList<Integer> placeholdersStartingIndexes;
    private ArrayList<Integer> placeholdersEndingIndexes;
    private TreeSet<Channel> availableChannels;

    public NotificationTemplate(String subject) {
        this.subject = subject;
        availableLanguages = new TreeSet<>();
        placeholdersStartingIndexes = new ArrayList<>();
        placeholdersEndingIndexes = new ArrayList<>();
        availableChannels = new TreeSet<>();
    }

    public boolean editContent(String content) {
        this.content = content;
        placeholdersStartingIndexes.clear();
        placeholdersEndingIndexes.clear();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '{') {
                placeholdersStartingIndexes.add(i);
                for (int j = i + 1; j < content.length(); j++) {
                    if (content.charAt(j) == '}') {
                        placeholdersEndingIndexes.add(j);
                        i = j;
                        break;
                    }
                }
            }
        }
        if (placeholdersStartingIndexes.size() != placeholdersEndingIndexes.size()) {
            placeholdersStartingIndexes.clear();
            placeholdersEndingIndexes.clear();
            this.content = "";
            return false;
        }
        return true;
    }

    public void addAvailableLanguage(Language language) {
        availableLanguages.add(language);
    }

    public void addAvailableChannel(Channel channel) {
        availableChannels.add(channel);
    }

    @Override
    public String toString() {
        return "NotificationTemplate{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", availableLanguages=" + availableLanguages +
                ", placeholdersStartingIndexes=" + placeholdersStartingIndexes +
                ", placeholdersEndingIndexes=" + placeholdersEndingIndexes +
                ", availableChannels=" + availableChannels +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public TreeSet<Language> getAvailableLanguages() {
        return availableLanguages;
    }

    public ArrayList<Integer> getPlaceholdersStartingIndexes() {
        return placeholdersStartingIndexes;
    }

    public ArrayList<Integer> getPlaceholdersEndingIndexes() {
        return placeholdersEndingIndexes;
    }

    public TreeSet<Channel> getAvailableChannels() {
        return availableChannels;
    }
}



