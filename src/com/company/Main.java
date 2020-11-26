package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option;
        TemplateManager templateManager = new TemplateManager("database.txt");

        while (true) {
            System.out.println("1- Show All Templates" +
                    "\n2- Add Template" +
                    "\n3- Remove Template" +
                    "\n4- Show Template" +
                    "\n5- Update Template" +
                    "\n6- Exit");
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            in.skip("\n");
            if (option == 1) {
                ArrayList<NotificationTemplate> templates = templateManager.getAllTemplates();
                for (NotificationTemplate template : templates) {
                    System.out.println(template.toString());
                }
            } else if (option == 2) {
                System.out.println("Enter Subject:");
                String subject = in.nextLine();
                System.out.println("Enter Content: ");
                String content = in.nextLine();
                NotificationTemplate template = new NotificationTemplate(subject);
                template.editContent(content);
                templateManager.addTemplate(template);
            } else if (option == 3) {
                System.out.println("Enter template Subject: ");
                String subject = in.nextLine();
                templateManager.deleteTemplate(subject);
            } else if (option == 4) {
                System.out.println("Enter template Subject: ");
                String subject = in.nextLine();
                System.out.println(templateManager.getTemplate(subject).toString());
            } else if (option == 5) {
                System.out.println("Enter template current Subject: ");
                String subject = in.nextLine();
                System.out.println("Enter new Subject:");
                String newSubject = in.nextLine();
                System.out.println("Enter new Content: ");
                String content = in.nextLine();
                NotificationTemplate template = new NotificationTemplate(newSubject);
                template.editContent(content);
                templateManager.updateTemplate(subject, template);
            } else if (option == 6) {
                break;
            }
        }
    }
}
