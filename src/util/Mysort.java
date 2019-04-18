package util;

import java.util.Comparator;

import hw.student;

public class Mysort implements Comparator<student> {
	// true 升序 flase 降序
	private boolean flag;

	public Mysort(boolean flag) {
		this.flag = flag;
	}

	@Override
	public int compare(student o1, student o2) {
		if (flag) {
			if (o1.getScore() > o2.getScore()) {
				return 1;
			} else if (o1.getScore() < o2.getScore()) {
				return -1;
			}
		} else {
			if (o1.getScore() < o2.getScore()) {
				return 1;
			} else if (o1.getScore() > o2.getScore()) {
				return -1;
			}
		}
		return 0;
	}

}
