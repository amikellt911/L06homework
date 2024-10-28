package org.example.studentmanager.Controller;


import org.example.studentmanager.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("Add")
    public String add() {
        String sql = "insert into student values(?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql, "32201211", "王俊杰", "1", "计算机","2203");
        return "执行成功，影响" + rows + "行";
    }
    @GetMapping("Delete")
    public String delete(String Sno) {
        String sql = "delete from student where Sno = ?";
        int rows = jdbcTemplate.update(sql, Sno);
        return "执行成功，影响" + rows + "行";
    }
    @GetMapping("Update")
    public String update(String Sno,String Sname) {
        String sql = "update student set Sname = ? where Sno = ?";
        int rows = jdbcTemplate.update(sql,Sname,Sno);
        return "执行成功，影响" + rows + "行";
    }
    @GetMapping("Find")
    public String find(String Sno) {
        String sql = "select * from student where Sno = ?";
        Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), Sno);
        return student.toString();
    }
}
