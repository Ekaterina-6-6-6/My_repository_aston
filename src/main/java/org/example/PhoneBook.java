package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> contacts = new HashMap<>();

    public void add(String surname, String phone) {
        contacts
                .computeIfAbsent(surname, k -> new ArrayList<>())
                .add(phone);
    }

    public void get(String surname) {
        List<String> phones = contacts.get(surname);

        if (phones == null) {
            System.out.println("Фамилия " + surname + " не найдена.");
        } else {
            for (String phone : phones) {
                System.out.println(phone);
            }
        }
    }
}