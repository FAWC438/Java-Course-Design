package homework_1;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String number = sc.next();
        String name = sc.next();
        int mathMark = sc.nextInt();
        int englishMark = sc.nextInt();
        int scienceMark = sc.nextInt();

        Student stu = new Student(number, name);
        stu.enterMarks(mathMark, englishMark, scienceMark);

        System.out.println(stu.toString());

        sc.close();
    }
}
