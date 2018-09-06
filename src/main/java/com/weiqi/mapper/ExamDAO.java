package com.weiqi.mapper;

import com.weiqi.model.Exam;
import org.springframework.stereotype.Repository;

/**
 * ExamDAO继承基类
 */
@Repository
public interface ExamDAO extends MyBatisBaseDao<Exam, Integer> {
}