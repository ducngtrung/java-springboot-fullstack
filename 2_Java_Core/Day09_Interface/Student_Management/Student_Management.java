package Day09_Interface.Student_Management;

import java.util.Scanner;

public class Student_Management {
    public static void main(String[] args) {
        Student[] studentList = new Student[20];
        Scanner input = new Scanner(System.in);
        boolean isContinue = true;

        System.out.println("Nhap thong tin hoc sinh:");
        for (int i = 0; i < studentList.length; ++i) {
            studentList[i] = new Student();

            System.out.print("\t Nhap ho va ten: ");
            studentList[i].setName(input.nextLine());
            
            System.out.print("\t Nhap tuoi: ");
            studentList[i].setAge(input.nextInt());
            input.nextLine();

            System.out.print("\t Nhap diem: ");
            studentList[i].setMark(input.nextDouble());
            input.nextLine();

            System.out.println("Tiep tuc nhap (Y/N)?");
            String continueInput = input.nextLine();
            switch (continueInput.toLowerCase()) {
                case "y": {
                    break;
                }
                case "n": {
                    isContinue = false;
                    break;
                }
            }
            if (!isContinue) {
                break;
            }
        }

        System.out.println("\nDanh sach hoc sinh:");
        for (int i = 0; i < studentList.length; ++i) {
            if (studentList[i] != null) {
                studentList[i].classify();
                studentList[i].display();
            }
        }

        input.close();
    }
}