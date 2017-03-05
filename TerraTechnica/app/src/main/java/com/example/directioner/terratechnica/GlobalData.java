package com.example.directioner.terratechnica;

import com.example.directioner.terratechnica.NavDrawer.FAQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Directioner on 2/10/2017.
 */

public class GlobalData {

    public static final String EVENT_NAME = "EventName";
    public static final String EVENT_CATEG = "EventCateg";

    public static final String SERVER_ADDR = "https://reliant-implantatio.000webhostapp.com/";

    public static final List<String> IMAGE_LIST = new ArrayList<>();

    public static final ArrayList<FAQ> FAQ_DATA = new ArrayList<>();

    public static final String ABOUT_US = "Manifesting the opportunities of technology and innovation, " +
            "and prioritising the need to extend the same, the National Institute of Technology Delhi " +
            "inherently presents its first technical festival, the TerraTechnica’17. Conveying the " +
            "sole motivation of continuous and cumulative importance of technology and its attributes " +
            "in the developing scenario of the nation, TerraTechnica’17 tends to strengthen the role " +
            "of engineering applications and its utilisation. The fest renders the bright minds of " +
            "the country an opportunistic potential to evolve their technical skills, combined with " +
            "the notion of emerging at the pole position in the competitive environments. It enunciates " +
            "itself as the learning grounds for proper conceptual vision, developmental ideas, establishing " +
            "a foreground for technical and engineering applications, and their achievability. In addition, " +
            "TerraTechnica’17 also prioritises the absolute growth of the visual modality of the participants " +
            "to intensify the scope of nurturing. An inspiration amalgamating with the spark of an idea " +
            "embarks the inception of the new technology – TerraTechnica’17 (the clique of techies).";

    public static void setImageList() {
        IMAGE_LIST.add("img1.jpg");
        IMAGE_LIST.add("img2.jpg");
        IMAGE_LIST.add("img3.jpg");
        IMAGE_LIST.add("img4.jpg");
        IMAGE_LIST.add("img5.jpg");
        IMAGE_LIST.add("img6.jpg");
        IMAGE_LIST.add("img7.jpg");
    }

    public static void setFAQData() {

        FAQ_DATA.add(new FAQ("Q. When will the registration for the events be opened?",
                "A. Registration link will be active on the website terratechnica.in" +
                        "by 25th February, 2016. Notification on the app will be provided " +
                        "for the same. On spot registrations are subjected to availability " +
                        "of seats for that particular event. Registrations for paradox have " +
                        "already started - logon toparadox.terratechnica.in"));

        FAQ_DATA.add(new FAQ("Q. What all deliverables do we receive after registering?",
                "A. Registration fee is applicable only for participating in the " +
                        "particular event. Also accommodation fee, ID card and entry " +
                        "to the guest lectures is included."));


        FAQ_DATA.add(new FAQ("Q. What kind of accommodation is available?",
                "A. There is separate accommodation for girls and " +
                        "boys. Proper bedding would be provided to all " +
                        "the registered students."));


        FAQ_DATA.add(new FAQ("Q. Are their any arrangements made for food by the organizing committee for the registered students?",
                "A. The students will be provided with coupons for the same on nominal charges."));


        FAQ_DATA.add(new FAQ("Q. Can two participants be from different institutes in team events?",
                "A. Yes, inter-college teams are permitted to participate in team events. " +
                        "But the teams have to register together while paying the registration fee."));


        FAQ_DATA.add(new FAQ("Q. Is there any provision for on-spot registration?",
                "A. On spot registrations for all formal events are subjected " +
                        "to the availability of seats."));


        FAQ_DATA.add(new FAQ("Q. What are the DON'Ts during the time of fest?",
                "A. No means to destroy the college property.No abusive " +
                        "substance is allowed."));

    }
}