package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class InfrastructureDepartment {
	public String BILLBOARD_FILE_NAME = "data/billboard.bbd";
	public List<Billboard> billboards;

	public InfrastructureDepartment() {
		
	}
	
	public void addBillboard(double w, double h, boolean iU, String b) {
		Billboard billboard = new Billboard(w,h,iU,b); 
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
	
	public void importData(String fn) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fn));
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split("|");
			double w = Double.parseDouble(parts[0]);
			double h = Double.parseDouble(parts[1]);
			boolean iU = Boolean.parseBoolean(parts[2]);
			Billboard billboard = new Billboard(w,h,iU,parts[3]); 
			billboards.add(billboard);
			line = br.readLine();
		}
		br.close();
	}
	
	public String toString() {
		String show = "W      H      InUse      Brand\n";
		for(int i=0; i<billboards.size(); i++) {
			show += +billboards.get(i).getWidth()+"      "+billboards.get(i).getHeight()+"      "+billboards.get(i).getInUse()+"      "+billboards.get(i).getBrand()+"\n";
		}
		return show;
	}
}
