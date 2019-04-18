package mytest;

import java.util.List;

import org.junit.Test;

import biz.StudentBiz;
import hw.student;
import impl.studentBizImpl;

public class Mytest {
	@Test
	public void add() {
		StudentBiz sb = new studentBizImpl();
		String s = sb.addStudent(2, "小马", 66);
		System.out.println(s);
	}

	@Test
	public void select() {
		StudentBiz sb = new studentBizImpl();
		List<student> list = sb.findAll();
		for (student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void selectId() {
		StudentBiz sb = new studentBizImpl();
		student stu = sb.findById(5);
		System.out.println(stu);
	}

	@Test
	public void deleteId() {
		StudentBiz sb = new studentBizImpl();
		sb.removestudent(5);
	}
}
