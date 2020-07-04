package com.aadiosity.escobar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the socket number: ");
        int socketNumber = scan.nextInt();
        try(Socket socket = new Socket("localhost", socketNumber)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String expression;
            while (true){
                System.out.print("Enter the expression: ");
                expression = scan.nextLine();
                out.println(expression);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
