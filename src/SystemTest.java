import java.util.Arrays;
import java.util.HashSet;

public class SystemTest {

    public static EnrolmentSystem es;

    public static void main(String[] args) {
        Student s1 = new Student("123", "a");
        Student s2 = new Student("124", "b");
        Student s3 = new Student("125", "c");
        HashSet<Student> studentList = new HashSet<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Unit u1 = new Unit("1", "a", UnitType.core);
        Unit u2 = new Unit("2", "b", UnitType.core);
        Unit u3 = new Unit("3", "c", UnitType.elective);
        HashSet<Unit> unitList = new HashSet<>();
        unitList.add(u1);
        unitList.add(u2);
        unitList.add(u3);

        Enrolment e1 = new Enrolment(s1, u1, "9");
        Enrolment e2 = new Enrolment(s1, u2, "9.8");
        Enrolment e3 = new Enrolment(s2, u3, "9.5");
        HashSet<Enrolment> enrolmentList = new HashSet<>();
        enrolmentList.add(e1);
        enrolmentList.add(e2);
        enrolmentList.add(e3);

        es = new EnrolmentSystem(studentList, unitList, enrolmentList);

        test01();
    }

    public static void test01() {
        System.out.println(es);
        try {
            String codes[] = {"1", "2"};
            es.enroll("125", Arrays.asList(codes));
            System.out.println(es);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
