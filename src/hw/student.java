package hw;

import java.io.Serializable;

public class student implements Serializable {
	private String name;
	private int id;// 学号
	private double score;// 成绩

	public student(String name, int id, double score) {
		super();
		this.name = name;
		this.id = id;
		this.score = score;
	}

	public student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	// 自定义一个方法
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "\t" + this.name + "\t" + this.score;
	}

	// 在记事本里面展示的格式
	public String show() {
		return this.id + "#" + this.name + "#" + this.score;
	}

}