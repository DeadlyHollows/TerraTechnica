package com.example.directioner.terratechnica.Sponsors;

/**
 * Created by Directioner on 1/28/2017.
 */

public class SponsorData {

    private String spName;
    private String spCateg;  // Based on the level of support!

    // The Logo of the sponsores is saved as 'spName.png' !
    private String spLogo;

    public SponsorData() {
    }

    public SponsorData(String name, String categ, String logo) {
        spName = name;
        spCateg = categ;
        spLogo = logo;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpCateg() {
        return spCateg;
    }

    public void setSpCateg(String spCateg) {
        this.spCateg = spCateg;
    }

    public String getSpLogo() {
        return spLogo;
    }

    public void setSpLogo(String spLogo) {
        this.spLogo = spLogo;
    }

}