package org.example.tema5_1;

import java.util.ArrayList;
import java.util.List;

public class Hobby {

    final String hobbyName;
    final Integer frequency;
    public List<Address> addressList = new ArrayList<Address>();

    public Hobby(String hobbyName, int frequency, List<Address> addressList) {
        this.hobbyName= hobbyName;
        this.frequency = frequency;
        this.addressList = addressList;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> adressList) {
        this.addressList = adressList;
    }

    public String toString(){
        return hobbyName;
    }

}