package Project_EmployeeSalaryPayrollSystem_usingOOPsConcept;

import java.util.ArrayList;

abstract class Employee{
  private String name;
  private int id;

  public Employee(String name, int id){
    this.name = name;
    this.id = id;
  }

  public String getName(){
    return name;
  }
  public int getId(){
    return id;
  } 

  public abstract double calculateSalary();

  @Override
  public String toString(){
    return "Employee[name= " +name+ ", id= "+id+", Salay= "+calculateSalary()+"]";
  }

}


class FullTimeEmployee extends Employee{
  private double monthlySalary;

  public FullTimeEmployee(String name, int id, double monthlySalary){
    super(name, id);
    this.monthlySalary = monthlySalary;
  }

  @Override
  public double calculateSalary(){
    return monthlySalary;
  }
}

class PartTimeEmployee extends Employee{
  private int hourWorked;
  private double hourlyRate;

  public PartTimeEmployee(String name, int id, int hourWorked, double hourlyRate){
    super(name, id);
    this.hourWorked = hourWorked;
    this.hourlyRate = hourlyRate;
  }

  @Override 
  public double calculateSalary(){
    return hourWorked*hourlyRate;
  }

}

class PayrollSystem{
  private ArrayList<Employee> employeelist;

  public PayrollSystem(){
    employeelist = new ArrayList<>();
  }
  
  public void addEmployee(Employee employee){
    employeelist.add(employee);
  }

  public void removeEmployee(int id){
    Employee employeeToRemove = null;

    for(Employee employee : employeelist){
      if(employee.getId() == id){
          employeeToRemove = employee;
          break;
      }
    }

    if(employeeToRemove != null){
      employeelist.remove(employeeToRemove);
    }
  }

  public void displayEmployee(){
    for(Employee employee: employeelist){
      System.out.println(employee);
    }
  }

}

public class Main {
  public static void main(String[] args) {
    PayrollSystem payrollSystem = new PayrollSystem();

    FullTimeEmployee emp1 = new FullTimeEmployee("Vishal", 1, 50000.00);

    PartTimeEmployee emp2 = new PartTimeEmployee("Sachin", 2, 40, 1000.0);

    PartTimeEmployee emp3 = new PartTimeEmployee("Rohan", 3, 40, 500);

    payrollSystem.addEmployee(emp1);
    payrollSystem.addEmployee(emp2);
    payrollSystem.addEmployee(emp3);
    System.out.println("Initial Employee details: ");
    payrollSystem.displayEmployee();

    payrollSystem.removeEmployee(2);

    System.out.println("After delete employee details: ");
    payrollSystem.displayEmployee();
   
  }
}
