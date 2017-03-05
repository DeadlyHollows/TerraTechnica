package com.example.directioner.terratechnica.Organizers;

/**
 * Created by Directioner on 1/28/2017.
 */

public class ContactsData {

    private String personName;
    private String personContactNo;
    private String personImage;
    private String personSupportLevel;

    private String position; // The level of support they are providing!

    public ContactsData() {
    }

    public ContactsData(String name, String contactNo, String image, String supportLevel) {
        personName = name;
        personContactNo = contactNo;
        personImage = image;
        personSupportLevel = supportLevel;
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonContactNo() {
        return personContactNo;
    }

    public void setPersonContactNo(String personContactNo) {
        this.personContactNo = personContactNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPersonImage() {
        return personImage;
    }

    public void setPersonImage(String personImage) {
        this.personImage = personImage;
    }

    public String getPersonSupportLevel() {
        return personSupportLevel;
    }

    public void setPersonSupportLevel(String personSupportLevel) {
        this.personSupportLevel = personSupportLevel;
    }
}