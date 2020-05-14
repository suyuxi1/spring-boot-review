package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Su
 * @className CourseRepository
 * @Description TODO
 * @Date 2020/5/14 20:47
 * @Version 1.0
 **/
public interface CourseRepository extends JpaRepository<Course, Integer> {
    /**
     * 根据课程名称查询
     *
     * @param courseName
     * @return
     */
    Course findCourseByCourseName(String courseName);
}
