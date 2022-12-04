import java.util.HashSet;
import java.util.List;

public class EnrolmentSystem {
    private HashSet<Student> studentList;
    private HashSet<Unit> unitList;
    private HashSet<Enrolment> enrolmentList;

    public EnrolmentSystem(HashSet<Student> studentList, HashSet<Unit> unitList, HashSet<Enrolment> enrolmentList) {
        this.studentList = studentList;
        this.unitList = unitList;
        this.enrolmentList = enrolmentList;
    }

    public Student searchStudent(String id) {
        Student student = null;
        for (Student s :
                studentList) {
            if (s.getId().equals(id)) {
                student = s;
                break;
            }
        }
        return student;
    }

    public Unit searchUnit(String code) {
        Unit unit = null;
        for (Unit u :
                unitList) {
            if (u.getCode().equals(code)) {
                unit = u;
                break;
            }
        }
        return unit;
    }

    public void enroll(String id, List<String> unitCodes) throws Exception {

        // pre
        Student student = searchStudent(id);
        if (student == null) {
            String msg = "No student with the id exists!";
            throw new Exception(msg);
        }

        for (Enrolment e :
                enrolmentList) {
            if (e.getStudent().getId().equals(id)) {
                String msg = "The student have already enrolled subjects!";
                throw new Exception(msg);
            }
            }

        HashSet<String> unitCodesChecker = new HashSet<>(unitCodes);
        if (unitCodesChecker.size() != unitCodes.size()) {
            String msg = "The input unit codes are not distinct!";
            throw new Exception(msg);
        }

        int countCore = 0;
        for (String code :
                unitCodes) {
            Unit u = searchUnit(code);
            if (u == null) {
                String msg = "No unit with the code " + code + " exists!";
                throw new Exception(msg);
            }
            if (u.getType() == UnitType.core) {
                countCore++;
            }
        }

        if (countCore < 2) {
            String msg = "Must enroll at least 2 core subjects!";
            throw new Exception(msg);
        }


        //post
        for (String code :
                unitCodes) {
            Unit u = searchUnit(code);
            Enrolment e = new Enrolment(student, u, "");

            enrolmentList.add(e);
        }

    }


    @Override
    public String toString() {
        return "EnrolmentSystem{" +
                "\nstudentList=" + studentList +
                ", \nunitList=" + unitList +
                ", \nenrolmentList=" + enrolmentList +
                '}';
    }


}
