package homework_1_2018213344_凌国瀚;

import java.util.Scanner;

public class _2018213344_凌国瀚_1_StudentTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String number = sc.next();
        String name = sc.next();
        int mathMark = sc.nextInt();
        int englishMark = sc.nextInt();
        int scienceMark = sc.nextInt();

        _2018213344_凌国瀚_1_Student stu = new _2018213344_凌国瀚_1_Student(number, name);
        stu.enterMarks(mathMark, englishMark, scienceMark);

        System.out.println(stu.toString());

        sc.close();
    }
}
