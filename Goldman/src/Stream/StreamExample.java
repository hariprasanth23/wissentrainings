package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {

    public void getWorkExperienceFromOptional(List<Employee> employeeLists){

        List<Optional<Integer>> temp = employeeLists.stream().map(e -> Optional.ofNullable(e.getWorkExperience())).collect(Collectors.toList());

        for(Optional e: temp){
            if(e.isPresent()){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){

        List<Employee> employeeList = Arrays.asList(
                new Employee("Hari","IT",null,100000,"Back End"),
                new Employee("Prasanth","IT",4,100000,"Front End"),
                new Employee("HP","IT",5,100000,"Front End"),
                new Employee("Vijay","IT",3,200000,"Devops"),
                new Employee("Ajith","IT",3,200000,"Devops"));


        new StreamExample().getWorkExperienceFromOptional(employeeList);

        employeeList.stream().filter(e->(e.getDepartmentName()).equals("IT")).collect(Collectors.toList()).forEach(System.out::println);

        long count = employeeList.stream().count();
        System.out.println(count);

        double summingDouble = employeeList.stream().map(Employee::getSalary).collect(Collectors.summingDouble(e->e));
        System.out.println(summingDouble);

        employeeList.stream().collect(Collectors.toSet()).forEach(System.out::println);

        Map<String,Integer> map = employeeList.stream().
                collect(Collectors.toMap(e->e.getName(),e->e.getSalary()));
        System.out.println(map);


    }
}
