package com.example.bas.Service.User;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class Contact {

    public Contact() {
        contactList.add("Navn: Alex Vinløv");
        contactList.add("Mobilnummer: +4552241470");
        contactList.add("Mail: alexvinloev95@outlook.com");
        contactList.add("Adresse: Nordre Fuglsangsvej 5, st, tv 4270 Høng ");
    }

    ArrayList<String> contactList = new ArrayList<>();

    public ArrayList<String> getContact() {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(0).equals("Navn: Alex Vinløv") && contactList.get(1).equals("Mobilnummer: +4552241470"))
                return contactList;
            }
        return null;
        }
    }
