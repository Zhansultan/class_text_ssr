package com.example.classification_text;

import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.toLowerCase;

public class Text {
    private String content;
    private char[] stringToCharArray;
    private int[] langArr = {0, 0, 0, 0};
    private char[][] symbArr = {
            {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','w','x','y','z'},
            {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'},
            {'ә','і','ң','ғ','ү','ұ','қ','ө','һ'},
            {'1','2','3','4','5','6','7','8','9','0','`','~','!','@','#','$','%','^','&','*','(',')','_','-','+','=','\\','\'','\"','/','-','?','>','.','<',','}
    };
    private int maxInd;
    public String language = "";


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        stringToCharArray = content.toCharArray();
        convStrToChar(stringToCharArray, symbArr, langArr);
        searchMax(langArr);
        System.out.println("Lang - " + maxInd);
        findLang(maxInd);
    }

    private void convStrToChar (char[] ch, char[][] chars, int[] langArr) {
        for (char output : ch) {
            output = toLowerCase(output);
            checkChar(chars, output, langArr);
        }
    }

    private void checkChar (char[][] chars, char ch, int[] arr) {
        for(int i = 0; i < chars.length; i++) {
            for(int j = 0; j < chars[i].length; j++){
                if (ch == chars[i][j]){
                    System.out.println(i);
                    arr[i] += 1;
                    System.out.println(arr[i]);
                    System.out.println("output = "+ch+"; symbArr = "+chars[i][j]);

                }
            }
        }
    }

    private void searchMax (int[] arr) {
        maxInd = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[2] > 0) {
                maxInd = 2;
                System.out.println("maxInd = " + 2);
                System.out.println("maxInd.val = " + arr[2]);
                break;
            }
            else if (arr[maxInd] < arr[i]) {
                maxInd = i;
                System.out.println("maxInd = " + maxInd);
                System.out.println("maxInd.val = " + arr[maxInd]);
            }
            else if (arr[maxInd] == arr[i]){
//
            }
        }
    }

    private void findLang (int num) {
        switch (num) {
            case (0):
                language = "Eng";
                break;
            case (1):
                language = "Rus";
                break;
            case (2):
                language = "Kaz";
                break;
            case (3):
                language = "Unknown symbols";
                break;
        }
        System.out.println(language);
    }
}
