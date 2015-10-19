package xam.cross.celebcompare.entity;

import java.util.HashSet;
import java.util.Set;

public class Celebrity {

	private static Set<Celebrity> celebrities = new HashSet<Celebrity>();

	public Celebrity(String name, int age, int numberChildren,
			int numberSpouses, double wealth, double height) {
		this.name = name;
		this.age = age;
		this.numberChildren = numberChildren;
		this.numberSpouses = numberSpouses;
		this.wealthMillions = wealth;
		this.heightCm = height;
		addCelebrity(this);
	}

	private String name;
	private int age;
	private int numberChildren;
	private int numberSpouses;
	private double wealthMillions;
	private double heightCm;

	public static Set<Celebrity> getCelebrities() {
		return new HashSet<Celebrity>(celebrities);
	}

	public static void clearCelebrities() {
		celebrities.clear();
	}

	public static void addCelebrity(Celebrity celebrity) {
		celebrities.add(celebrity);
	}

	public static void removeCelebrity(Celebrity celebrity) {
		if (!celebrities.contains(celebrity)) {
			return;
		}
		celebrities.remove(celebrity);
	}

	public static Set<Celebrity> getTwoRandomCelebs() {
		int multiplier = celebrities.size() + 1;
		Set<Celebrity> celebsToCompare = new HashSet<Celebrity>();
		int celebOneIndex = (int) (Math.random() * multiplier);
		int celebTwoIndex = (int) (Math.random() * multiplier);
		if (multiplier > 1) {
			while (celebTwoIndex == celebOneIndex) {
				celebTwoIndex = (int) (Math.random() * multiplier);
			}
		}
		else {
			return null;
		}
		celebsToCompare.add((Celebrity) celebrities.toArray()[celebOneIndex]);
		celebsToCompare.add((Celebrity) celebrities.toArray()[celebTwoIndex]);
		return celebsToCompare;
	}

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

	public boolean equals(Object celebrity) {
		return this.getName().equals(((Celebrity) celebrity).getName());
	}

	public int hashCode() {
		return this.getName().hashCode();
	}

}
