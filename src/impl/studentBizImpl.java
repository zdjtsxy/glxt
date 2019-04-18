package impl;

import java.util.Collections;
import java.util.List;

import biz.StudentBiz;
import dao.StudentDao;
import daoimpl.studentDaoImpl;
import hw.student;
import util.Mysort;

public class studentBizImpl implements StudentBiz {
	// 创建dao对象
	private StudentDao stuD;

	public studentBizImpl() {
		super();
		this.stuD = new studentDaoImpl();
	}

	@Override
	public String addStudent(int id, String name, double score) {
		/*
		 * Boolean b=this.stuD.insertStudent(new student(name,id,score)); return
		 * b?"添加成功":"添加失败";
		 */
		return this.stuD.insertStudent(new student(name, id, score)) ? "添加成功" : "添加失败";

	}

	@Override
	public List<student> findAll() {
		// TODO Auto-generated method stub
		return this.stuD.selectAllStudent();
	}

	@Override
	public List<student> sort(Boolean b) {
		// 查询所有学生
		List<student> list = this.stuD.selectAllStudent();
		// 进行排序
		Collections.sort(list, new Mysort(b));
		return list;
	}

	@Override
	public student findById(int id) {
		// TODO Auto-generated method stub
		return this.stuD.selectById(id);
	}

	@Override
	public String removestudent(int id) {
		// 删除学生
		/*
		 * Boolean b=this.stuD.deleteById(id); return b?"删除成功":"删除失败";
		 */
		return this.stuD.deleteById(id) ? "删除成功" : "删除失败";
	}

}
