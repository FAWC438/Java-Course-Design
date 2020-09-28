package homework_4_2018213344_凌国瀚;

public abstract class _2018213344_凌国瀚_4_Employee {
    private String _firstName;
    private String _lastName;
    private final String _socialSecurityNumber;

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_socialSecurityNumber() {
        return _socialSecurityNumber;
    }

    public abstract double earning();

    @Override
    public String toString() {
        return String.format("firstName:%s; lastName:%s; socialSecurityNumber:%s; earning:%.2f",
                this.get_firstName(), this.get_lastName(), this.get_socialSecurityNumber(), earning());
    }

    public _2018213344_凌国瀚_4_Employee(String firstName, String lastName, String socialSecurityNumber) {
        _firstName = firstName;
        _lastName = lastName;
        _socialSecurityNumber = socialSecurityNumber;
    }
}
