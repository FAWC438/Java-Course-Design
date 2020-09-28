package homework_1_2018213344_凌国瀚;

import java.util.ArrayList;

public class _2018213344_凌国瀚_1_StudentList {

    public ArrayList<_2018213344_凌国瀚_1_Student> get_list() {
        return _list;
    }

    public void set_list(ArrayList<_2018213344_凌国瀚_1_Student> _list) {
        this._list = _list;
    }

    private ArrayList<_2018213344_凌国瀚_1_Student> _list = new ArrayList<>();
    private final int _total;

    _2018213344_凌国瀚_1_StudentList(int length) {
        this._total = length;   // length是数组长度
    }

    /**
     * 增加stu到数组中，成功，返回true，否则false
     *
     * @param stu 学生对象
     * @return 添加是否成功
     */
    boolean add(_2018213344_凌国瀚_1_Student stu) {
        if (this._list.size() >= this._total)
            return false;
        else {
            this._list.add(stu);
            return true;
        }
    }

    /**
     * 删除第no个数组元素，删除成功，返回true，否则false
     *
     * @param no 数组下标
     * @return 删除是否成功
     */
    boolean remove(int no) {
        if (no > this._list.size() || no <= 0)
            return false;
        else {
            this._list.remove(no - 1);
            return true;
        }
    }

    /**
     * 删除学号为number的学生，删除成功，返回true，否则false
     *
     * @param number 学号
     * @return 删除是否成功
     */
    boolean remove(String number) {
        for (int i = 0; i < this._list.size(); i++) {
            if (this._list.get(i).getNumber().equals(number)) {
                this._list.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组是否为空，若是，返回true，否则false
     *
     * @return 判断结果
     */
    boolean isEmpty() {
        return this._list.isEmpty();
    }

    /**
     * 返回第no个学生
     *
     * @param no 查找序号
     * @return 学生对象
     */
    _2018213344_凌国瀚_1_Student getItem(int no) {
        if (no > this._list.size() || no <= 0)
            return null;
        else
            return this._list.get(no - 1);
    }

    /**
     * 返回学号为number的学生，若该生不存在，返回null。
     *
     * @param number 学号
     * @return 学生对象
     */
    _2018213344_凌国瀚_1_Student getItem(String number) {
        for (_2018213344_凌国瀚_1_Student student : this._list) {
            if (student.getNumber().equals(number)) {
                return student;
            }
        }
        return null;
    }

    /**
     * 求学生总数
     *
     * @return 学生总人数
     */
    int getTotal() {
        return this._list.size();
    }
}
