package com.aadiosity.escobar;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String str = "1+2+3+4*5/6/3-2";
//        System.out.println(str.matches("[0-9]*( ){0,}([+-/*]( ){0,}[0-9]*( ){0,})*"));
    }



















    public static void comment(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an expression to be evaluated: ");
        String expression = scan.nextLine();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            System.out.println("Result is: " + engine.eval(expression));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}