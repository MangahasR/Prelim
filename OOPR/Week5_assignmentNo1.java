package com.mycompany.week5assno1;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mangahas {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String word1 = br.readLine();

        System.out.print("Enter second word: ");
        String word2 = sc.nextLine();

        System.out.print("Enter third word: ");
        String word3 = br.readLine();

        System.out.println(word1 + " " + word2 + " " + word3);
    }