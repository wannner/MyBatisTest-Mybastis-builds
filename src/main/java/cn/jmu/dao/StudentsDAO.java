package cn.jmu.dao;

import cn.jmu.po.Students;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface StudentsDAO {
    //根据学生ID获取学生信息
    @Select("select * from students where studentId=#{studentId}")
    public Students findStuById(String studentId);

    //根据学生姓名模糊查询学生信息列表
    @Select("select * from students where studentName like concat('%',#{cond},'%')")
    public List<Students> findStuByName(String cond);

    //添加学生信息
    @Insert("insert into students(studentId,studentName,studentPwd,sex,classId)" +
            "values(#{studentId},#{studentName},#{studentPwd},#{sex},#{classId})")
    public void addStu(Students students);

    //修改学生信息
    @Update("update students set studentName=#{studentName}," +
            "studentPwd=#{studentPwd}," +
            "sex=#{sex}," +
            "classId=#{classId} where studentId=#{studentId}")
    public void updateStu(Students students);

    // 删除指定ID的学生
    @Delete("delete from students where studentId=#{studentId}")
    public void delStu(String studentId);

    //联合查询
    @Select("select * from students s, classes c "+
            "where s.classId=c.classId " +
            "and s.studentName like #{studentName} and c.className like #{className}")
    public List<Students> combinedfind(HashMap map);

}
