package it.slidingblock.core.block;

import java.awt.Graphics;
import java.awt.Point;

import it.slidingblock.core.Matrix;
import it.slidingblock.gui.ImageProvider;
import it.slidingblock.gui.MainFrame;

public class Block {
	private int heigth;
	private int id;
	private int width;

	public Block(int id, int width, int heigth) {
		this.id = id;
		this.width = width;
		this.heigth = heigth;
	}

	public int getHeigth() {
		return heigth;
	}

	public int getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public void paint(Graphics g, Point p) {
		g.drawImage(ImageProvider.getBlocks().get("yellowBlock" + this.getHeigth() + "x" + this.getWidth()),
				(p.x * Matrix.cellsize) + MainFrame.sumX, (p.y * Matrix.cellsize) + MainFrame.sumY, null);
	}
}
