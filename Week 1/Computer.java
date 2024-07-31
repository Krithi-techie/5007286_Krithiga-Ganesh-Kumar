package Builder_example;


public class Computer {
	private String cpu;
	private String ram;
	private String storage;
	private String operatingsystem;
	
	public Computer(Builder build) {
		this.cpu=build.cpu;
		this.ram=build.ram;
		this.storage=build.storage;
		this.operatingsystem=build.operatingsystem;
	}
	public String setCPU() {
		return cpu;
	}
	public String setram() {
		return ram;
	}
	public String setStorage() {
		return storage;
	}
	public String setOS() {
		return operatingsystem;
	}
	
	public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", storage=" + storage +",OS="+operatingsystem+"]";
    }
	

public static class Builder {
	private String cpu;
	private String ram;
	private String storage;
	private String operatingsystem;
	public Builder() {
		
	}
	public Builder setCPU(String cpu) {
		this.cpu=cpu;
		return this;
	}
	public Builder setRAM(String ram) {
		this.ram=ram;
		return this;
	}
	public Builder setStorage(String storage) {
		this.storage=storage;
		return this;
	}
	public Builder setOS(String os) {
		this.operatingsystem=os;
		return this;
	}
	public Computer build() {
		return new Computer(this);
	}
}

}
