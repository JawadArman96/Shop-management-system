/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author ASUS
 */
public class Employee {
        public int employeeId;
        public String name;
        public String address;
        public String joinDate;
        public int salary;
        public String phone;

    public Employee(int employeeId, String name, String address, String joinDate, int salary, String phone) {
            this.address=address;
            this.employeeId=employeeId;
            this.joinDate=joinDate;
            this.name=name;
            this.phone=phone;
            this.salary=salary;
        }
}
