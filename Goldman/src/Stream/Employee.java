package Stream;

public class Employee {

    private String name;
    private String departmentName;
    private Integer workExperience;
    private int salary;
    private String techStream;

    public Employee(String name, String departmentName, Integer workExperience, int salary, String techStream) {
        this.name = name;
        this.departmentName = departmentName;
        this.workExperience = workExperience;
        this.salary = salary;
        this.techStream = techStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTechStream() {
        return techStream;
    }

    public void setTechStream(String techStream) {
        this.techStream = techStream;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", workExperience=" + workExperience +
                ", salary=" + salary +
                ", techStream='" + techStream + '\'' +
                '}';
    }
}
