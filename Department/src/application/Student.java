package application;

public class Student {
String name;
String id;
double average;
String Gender ;

public Student(String name, String id, double average, String gender) {
	super();
	this.name = name;
	this.id = id;
	this.average = average;
	Gender = gender;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public double getAverage() {
	return average;
}
public void setAverage(double average) {
	this.average = average;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}





}