package xam.cross.celebcompare.entity;

public class Celebrity{

	private String name;
	private int age;
	private int numberChildren;
	private int numberSpouses;
	private double wealthMillions;
	private double heightCm;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumberChildren() {
		return numberChildren;
	}
	public void setNumberChildren(int numberChildren) {
		this.numberChildren = numberChildren;
	}
	public int getNumberSpouses() {
		return numberSpouses;
	}
	public void setNumberSpouses(int numberSpouses) {
		this.numberSpouses = numberSpouses;
	}
	public double getWealthMillions() {
		return wealthMillions;
	}
	public void setWealthMillions(double wealthMillions) {
		this.wealthMillions = wealthMillions;
	}
	public double getHeightCm() {
		return heightCm;
	}
	public void setHeightCm(double heightCm) {
		this.heightCm = heightCm;
	}
	
	public int compareAge(Celebrity another){
		if (this.age > another.age){
			return 1;
		}
		else if(this.age < another.age){
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public int compareNumberChildren(Celebrity another){
		if (this.numberChildren > another.numberChildren){
			return 1;
		}
		else if(this.numberChildren < another.numberChildren){
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public int compareNumberSpouses(Celebrity another){
		if (this.numberSpouses > another.numberSpouses){
			return 1;
		}
		else if(this.numberSpouses < another.numberSpouses){
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public int compareWealth(Celebrity another){
		if ((this.wealthMillions - another.wealthMillions) < 0.1){
			return 0;
		}
		else if (this.wealthMillions > another.wealthMillions){
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
	public int compareHeight(Celebrity another){
		if ((this.heightCm - another.heightCm) < 0.01){
			return 0;
		}
		else if (this.heightCm > another.heightCm){
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
}
