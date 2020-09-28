package homework_2_2018213344_凌国瀚;

import java.util.*;
import java.util.regex.Pattern;


public class _2018213344_凌国瀚_2_StudentTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[0-9]*");
        String number;
        try {
            number = sc.next();
            if (number.length() != 10 || !pattern.matcher(number).matches() || number.charAt(0) != '2' || number.charAt(1) != '0') {
                throw new _2018213344_凌国瀚_2_StudentNumberException();
            }
        } catch (_2018213344_凌国瀚_2_StudentNumberException e) {
            System.out.println("Illegal number format");
            return;
        }

        String name = sc.next();
        int mathMark;
        int englishMark;
        int scienceMark;

        try {
            mathMark = sc.nextInt();
            englishMark = sc.nextInt();
            scienceMark = sc.nextInt();
            if (mathMark < 0 || mathMark > 100 || englishMark < 0 || englishMark > 100 || scienceMark < 0 || scienceMark > 100) {
                throw new _2018213344_凌国瀚_2_ScoreException();
            }
        } catch (_2018213344_凌国瀚_2_ScoreException e) {
            System.out.println("Illegal score format");
            return;
        }

        _2018213344_凌国瀚_2_Student stu = new _2018213344_凌国瀚_2_Student(number, name);
        stu.enterMarks(mathMark, englishMark, scienceMark);

        System.out.println("Student Info:");
        System.out.println(stu.toString());

        sc.close();
    }
}
