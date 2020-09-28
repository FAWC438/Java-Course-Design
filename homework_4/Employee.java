package homework_4;

public abstract class Employee {
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

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        _firstName = firstName;
        _lastName = lastName;
        _socialSecurityNumber = socialSecurityNumber;
    }
}
