package org.example.studentmanager.Entity;

public class Student {
    private String Sno;
    private String Sname;
    private Boolean sex;
    private String major;
    private String Classid;

    public String getSno() {return Sno;}
    public void setSno(String Sno) {this.Sno = Sno;}
    public String getSname() {return Sname;}
    public void setSname(String Sname) {this.Sname = Sname;}
    public Boolean getSex(){return sex;}
    public void setSex(){this.sex = sex;}
    public String getMajor(){return major;}
    public void setMajor(String major){this.major = major;}
    public String getClassid(){return Classid;}
    public void setClassid(String Classid){this.Classid = Classid;}

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + Sno + '\'' +
                ", sname='" + Sname + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", classId='" + Classid + '\'' +
                '}';
    }
}
