package main.java.example;

import example.MyClass;
import static java.lang.System.*;
// import java.util.*;
// import java.sql.*;

public class PrintName 
{
   public static void main(String args[]) 
   {       
      // Initializing the String variable 
      // with a value 
      String name = "GeeksforGeeks";
      
      // Creating an instance of class MyClass in 
      // the package.
      MyClass obj = new MyClass();
      
      obj.getNames(name);

      out.println("hello wolrd");

    //   Date date;
   }
}