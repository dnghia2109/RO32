package org.example.OnClass.Entity.Entity_Ex6;

import java.util.ArrayList;

public abstract class Phone {
    protected ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public abstract void insertContact(String name, String phone);

    public abstract void removeContact(String name);
    public abstract void updateContact(String name, String newPhone);
    public abstract void searchContact(String name);
}
