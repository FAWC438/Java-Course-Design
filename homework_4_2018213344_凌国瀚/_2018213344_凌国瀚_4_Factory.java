package homework_4_2018213344_凌国瀚;

import java.util.HashMap;

public class _2018213344_凌国瀚_4_Factory {
    private HashMap<String, _2018213344_凌国瀚_4_Employee> _employees = new HashMap<>();

    public _2018213344_凌国瀚_4_Factory() {

    }

    public HashMap<String, _2018213344_凌国瀚_4_Employee> get_employees() {
        return _employees;
    }

    public void set_employees(HashMap<String, _2018213344_凌国瀚_4_Employee> _employees) {
        this._employees = _employees;
    }

    public void initEmployees(_2018213344_凌国瀚_4_Employee e) {
        get_employees().put(e.get_socialSecurityNumber(), e);
    }

    public _2018213344_凌国瀚_4_Employee getEmployee(String empSecNum) {
        return get_employees().get(empSecNum);
    }

    public _2018213344_凌国瀚_4_Employee deleteEmployee(String empSecNum) {
        _2018213344_凌国瀚_4_Employee e = get_employees().get(empSecNum);
        get_employees().remove(empSecNum);
        return e;
    }

    public _2018213344_凌国瀚_4_Employee addEmployee(_2018213344_凌国瀚_4_Employee stu) {
        if (get_employees().containsKey(stu.get_socialSecurityNumber())) {
            return null;
        } else {
            get_employees().put(stu.get_socialSecurityNumber(), stu);
            return stu;
        }
    }

    public _2018213344_凌国瀚_4_Employee updateEmployee(String empSecNum, _2018213344_凌国瀚_4_Employee emp) {
        if (!get_employees().containsKey(empSecNum)) {
            return null;
        } else {
            get_employees().remove(empSecNum);
            get_employees().put(empSecNum, emp);
            return emp;
        }
    }

    public void printEmployees() {
        for (String key : get_employees().keySet()) {
            System.out.println(get_employees().get(key));
        }
    }
}
