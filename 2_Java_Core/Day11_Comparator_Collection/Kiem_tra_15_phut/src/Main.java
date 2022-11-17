// ======= DO NOT EDIT THIS FILE ============
package Day11_Comparator_Collection.Kiem_tra_15_phut.src;

import java.io.*;

class Main {
   public static void main(String args[]) throws Exception {

       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter employee name: ");
       String name = in.readLine();
       System.out.print("Enter employee salary: ");
       double salary = Double.parseDouble(in.readLine()); 
       System.out.print("Enter employee revenue: ");
       double revenue = Double.parseDouble(in.readLine());
       
       System.out.print("Enter the function U want to test 1 or 2: ");
       int testCase = Integer.parseInt(in.readLine());
       System.out.println("OUTPUT:");      
       if(testCase == 1) {
            Employee m = new Employee(name, salary);
            System.out.println(m.toString());
            m = new Seller(name, revenue, salary);
            System.out.println(m.toString());
       }
       else if (testCase == 2) {
           Seller b = new Seller(name, revenue, salary);
           System.out.println("name: " + name + " - salary: " + b.getSalary());
       }
   }
 }