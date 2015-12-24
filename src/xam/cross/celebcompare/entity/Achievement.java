package xam.cross.celebcompare.entity;

public class Achievement {

	private String title;
	private String description;
	private int imageId;
	private boolean achieved;
	
	public Achievement(String title, String description, int imageId, boolean achieved){
		this.title = title;
		this.description = description;
		this.imageId = imageId;
		this.achieved = achieved;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public boolean isAchieved() {
		return achieved;
	}
	public void setAchieved(boolean achieved) {
		this.achieved = achieved;
	}

}
