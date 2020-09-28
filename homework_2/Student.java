package homework_2;

public class Student {

    private final String _studentNumber;
    private final String _studentName;
    private int _markForMaths = -1;
    private int _markForEnglish = -1;
    private int _markForScience = -1;

    public Student(String number, String name) {
        this._studentNumber = number;
        this._studentName = name;
    }

    public Student() {
        this._studentNumber = "2018213344";
        this._studentName = "凌国瀚";
    }

    String getNumber() {
        return this._studentNumber;
    }

    String getName() {
        return this._studentName;
    }

    void enterMarks(int markForMaths, int markForEnglish, int markForScience) {
        this._markForMaths = markForMaths;
        this._markForEnglish = markForEnglish;
        this._markForScience = markForScience;
    }

    int getMathsMark() {
        return this._markForMaths;
    }

    int getEnglishMark() {
        return this._markForEnglish;
    }

    int getScienceMark() {
        return this._markForScience;
    }

    double calculateAverage() {
        return (getMathsMark() + getEnglishMark() + getScienceMark()) / 3.0;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Number:" + getNumber() + "\n";
        s += "Name:" + getName() + "\n";
        s += "Math:" + getMathsMark() + "\n";
        s += "English:" + getEnglishMark() + "\n";
        s += "Science:" + getScienceMark() + "\n";
        s += "Ave:" + String.format("%.2f", calculateAverage());
        return s;
    }
}
