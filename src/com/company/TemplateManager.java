package com.company;

import java.io.*;
import java.util.*;

public class TemplateManager {

    ArrayList<NotificationTemplate> templates = new ArrayList<>();
    String filename;

    public TemplateManager(String filename) {
        this.filename = filename;
        FileInputStream file = null;
        try {
            file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            templates = (ArrayList<NotificationTemplate>)in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addTemplate(NotificationTemplate template) {
        templates.add(template);
        updateFile();
    }

    public boolean deleteTemplate(String subject) {
        NotificationTemplate template = null;
        for (int i = 0; i < templates.size(); i++) {
            if (templates.get(i).getSubject().equalsIgnoreCase(subject)) {
                templates.remove(i);
                updateFile();
                return true;
            }
        }
        return false;
    }

    public boolean updateTemplate(String subject, NotificationTemplate updatedTemplate) {
        NotificationTemplate template = null;
        for (int i = 0; i < templates.size(); i++) {
            if (templates.get(i).getSubject().equalsIgnoreCase(subject)) {
                templates.set(i, updatedTemplate);
                updateFile();
                return true;
            }
        }
        return false;
    }

    public NotificationTemplate getTemplate(String subject) {
        NotificationTemplate template = null;
        for (int i = 0; i < templates.size(); i++) {
            if (templates.get(i).getSubject().equalsIgnoreCase(subject)) {
                return templates.get(i);
            }
        }
        return null;
    }

    public ArrayList<NotificationTemplate> getAllTemplates() {
        return templates;
    }

    public void updateFile() {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(templates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
