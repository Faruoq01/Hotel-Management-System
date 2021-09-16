package hotelmanagementsystem;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends RecursiveTreeObject<Employee> {

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    StringProperty emp_id;
    StringProperty emp_username;
    StringProperty emp_password;
    StringProperty emp_fullname;
    StringProperty emp_phone;
    StringProperty emp_salary;
    StringProperty emp_address;
    StringProperty emp_start_date;
    StringProperty emp_usertype;

    public Employee(String id, String username, String password, String fullname, String address, String phone, String salary, String usertype, String startdate) {
        this.emp_id = new SimpleStringProperty(id);
        this.emp_username = new SimpleStringProperty(username);
        this.emp_fullname = new SimpleStringProperty(fullname);
        this.emp_address = new SimpleStringProperty(address);
        this.emp_phone = new SimpleStringProperty(phone);
        this.emp_password = new SimpleStringProperty(password);
        this.emp_start_date = new SimpleStringProperty(startdate);
        this.emp_salary = new SimpleStringProperty(salary);
        this.emp_usertype = new SimpleStringProperty(usertype);
    }

}
