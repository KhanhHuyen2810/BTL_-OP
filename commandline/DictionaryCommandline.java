package commandline;

import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement show = new DictionaryManagement();
    
    public void showAllWords() {
        // show.showWords();
        show.showWordsFile();
    }

    public void dictionaryBasic() {
        // show.insertFromCommandline();
        // show.insertFromFile();
        // show.dictionaryLookup();
        // show.dictionarySearcher();
        // show.dictionaryReplace();
        // show.dictionaryAdd();
        // showAllWords();
        // show.dictionaryExportToFile();
        show.Game();
    }

    public void dictionaryAdvanced() {
        System.out.print("Welcome to My Application!" + "\n" 
        + "[0] Exit" + "\n"
        + "[1] Add" + "\n"
        + "[2] Remove" + "\n"
        + "[3] Update" + "\n"
        + "[4] Display" + "\n"
        + "[5] Lookup" + "\n"
        + "[6] Search" + "\n"
        + "[7] Game" + "\n"
        + "[8] Import from file" + "\n"
        + "[9] Export to file" + "\n"
        + "Your action: ");

        Scanner sc = new Scanner(System.in);
        int number;
        
        while((number = sc.nextInt()) != 0) {
            if (number == 0) {
                System.exit(1);
                break;
            } else if (number == 1) {
                show.dictionaryAdd();
            } else if (number == 2) {
                show.dictionaryRemove();
            } else if (number == 3) {
                show.dictionaryReplace();
            } else if (number ==4 ) {
                show.showWordsFile();
            } else if (number == 5) {
//                show.dictionaryLookup();
            } else if (number == 6) {
                show.dictionarySearcher();
            } else if (number == 7) {
                show.Game();
            } else if (number == 8) {
                show.insertFromFile();
            } else if (number == 9) {
                show.dictionaryExportToFile();
            } else {
                System.out.println("Action not supported");
            }
        }
        sc.close();
    }
}