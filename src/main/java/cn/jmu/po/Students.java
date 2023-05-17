package cn.jmu.po;

public class Students {
    private String studentId;
    private String studentName;
    private String studentPwd;
    private String sex;

    public Students() {
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPwd='" + studentPwd + '\'' +
                ", sex='" + sex + '\'' +
                ", classId=" + classId +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    private Integer classId;

    public Students(String studentId, String studentName, String studentPwd, String sex, Integer classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPwd = studentPwd;
        this.sex = sex;
        this.classId = classId;
    }
}
