package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Employees implements Cloneable {

        private final List<String> empList;

        public Employees() {
            empList = new ArrayList<>();
        }

        public Employees(List<String> list) {
            this.empList = list;
        }

        /** read all employees from database / Rest API and put into the list */
        public void loadData() {
            empList.add("Pankaj");
            empList.add("Raj");
            empList.add("David");
            empList.add("Lisa");
        }

        /**
         * We save the empList, so clone() have not to retrieve it, With new Employees() we should
         * re-retrieve the empList
         */
        public List<String> getEmpList() {
            return empList;
        }

        /** call constructor with getEmpList already populated */
        @Override
        public Object clone() {

            List<String> temp = new ArrayList<>(this.getEmpList());
            return new Employees(temp);
        }
    }

    public static void main(String[] args) {
        Employees emps = new Employees();
        emps.loadData();

        // Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }
}
