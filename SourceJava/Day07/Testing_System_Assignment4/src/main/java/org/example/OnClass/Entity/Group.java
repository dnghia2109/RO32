package org.example.OnClass.Entity;

import org.example.Entity.Account;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Group {
    public int id;
    public String name;
    public Account creator;
    public LocalDate createDate;
    public Account[] accounts;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
