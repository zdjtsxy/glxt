package biz;

import java.util.List;

import hw.student;

public interface StudentBiz {
	// 添加学生的业务
	public String addStudent(int id, String name, double score);

	// 查询学生的业务
	public List<student> findAll();

	// 排序查询
	public List<student> sort(Boolean b);

	// 根据id查询学生
	public student findById(int id);

	// 删除学生的业务
	public String removestudent(int id);
}
