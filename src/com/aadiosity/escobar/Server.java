package com.aadiosity.escobar;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
    private static BufferedReader in;
    private static PrintWriter out;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true){
                Socket client = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);
                String request = in.readLine();
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter an expression to be evaluated: ");
                String expression = scan.nextLine();
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                if (request.matches("[0-9]*( ){0,}([+-/*]( ){0,}[0-9]*( ){0,})*")){
                    try {
                        out.println("Result is: " + engine.eval(expression));
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
