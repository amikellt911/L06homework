package cn.edu.zucc.jpa.qa.controller;

import cn.edu.zucc.jpa.qa.entity.MstCourseEntity;
import cn.edu.zucc.jpa.qa.entity.MstUserEntity;
import cn.edu.zucc.jpa.qa.entity.QaQuestionEntity;
import cn.edu.zucc.jpa.qa.formbean.Question;
import cn.edu.zucc.jpa.qa.repository.AnswerRepository;
import cn.edu.zucc.jpa.qa.repository.CourseRepository;
import cn.edu.zucc.jpa.qa.repository.QuestionRepository;
import cn.edu.zucc.jpa.qa.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:04
 */
@RestController
public class CrudController {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    CrudController(QuestionRepository repository,
                   AnswerRepository answerRepository,
                   UserRepository userRepository,
                   CourseRepository courseRepository){
        this.questionRepository = repository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/crud")
    List<Question> excuteBasicCrud(){
        //创建一个课程
        MstCourseEntity courseEntity = new MstCourseEntity();
        courseEntity.setName("class " + RandomStringUtils.randomNumeric(6));
        courseEntity.setTeacher("teacher " + RandomStringUtils.randomAlphabetic(6));
        courseEntity = this.courseRepository.save(courseEntity);

        //创建一个用户
        MstUserEntity userEntity = new MstUserEntity();
        userEntity.setCellPhone("1234567890");
        userEntity.setLoginname("u" + RandomStringUtils.randomNumeric(6));
        userEntity.setPassword("123456");
        userEntity.setSno("S" + RandomStringUtils.randomNumeric(8));
        userEntity.setUserType("student");
        userEntity = this.userRepository.save(userEntity);

        //创建5个问题
        for(int i = 0; i < 5; i++){
            QaQuestionEntity entity = new QaQuestionEntity();
            entity.setTitle("title-" + RandomStringUtils.randomAlphabetic(4));
            entity.setCourseSid(courseEntity.getSid());
            entity.setCreator(userEntity.getSid());
            this.questionRepository.save(entity);
        }

        //检索出所有的问题
        List<QaQuestionEntity> allQuestion = this.questionRepository.findAll();
        List<Question> questionList = new ArrayList<>();
        allQuestion.stream().forEach(item -> {
            Question q = new Question();
            BeanUtils.copyProperties(item, q);
            questionList.add(q);
        });

        return questionList;
    }
}
