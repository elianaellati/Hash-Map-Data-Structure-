package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Department  {
String departmentname;
String file;
File filee;
Hash m=new Hash();

public Department(String departmentname,String file ) {
	super();
	this.departmentname = departmentname;
	this.file=file;
	filee=new File(file);
}

public File getFilee() {
	return filee;
}

public void setFilee(File filee) {
	this.filee = filee;
}

public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}

 
 
}
