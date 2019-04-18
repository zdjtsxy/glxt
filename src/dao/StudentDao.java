package dao;

import java.util.List;

import hw.student;

public interface StudentDao {
	// 创建一个添加学生的方法
	public boolean insertStudent(student stu);

	// 创建一个查询所有学生的方法
	public List<student> selectAllStudent();

	// 创建一个查询学生的方法，通过id查询
	public student selectById(int id);

	// 创建一个删除学生的方法，通过id删除
	public boolean deleteById(int id);
}
