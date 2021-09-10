package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class InfrastructureDepartment {
	public String BILLBOARD_FILE_NAME = "data/billboard.bbd";
	public List<Billboard> billboards;

	public InfrastructureDepartment() {
		
	}
	
	public void addBillboard(double h, double w, boolean iU, String b) {
		Billboard billboard = new Billboard(h,w,iU,b); 
		billboards.add(billboard);
	}
	
	private void saveBillboards() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BILLBOARD_FILE_NAME));
		oos.writeObject(billboards);
		oos.close();
	}
	
	private void loadBillboards() throws IOException, ClassNotFoundException {
		File f = new File(BILLBOARD_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			billboards = (List<Billboard>) ois.readObject();
			ois.close();
		}
	}
	
	public void exportDangerousBillboardReport(String fn) {
		
	}
	
	public void importData(String fn) {
		
	}
	
	public String toString() {
		
		return x;
	}
}
