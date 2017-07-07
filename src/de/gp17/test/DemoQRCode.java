package de.gp17.test;

public class DemoQRCode {
	public static void main(String[] args) {
		Camera cam = new Camera(Constants.pathToStoreImage);
		cam.takeSnapshot();
	}
}
