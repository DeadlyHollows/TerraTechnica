package com.example.directioner.terratechnica.EventCateg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Directioner on 2/12/2017.
 */

public class EventsDataManager {

    public static List<EventDetails> codeDataManager = new ArrayList<>();
    public static List<EventDetails> botDataManager = new ArrayList<>();
    public static List<EventDetails> workshopDataManager = new ArrayList<>();
    public static List<EventDetails> miscDataManager = new ArrayList<>();

    private static boolean set = false;

    public static void setEventsData() {

        // **********************************   Setting data for codeconnect events ...  **********************************

        codeDataManager.add(new EventDetails("NITD PROGRAMMING LEAGUE", "AUDITORIUM", "14:00-15:00", 1, "nitd_pl",

                        "\"Talk is cheap. Show me the code.\"\nLinus Torvalds minced no words while he made that statement. For " +
                        "those who think themselves as the problem solvers and all the code freaks out there, Terra " +
                        "Technica&apos;17 is back with a platform for you to prove your mettle. This could be the " +
                        "event that gives you that confidence  to code which could change your life forever.",

                        "This is a competitive programming event. There will be a set of questions, and participants " +
                        "will be required to write programs to solve them (in C, C++ or Java), which will be " +
                        "judged by an online judge. The team which solves the maximum number of questions in " +
                        "least time will be declared as the winner.",

                        "1.) This is a team event. There can be 1-3 members in a team.\n" +
                        "2.) Your team will be required to write programs to solve the given problems, " +
                        "which will then have to be submitted to an online judge.\n" +
                        "3.) Your programs can be written in one of either C, C++ or Java language.\n" +
                        "4.) There will be a runtime limit for each problem. Your solution should pass " +
                        "all the hidden test data within that time limit to receive the accepted verdict.\n" +
                        "5.) The winner will be declared on the basis of number of questions solved. If " +
                        "number of questions solved is same, the winner will be the team who solves the " +
                        "problems in least amount of time.\n" +
                        "6.) There will be a time penalty for each wrong submission to the online judge, " +
                        "but not for compilation error.\n" +
                        "7.) Team will have no access to cellphones.\n" +
                        "8.) Taking help of any kind will result in immediate disqualification.\n"));


        /*******************************************************************************************************************/

        codeDataManager.add(new EventDetails("REVERSE CODING", "AUDITORIUM", "14:00-15:00", 1, "rev_code",

                        "Think you know everything about programming? Well there are many ways to go, let’s see " +
                        "which one you pick. This event looks for the real star that stands up to the " +
                        "ability of creativity and logic. So, be ready to storm out not just by switching " +
                        "systems but switching your brains into the all new arena.",

                        "The difference between general competitive programming competition and reverse coding is " +
                        "that you will not be given the exact question statement but you will be provided " +
                        "with some set of sample inputs and outputs which will be sufficient enough to guess " +
                        "the problem and then you have to submit a code for your guessed problem. Interesting... right?",


                        "1.) This is a team event. There can be 1-3 members in a team.\n" +
                        "2.) Your team will be required to guess the problem with help of given input and output set and write " +
                        "program to solve the problems, which will then have to be submitted to an online judge.\n" +
                        "3.) Your programs can be written in one of either C, C++ or Java language.\n" +
                        "4.) There will be a runtime limit for each problem. Your solution should pass all the " +
                            "hidden test data within that time limit to receive the accepted verdict.\n" +
                        "5.) The winner will be declared on the basis of number of questions solved. If number of " +
                            "questions solved is same, the winner will be the team who solves the problems in " +
                            "least amount of time.\n" +
                        "6.) There will be a time penalty for each wrong submission to the online judge, but not " +
                            "for compilation error. "));

        /*******************************************************************************************************************/

        codeDataManager.add(new EventDetails("CLASH OF CODES", "AUDITORIUM", "14:00-15:00", 2, "coc",

                "Outwit, outplay, outlast\n" +
                "Get ready for your chance to glory, where you would have to unleash your coding skills but, " +
                        "you would win only if you outlast your competitors.\n" +
                "It’s an opportunity to boast your coding skills, but you can’t entirely rely on them…..\n" +
                "May the odds always be in your favour.\n",

                "COC!",

                "1.) Single person entry is allowed.\n" +
                "2.) Participants will be asked to submit one player code for a given game.\n" +
                "3.) Before 7 days of the starting of fest one online portal will be opened where " +
                "participants will improve their algorithm by playing with other’s code.\n" +
                "4.) On the day of event, there will be offline knock out matches.\n" +
                "5.) The one who will win the final knock-out match will be the winner.\n" +
                "6.) Rest will be notified on online portal.\n"));

        /*******************************************************************************************************************/

        codeDataManager.add(new EventDetails("HACKATHON", "AUDITORIUM", "14:00-15:00", 2, "hackathon",

                "Hackathon is an onsite mobile app building competition where we give you an opportunity \n" +
                "to design and develop your own mobile or even web app, show off your skills to win the\n" +
                        " battle and be the master of web world.",

                "Your team will be required to build an app from scratch, based on the given theme.\n" +
                        " With two days to make it, you and your team can code all day and seek learning\n" +
                        " resources as well, so participate whether or not you know how to make an app\n" +
                        " or not. The submissions will then be judged on a number of criteria and\n" +
                        " the best will be declared the winner.",

                "1.)This is a team event. There can be 1-5 members in a team.\n" +
                        "2.)Your team will be required to create an application.\n" +
                        "3.)The app can be for any platform, or even a web app. The only requirement is that it should be " +
                        "mobile compatible.\n" +
                        "4.)Hackathon will be a two day event, during which you can code your app. It is to be built from scratch," +
                        " but you can use free libraries in your code.\n" +
                        "5.)Your submissions will be judged on a number of criteria, and the best will be chosen as the winner."));

        codeDataManager.add(new EventDetails("Capture The Flag", "____", "__:__:__", 1, "",
                "This is a new event which is unlikely found in tech-fest of other institutes. " +
                        "We are hosting this event to lure Computer Science enthusiast to apply " +
                        "their skills in Cybersecurity, Networking, Crypto-analysis. This event " +
                        "is a time-trial game played in teams, competing against one another for " +
                        "the prize.",
                "CTF \n\u200B\n is an event which provides a platform for participants to work out " +
                        "on real world scenarios like \u200Bmalware analysis \u200B¸\u200Bpentesting " +
                        ", system administration.\u200B The game is played in team of four players." +
                        "1.) Each team is provided with a real world scenario along with an system " +
                        "where they need to seek out a solution which promotes next level.\n2.) Each level " +
                        "is associated with different kind of scenario of increasing difficulty. This " +
                        "allows the participants to apply various concepts and techniques to reach a " +
                        "solution.\n3.)The game is entirely based on Command line interface. The team is " +
                        "given secured access to a \n" +
                        "system to analyze, execute instructions to find the flag. " +
                        "The games assumes players to have knowledge in computer engineering such as files, " +
                        "networking, various tools of system administration. The game duration is estimated " +
                        "to be around 5hrs. Entry is free and total prize of INR 50,000 ",
                ""));

        /*******************************************************************************************************************/

        // **********************************   Setting data for botmania events ...   **********************************

        botDataManager.add(new EventDetails("DEATH RACE", "AUDITORIUM", "14:00-15:00", 1, "death_race",

                "For all RC car lovers, we provide a big platform to prove themselves champion amongst best RC Car drivers.\n" +
                        " If you love RC cars and have excellence in driving cars then drive through the toughest \n" +
                        "path filled up by high bumps, sharpest turns and high ramps to fly you in air and grab huge prizes.",

                "Problem Statement is simple. You have to design a R/C (radio controlled) car with given technical specifications \n" +
                        "and drive it on a track full of obstacles and traps.",

                "1.) This is an individual event.\n" +
                        "2.) Limited car size(decided based on dimensions of track)\n" +
                        "3.) Cars can have weapon like mechanisms to hit or push other cars like high torqued industrial motors," +
                        " protective armour sheets etc.\n" +
                        "4.) Participants can hit each other's cars. They can push opponent's car into trap while avoiding it themselves.\n" +
                        "5.) Decisions taken are final and any complaints will not be entertained."));

        /*******************************************************************************************************************/

        botDataManager.add(new EventDetails("CODEMS", "AUDITORIUM", "14:00-15:00", 2, "codems",

                "Have always been dwelling over the complexity of circuits and computer programs? Catch the current, vanquish\n" +
                        " the voltage. Walk through the chaos of electrical sophistication, coding skills and emerge as the winner.\n" +
                        " Solve the toughest circuits and come up with their practicality. Invoke, implement, innovate, initialise.\n" +
                        " It’s never always been the Transformers – CodEmb",

                "Participants individually compete in two different rounds of the challenge. In each round, participants\n" +
                        " are assigned an embedded task. Participants need to bring their own Atmel series (only) microcontroller\n" +
                        " and related hardware or an Arduino development board and code in the Arduino IDE (only). Participants \n" +
                        "are provided the required hardware to implement the specified task in each round (except the \n" +
                        "microcontroller and related hardware).",

                "1.) Participants are not allowed to use libraries other than those that are in-built in the Arduino IDE.\n" +
                        "2.) He/she will get a position on the ranking table only when the code successfully gets implemented on the hardware.\n" +
                        "3.) The rank will be queued based on the timestamp provided to the participants.\n" +
                        "4.) The participant has to explain his/her code if asked for and go through different test cases if needed.\n" +
                        "5.) Team will have no access to cellphones.\n" +
                        "6.) Taking help of any kind will result in immediate disqualification."));

        /*******************************************************************************************************************/

        // **********************************   Setting data for workshops events ...   **********************************

        workshopDataManager.add(new EventDetails("DESIGN CUT", "AUDITORIUM", "14:00-15:00", 1, "design_cut",
                "INTRO",

                "A workshop organised by Design Cut exclusively at NITD :)",

                "RULES"));

        /*******************************************************************************************************************/

        // **********************************   Setting data for informals events ...   **********************************

        miscDataManager.add(new EventDetails("UNTANGLE THE TANGLE", "AUDITORIUM", "14:00-15:00", 2, "untangle",

                "Whizzing through the land of maths and science , this event will take you through the world\n" +
                        " of deciphers, while testing your basic fundamental maths and science skills every step of the way.",

                "Untangle the tangle is a quirky sudoko puzzle where the participants have to put a digit from\n" +
                        " 1 to N in each cell of the grid so that every row, column, bold region contains each digit once,\n" +
                        " where N is the number of rows and columns in the puzzle. But here is the catch; to unveil the\n" +
                        "first few numbers the participants are required to answer some of the technical questions which\n" +
                        "would lead them to a number. The numbers thus obtained needs to be added to the cells and\n" +
                        " consequently the sudoko has to be solved.",

                "1.) Remote participation is not allowed. Student have to be present at the venue.\n" +
                        "2.) This is an individual event.\n" +
                        "3.) Duration of the event is 90 minutes.\n" +
                        "4.) Participant who will solve the Sudoko in minimum time will win the event.\n" +
                        "5.) Students are required to come with their own laptop and charger.\n" +
                        "6.) Leaderboard will be displayed on the website after completion of event."));


    }

    public static List<EventDetails> dataFetch(String categ) {

        if (!set) {
            setEventsData();
            set = true;
        }

        switch (categ) {
            case "code":
                return codeDataManager;
            case "bot":
                return botDataManager;
            case "workshop":
                return workshopDataManager;
            case "misc":
                return miscDataManager;
        }

        return null;
    }
}