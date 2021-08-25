package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM Student WHERE id = #{id}")
    Student findById(int id);

    @Select("SELECT * FROM Student WHERE studentNo = #{studentNo}")
    Student findByStudentNo(String studentNo);

    @Select("SELECT s.*, d.name departmentName " +
            "FROM Student s LEFT JOIN department d ON s.departmentId = d.id")
    List<Student> findAll();

    @Update("UPDATE Student SET                " +
            "  studentNo = #{studentNo},       " +
            "  name = #{name},                 " +
            "  departmentId = #{departmentId}, " +
            "  phone = #{phone},               " +
            "  sex = #{sex},                   " +
            "  email = #{email}                " +
            "WHERE id = #{id}")
    void update(Student student);

    @Insert("INSERT Student (studentNo, name, departmentId, phone, sex, email) " +
            "VALUES (#{studentNo}, #{name}, #{departmentId}, #{phone}, #{sex}, #{email})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Student student);

    @Delete("DELETE FROM student WHERE id = #{id};")
    void deleteById(int id);
}
