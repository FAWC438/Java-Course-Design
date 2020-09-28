package homework_1_2018213344_凌国瀚;

import java.util.*;

public class _2018213344_凌国瀚_1_StudentListTest {

    /**
     * @param sl 学生列表对象
     */
    private static void showStudents(_2018213344_凌国瀚_1_StudentList sl) {
        System.out.println(sl.get_list().size() + " Students at the moment as described below:");
        for (int i = 0; i < sl.get_list().size(); i++) {
            System.out.println(sl.get_list().get(i).toString());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        _2018213344_凌国瀚_1_StudentList sl = new _2018213344_凌国瀚_1_StudentList(1000);
        int no, mathMark, englishMark, scienceMark;
        String number, name;
        _2018213344_凌国瀚_1_Student foundStudent;

        while (sc.hasNext()) {
            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    number = sc.next();
                    name = sc.next();
                    mathMark = sc.nextInt();
                    englishMark = sc.nextInt();
                    scienceMark = sc.nextInt();
                    _2018213344_凌国瀚_1_Student stu = new _2018213344_凌国瀚_1_Student(number, name);
                    stu.enterMarks(mathMark, englishMark, scienceMark);
                    sl.add(stu);
                    showStudents(sl);
                    break;
                case 2:
                    number = sc.next();
                    if (sl.remove(number)) {
                        System.out.println("Remove successfully");
                        showStudents(sl);
                    } else
                        System.out.println("No such student");
                    break;
                case 3:
                    no = sc.nextInt();
                    if (sl.remove(no)) {
                        System.out.println("Remove successfully");
                        showStudents(sl);
                    } else
                        System.out.println("No such student");
                    break;
                case 4:
                    if (sl.isEmpty()) {
                        System.out.println(true);
                    } else {
                        System.out.println(false);
                    }
                    break;
                case 5:
                    no = sc.nextInt();
                    foundStudent = sl.getItem(no);
                    if (foundStudent == null)
                        System.out.println("No such student");
                    else {
                        System.out.println("Student Info:");
                        System.out.println(foundStudent.toString());
                    }
                    break;
                case 6:
                    number = sc.next();
                    foundStudent = sl.getItem(number);
                    if (foundStudent == null)
                        System.out.println("No such student");
                    else {
                        System.out.println("Student Info:");
                        System.out.println(foundStudent.toString());
                    }
                    break;
                case 7:
                    showStudents(sl);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}