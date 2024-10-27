package com.example.studentmvc.controller;

import com.example.studentmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // 处理显示表单的请求
    @GetMapping("/student-form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // 处理表单提交的请求
    @PostMapping("/student-form")
    public String submitForm(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "student-form";
        }
        students.add(student);
        return "redirect:/students";
    }

    // 显示学生列表
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "students-list";
    }
}
