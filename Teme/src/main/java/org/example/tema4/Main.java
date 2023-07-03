package org.example.tema4;

        public class Main {

        public static void main(String[] args){
            Phone phone1 = new SamsungS23("black", "plastic",100);
            phone1.addContact(1, "0774223344", "Ana", "Stefania");
            phone1.addContact(2, "0745774433", "Alin", "Georgescu");
            phone1.listContacts();

            phone1.sendMessage("0774223344", "Salut !");
            phone1.sendMessage("0774223344", "Ce faci astazi ?");
            phone1.listMessages();
            phone1.call("0745774433");
            phone1.call("0774223344");
            phone1.viewHistory();
            phone1.showbatteryLife();
            System.out.println("  ");


            Phone phone2 = new Iphone14ProMax("silver","aluminium",80);
            phone2.addContact(1, "0724667788", "Amber", "Adams");
            phone2.addContact(2, "0726224466", "Michael", "Harrison");
            phone2.listContacts();

            phone2.sendMessage("0726224466", "What are you doing today ?");
            phone2.listMessages();
            phone2.call("0724667788");
            phone2.viewHistory();
            phone2.showbatteryLife();
            System.out.println("  ");


            Phone phone3 = new SamsungNote23("white","glass",60);
            phone3.addContact(1, "0755234890", "Antonella", "Rossi");
            phone3.addContact(2, "0724444676", "Piero", "Moretti");
            phone3.listContacts();

            phone3.sendMessage("0755234890", "Ciao!");
            phone3.sendMessage("0724444676", "Cosa stai facendo oggi ?");
            phone3.listMessages();
            phone3.call("0724444676");
            phone3.viewHistory();
            phone3.showbatteryLife();
            System.out.println("  ");


            Phone phone4 = new Iphone14("blue","aluminium",60);
            phone4.addContact(1, "0754677788", "Jolie", "Martinez");
            phone4.addContact(2, "0711333256", "Nicole", "Perez");
            phone4.addContact(2, "0743543543", "Simon", "Leclerc");
            phone4.listContacts();

            phone4.sendMessage("0711333256", "Que fais-tu aujourd'hui ?");
            phone4.listMessages();
            phone4.call("0754677788");
            phone4.call("0711333256");
            phone4.call("0743543543");
            phone4.viewHistory();
            phone4.showbatteryLife();
            System.out.println("  ");

        }
    }





