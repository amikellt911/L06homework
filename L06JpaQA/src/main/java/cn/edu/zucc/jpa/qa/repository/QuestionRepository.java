package cn.edu.zucc.jpa.qa.repository;

import cn.edu.zucc.jpa.qa.entity.QaQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:25
 */
public interface QuestionRepository extends JpaRepository<QaQuestionEntity, Integer> {
    List<QaQuestionEntity> findByTitleLike(String title);
    List<QaQuestionEntity> findByTitleLikeOrderByTitleDesc(String title);
}
