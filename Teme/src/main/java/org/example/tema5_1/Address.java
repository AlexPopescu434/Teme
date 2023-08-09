package org.example.tema5_1;

public class Address {
    public String street;

    public String city;
    public Country country;

    public Address(String street,String city, Country country) {
        this.street = street;
        this.country=country;
        this.city=city;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}



