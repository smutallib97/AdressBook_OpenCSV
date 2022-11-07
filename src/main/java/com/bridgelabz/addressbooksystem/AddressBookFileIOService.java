package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIOService {
    private static final String HOME ="F:\\BridgeLabz\\LFP - 202\\JAVA Stream IO\\AddressBookIO\\src\\main\\resources\\";

    public void writeData(List<Contact> contactList , String addressBookName) {
        StringBuffer personBuffer = new StringBuffer();
        contactList.forEach( person-> {
            String contactDataString = person.toString().concat("\n");
            personBuffer.append(contactDataString);

        });
        try {
            Files.write(Paths.get(HOME+addressBookName + ".txt"),personBuffer.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Contact> readData (){
        List<Contact> contactPersonList = new ArrayList<>();
        try {
            Files.lines(new File(HOME+"Contact.txt").toPath())
                    .map(line -> line.trim())
                    .forEach(line->System.out.println(line));
        }catch (IOException e){
            e.printStackTrace();
        }
        return contactPersonList;
    }
    public void printData(){
        try {
            Files.lines(new File(HOME+"Contact.txt").toPath())
                    .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
