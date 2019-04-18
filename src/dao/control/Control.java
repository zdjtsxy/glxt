package dao.control;

import biz.StudentBiz;
import hw.student;
import impl.studentBizImpl;
import util.userinput;
import view.view;

public class Control {
	// 属性
	private view v;
	private userinput ui;
	// 创建业务层对象
	private StudentBiz stuBiz;

	// 构造方法
	public Control() {
		this.v = new view();
		this.ui = new userinput();
		this.stuBiz = new studentBizImpl();
	}

	// 自定义方法，项目流程
	public void show() {
		while (true) {
			this.v.welcome();
			int select = this.ui.getInt("请选择:");
			if (select == 0) {
				this.v.println("系统退出");
				System.exit(0);
			} else if (select == 1) {
				String info = this.addStudent();
				this.v.println(info);
			} else if (select == 2) {
				this.showStudent();
			} else if (select == 3) {
				v.sortview();
				this.sortStudent();
			} else if (select == 4) {
				this.deletestudent();
			} else {
				this.v.println("指令有误");
			}
		}
	}

	// 添加学生信息的方法
	private String addStudent() {
		this.v.println(">>>学生信息录入");
		this.v.println(">>>请输入学生信息");
		int id = this.ui.getInt("请输入学号");
		// 调用biz查询学生的方法判断学生是否存在
		student stu = this.stuBiz.findById(id);
		if (stu != null) {
			return "学号重复，录入失败";
		}
		String name = ui.getString("请输入姓名");
		Double score = ui.getDouble("请输入成绩");
		// 调用biz添加学生的方法
		return this.stuBiz.addStudent(id, name, score);

	}

	// 显示学生成绩的方法
	private void showStudent() {
		v.println(">>>学生信息录入");
		// 调用biz查询所有学生的方法
		v.showArray(this.stuBiz.findAll());
	}

	// 学生信息排序方法
	private void sortStudent() {
		// 调用biz学生排序的方法

		// 准备list集合存放数据
		v.showArray(this.stuBiz.sort(ui.getInt("请选择:") == 1));
	}

	// 删除学生的方法
	private void deletestudent() {
		v.println(">>>学生信息删除");
		int id = ui.getInt("请输入要删除的学号:");
		// 获取学生id
		student stu = this.stuBiz.findById(id);
		if (stu == null) {
			this.v.println("学生不存在");
			return;
		}
		// 如果学生存在，打印学生信息
		this.v.println("学生信息如下");
		this.v.println(stu.toString());
		// 是否删除
		if (!"y".equals(this.ui.getString("是否确认删除y/n"))) {
			this.v.println("删除终止");
			return;
		}
		String s = this.stuBiz.removestudent(stu.getId());
		this.v.println(s);
	}
}
