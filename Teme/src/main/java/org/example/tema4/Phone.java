package org.example.tema4;


import java.util.ArrayList;

public class Phone {
    public String color;
    public String material;
    public int batteryLife;
    private static final int msxSmsChar = 500;
    ArrayList<Contact> contacts = new ArrayList<>();
    ArrayList<Message> messages = new ArrayList<>();
    ArrayList<Call> calls = new ArrayList<>();


    Phone(String color, String material, int batteryLife){
        this.color = color;
        this.material = material;
        this.batteryLife = batteryLife;
    }


    public void addContact(int index, String phoneNumber, String firstName, String lastName){
        Contact contact = new Contact(index, phoneNumber, firstName, lastName);
        contacts.add(contact);
    }

    public void listContacts(){
        for(Contact aux : contacts){
            System.out.println(aux.index + " " + aux.phoneNumber + " " + aux.firstName + " " + aux.lastName);
        }
    }

    void sendMessage(String phoneNumber, String text) {

        batteryLife -= 1;

        if (text.length() < msxSmsChar) {
            System.out.println("Message sent to " + phoneNumber);
            messages.add(new Message(phoneNumber, text));
        } else{
            System.out.println("The message is too long");
           }
    }
    public void listMessages(){
        for(Message aux : messages)
        {
            System.out.println(aux.phoneNumber + " " + aux.message);
        }
    }

    public void call(String phoneNumber) {
        batteryLife = batteryLife - 2;
        calls.add(new Call(phoneNumber));
        System.out.println("I called to " + phoneNumber);

    }

    public void viewHistory(){
        System.out.println("List all calls: ");

        for (Call call : calls) {
            System.out.println(call.phoneNumber);
        }
    }
    public void showbatteryLife(){
        System.out.println("Batterylife: " + batteryLife + "min");
    }



}