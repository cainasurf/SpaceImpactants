package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	
	protected int x, y; //FLOAT because fluidity
	protected int width, height; //size of the entity
	protected Rectangle bounds;
	
	public Entity(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.bounds = new Rectangle(0,0,width,height);
	}

	public abstract void update();
	
	public abstract void render(Graphics g);

	//***************************************
	//GETTERS ANS SETTERS
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
	
}
