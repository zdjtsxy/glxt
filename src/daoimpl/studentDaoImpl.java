package daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.StudentDao;
import hw.student;

public class studentDaoImpl implements StudentDao {
	private BufferedReader in;
	private PrintWriter out;
	public static final String URL = "student.txt";

	@Override
	public boolean insertStudent(student stu) {
		// 进行out的实例化操作
		try {
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(URL, true), "utf-8"));
			// 写数据
			out.println(stu.show());
			// 刷新缓冲区
			out.flush();
			return true;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	{

		if (out != null)
			out.close();
	}

	@Override
	public List<student> selectAllStudent() {
		// 创建list集合
		List<student> list = new ArrayList<student>();
		// 创建输入流
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(URL), "utf-8"));
			// 创建一个字符串临时储存每一行数据
			String s = "";
			while ((s = in.readLine()) != null) {
				String[] arr = s.split("#");
				list.add(new student(arr[1], Integer.parseInt(arr[0]), Double.parseDouble(arr[2])));
			}
			return list;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public student selectById(int id) {
		// 调用自身的查询所有的方法
		List<student> list = selectAllStudent();
		// 遍历集合
		for (student stu : list) {
			// 判断id是否与遍历的学生id一致，一致就是要找的学生
			if (id == stu.getId()) {
				return stu;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// 查询所有学生
		List<student> list = selectAllStudent();
		Iterator<student> it = list.iterator();
		// 将指定学生从集合中删掉
		while (it.hasNext()) {
			student s = it.next();
			if (id == s.getId()) {
				it.remove();
				break;
			}
		}
		// 删除原有文件夹
		File file = new File(URL);
		if (file.exists()) {
			file.delete();
		}
		// 重新将所有的学生写入新的文件夹
		for (student s : list) {
			insertStudent(s);
		}
		return true;
	}

}
