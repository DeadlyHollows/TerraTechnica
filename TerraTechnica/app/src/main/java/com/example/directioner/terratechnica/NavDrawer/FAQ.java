package com.example.directioner.terratechnica.NavDrawer;

/**
 * Created by Directioner on 2/11/2017.
 */

public class FAQ {

    private String ques;
    private String ans;

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public FAQ(String ques, String ans) {
        this.ques = ques;
        this.ans = ans;
    }
}
