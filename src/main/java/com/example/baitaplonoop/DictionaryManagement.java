package com.example.baitaplonoop;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.TreeMap;

public class DictionaryManagement {

    Dictionary dictionaryList = new Dictionary();

    Dictionary dictionaryFile = new Dictionary();

    public int count;

    public int countQuestion;

    Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    int n = 0;
    // String s = sc.nextLine();
    String s = "";

    public void BubbleSort(Dictionary d, int m) {
        for (int i = 0; i < m - 1; i++)
            for (int j = 0; j < m - i - 1; j++) {
                if (d.dictionary[j].getWordtarget().compareTo(d.dictionary[j+1].getWordtarget()) > 0) {
                    String temp1 = d.dictionary[j].getWordtarget();
                    d.dictionary[j].setWordtarget(d.dictionary[j+1].getWordtarget());
                    d.dictionary[j+1].setWordtarget(temp1);

                    String temp2 = d.dictionary[j].getWordexplain();
                    d.dictionary[j].setWordexplain(d.dictionary[j+1].getWordexplain());
                    d.dictionary[j+1].setWordexplain(temp2);
                    // System.out.println(d.dictionary[j].getWordtarget() + " " + d.dictionary[j+1].getWordtarget());
                }
        }
    }
    
    public void insertFromCommandline() {
        dictionaryList.dictionary = new Word[n];
    
        for(int i=0; i<n; i++) {
            dictionaryList.dictionary[i] = new Word();
            String english = sc.nextLine();
            String vietnamese = sc.nextLine();
            dictionaryList.dictionary[i].setWordtarget(english);
            dictionaryList.dictionary[i].setWordexplain(vietnamese);
        }
        BubbleSort(dictionaryList, n);

        sc.close();
    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);  
    }

    public static String padRightInt(int s, int n) {
        return String.format("%-" + n + "s", s);  
    }

    public void showWords() {
        System.out.println(padRight("No", 10) + padRight("|", 10) + padRight("English", 17) + padRight("|", 10) + "Vietnamese");
        for(int i = 0; i < n; i++){
            System.out.println(padRightInt(i+1, 10) + padRight("|", 10) + padRight(dictionaryList.dictionary[i].getWordtarget(), 10) + padRight("|", 10)  + dictionaryList.dictionary[i].getWordexplain());
        }
    }

    public void insertFromFile() {
        try {
            BufferedReader readbuffer = new BufferedReader(new FileReader("/Users/quanganh/Documents/BaiTapLonOOP/src/main/java/com/example/baitaplonoop/dictionaries.txt"));
            ArrayList<String> list = new ArrayList<String>();
            String strRead = "";
            String tmp = "";
            while(true) {
                strRead = readbuffer.readLine();
                //System.out.println(strRead);
                if (strRead == null) {
                    break;
                } else {
                    if (strRead.contains("@")) {
                        //System.out.println(strRead);

                        list.add(tmp);
                        //System.out.println(tmp);
                        int pos = -1;
                        if (strRead.contains(" /")) {
                            pos = strRead.indexOf(" /") + 1;
                        }
                        //System.out.println(strRead.substring(1,pos-1));

                        if (pos >= 0) {
                            list.add(strRead.substring(1, pos));
                            tmp = strRead.substring(pos);
                        } else {
                            list.add(strRead.substring(1));
                            tmp = "";
                        }
                    } else {
                        tmp += "\n" + strRead;
                    }
                }
            }
            count = 0;
            dictionaryFile.dictionary = new Word[list.size() / 2];
            for (int j = 1; j < list.size() - 1; j = j + 2) {
                dictionaryFile.dictionary[count] = new Word();
                dictionaryFile.dictionary[count].setWordtarget(list.get(j).trim());
                dictionaryFile.dictionary[count].setWordexplain(list.get(j+1));
                count++;
            }

            readbuffer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void showWordsFile() {
        System.out.println(padRight("No", 10) + padRight("|", 10) + padRight("English", 17) + padRight("|", 10) + "Vietnamese");
        for(int i = 0; i < count; i++){
            System.out.println(padRightInt(i+1, 10) + padRight("|", 10) + padRight(dictionaryFile.dictionary[i].getWordtarget(), 60) + padRight("|", 10)  + dictionaryFile.dictionary[i].getWordexplain());
        }
    }

    public void dictionaryLookup() {
        System.out.print("\nType word to look up: ");
        String wordLookup = sc.nextLine();
        System.out.print("\nMeaning: ");
        for (int i = 0; i < count; i++) {
            if (wordLookup.equals(dictionaryFile.dictionary[i].getWordtarget())) {
                System.out.println(dictionaryFile.dictionary[i].getWordexplain());
            }
        }
    }

//    public String dictionaryLookupScene(String wordLookup) {
//        System.out.print("\nType word to look up: " + wordLookup);
//        String s = "";
//        System.out.print("\nMeaning: ");
//        for (int i = 0; i < count; i++) {
//            if (wordLookup.equals(dictionaryFile.dictionary[i].getWordtarget())) {
//                s = s + "\n" +  dictionaryFile.dictionary[i].getWordexplain();
//            }
//        }
//        return s;
//    }

    public String dictionaryLookupScene(String wordLookup) {
        wordLookup = wordLookup.trim();
        System.out.print("\nType word to look up: " + wordLookup);
        String s = "";
        System.out.print("\nMeaning: ");
        for (int i = 0; i < count; i++) {
            if (wordLookup.equals(dictionaryFile.dictionary[i].getWordtarget())) {
                s = s + "\n" +  dictionaryFile.dictionary[i].getWordexplain();
            }
        }
        return s;
    }

    public void dictionarySearcher() {
        System.out.print("\nType word to search: ");
        String wordSearch = sc.nextLine();
        System.out.print("\nSuggested words: ");
         for (int i = 0; i < count; i++) {
            if(dictionaryFile.dictionary[i].getWordtarget().contains(wordSearch) == true) {
                System.out.println(dictionaryFile.dictionary[i].getWordtarget());
            }
        }
    }

    public ArrayList<String> dictionarySearcherScene(String word) {
        word = word.trim();
        ArrayList<String> wordsSearch = new ArrayList<>();
        System.out.print("\nType word to search: " + word);

        System.out.print("\nSuggested words: ");
        for (int i = 0; i < count; i++) {
            if(dictionaryFile.dictionary[i].getWordtarget().contains(word) == true) {
                wordsSearch.add(dictionaryFile.dictionary[i].getWordtarget());
            }
        }
        return wordsSearch;
    }

    public void dictionaryAdd() {
        System.out.print("\nType word to add: ");
        String wordAddtarget = sc.nextLine();
        System.out.print("\nType meaning of word: ");
        String wordAddexplain = sc.nextLine();
        dictionaryFile.dictionary[count] = new Word();
        dictionaryFile.dictionary[count].setWordtarget(wordAddtarget);
        dictionaryFile.dictionary[count].setWordexplain(wordAddexplain);
        count = count + 1;
        BubbleSort(dictionaryFile, count);
    }

    public void dictionaryRemove() {
        System.out.print("\nType word to remove: ");
        String wordRemovetarget = sc.nextLine();
        int pos = -1;
        for(int i=0; i<count; i++) {
            if(wordRemovetarget.equals(dictionaryFile.dictionary[i].getWordtarget())){
                pos = i;
                break;
            }
        }
        if (pos != -1 ) {
            for(int i = pos; i<count-1; i++){
                dictionaryFile.dictionary[i].setWordtarget(dictionaryFile.dictionary[i+1].getWordtarget());
                dictionaryFile.dictionary[i].setWordexplain(dictionaryFile.dictionary[i+1].getWordexplain());
            }

            dictionaryFile.dictionary[count-1].setWordtarget(null);
            dictionaryFile.dictionary[count-1].setWordexplain(null);
            count = count - 1;
        }
    }

    public void dictionaryReplace() {
        System.out.print("\nType word to replace: ");
        String wordtarget = sc.nextLine();
        System.out.print("\nType replacement word: ");
        String wordReplacetarget = sc.nextLine();
        System.out.print("\nType replacement meaning of word: ");
        String wordReplaceexplain = sc.nextLine();

        for(int i = 0; i < count; i++) {
            if(wordtarget.equals(dictionaryFile.dictionary[i].getWordtarget())){
                dictionaryFile.dictionary[i].setWordtarget(wordReplacetarget);
                dictionaryFile.dictionary[i].setWordexplain(wordReplaceexplain);
            }
        }
    }

    public void dictionaryExportToFile() {
        try {
            String file = "/Users/quanganh/Documents/BaiTapLonOOP/src/main/java/com/example/baitaplonoop/output.txt";
            OutputStream outputstream = new FileOutputStream(file);
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
            bufferedwriter.write(padRight("No", 10) + padRight("|", 15) + padRight("English", 55) + padRight("|", 15) + "Vietnamese" + "\n");
            for (int i=0; i < count; i++) {
                bufferedwriter.write(padRightInt(i+1, 10) + padRight("|", 10) + padRight(dictionaryFile.dictionary[i].getWordtarget(), 60) + padRight("|", 10)  + dictionaryFile.dictionary[i].getWordexplain() + "\n");
            }
            bufferedwriter.flush();
            bufferedwriter.close();
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }

    public void Game() {
        String file = "/Users/quanganh/Documents/BaiTapLonOOP/src/main/java/com/example/baitaplonoop/question.txt";
        dictionaryFile.game = new Game[100000];
        FileInputStream fileinput = null;
        BufferedReader bufferedReader = null;
        try {
            fileinput = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(fileinput));
            String line1 = " ";
            String line2 = " ";
            String line3 = " ";
            String line4 = " ";
            String line5 = " ";
            String line6 = " ";
            count = 0;
            while((line1 = bufferedReader.readLine()) != null) {
                line2 = bufferedReader.readLine();
                line3 = bufferedReader.readLine();
                line4 = bufferedReader.readLine();
                line5 = bufferedReader.readLine();
                line6 = bufferedReader.readLine();
                line1 = line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 +"\n";

                dictionaryFile.game[countQuestion] = new Game();
                dictionaryFile.game[countQuestion].setQuestion(line1);
                dictionaryFile.game[countQuestion].setAnswer(line6);
                countQuestion++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("khong tim thay file");
        } catch (IOException ex) {
            System.out.println("Loi nhap ten file");
        }

        System.out.print("\nChoose number: 1 2 3 4" + "\n"  + "Click 0 to exit game" + "\n" + "Your choice: ");
        int choice;
        while((choice = sc.nextInt()) != 0) {
            choice = choice - 1;

            System.out.println("\n" + dictionaryFile.game[choice].getQuestion());
            System.out.print("Your answer: "); 
            sc.nextLine();
            String answer = sc.nextLine();
            if(answer.equals(dictionaryFile.game[choice].getAnswer())) {
                System.out.println("\nCorrect!\n");
            } 
            else {
                System.out.println("\nWrong!\n");
            }
        } 
    }
}
