package cn.jmu.dao;

import cn.jmu.po.Students;
import cn.jmu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsDaoTest {

    private SqlSession sqlSession;
    private StudentsDAO studentsDAO;
    @BeforeEach
    void setUp() {
        this.sqlSession = MyBatisUtils.getSession();
// 使用sqlSession生成接口的代理对象
        studentsDAO = this.sqlSession.getMapper(StudentsDAO.class);
    }
    @AfterEach
    void tearDown() {
        sqlSession.close();
    }
    @Test
    public void findStuById(){
        Students stu = this.studentsDAO.findStuById("2018110177");
        System.out.println(stu.toString());
    }
    @Test
    public void findStuByName(){
        List<Students> all = this.studentsDAO.findStuByName("飞");
        for(Students stu : all){
            System.out.println(stu.toString());
        }
    }
    @Test
    public void addStu(){
        Students s = new Students();
        s.setStudentId("2018110106");
        s.setStudentName("李萌萌");
        s.setStudentPwd("123");
        s.setSex("女");
        s.setClassId(10201821);
        this.studentsDAO.addStu(s);
        this.sqlSession.commit();
    }
    @Test
    public void updateStu(){
        Students s = new Students();
        s.setStudentId("2018110106");
        s.setStudentName("李小萌");
        s.setStudentPwd("123");
        s.setSex("男");
        s.setClassId(10201821);
        this.studentsDAO.updateStu(s);
        this.sqlSession.commit();
    }
    @Test
    public void deleteStu(){
        this.studentsDAO.delStu("2018110106");
        this.sqlSession.commit();
    }
}