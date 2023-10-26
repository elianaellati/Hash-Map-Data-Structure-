package application;

public class Node {
	Student data;
	int Status;
	
	public Node(Student data, int status) {
		super();
		this.data = data;
		Status = status;
	}
	public Student getData() {
		return data;
	}
	public void setData(Student data) {
		this.data = data;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	

}
