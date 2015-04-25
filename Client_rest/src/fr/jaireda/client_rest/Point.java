package fr.jaireda.client_rest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root
public class Point {
	@Element
	private final int x;

	@Element
	private final int y;

	public Point(@Element(name="x") int x, @Element(name="y") int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	
	
	
}
