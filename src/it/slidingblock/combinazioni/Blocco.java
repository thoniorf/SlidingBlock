package it.slidingblock.combinazioni;
public class Blocco
{
	public int id;
	public int width;
	public int height;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Blocco(int id, int width, int height) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
	}
	
}
