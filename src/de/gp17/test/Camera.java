package de.gp17.test;

import java.io.File;
import java.io.IOException;

import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.enums.Encoding;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

public class Camera {

	private String storePath;

	public Camera(String path) {
		this.storePath = path;
	}

	public void takeSnapshot() {
		takeSnapshot(storePath);
	}

	public void takeSnapshot(String path) {
		RPiCamera camera = null;
		/// home/pi
		try {
			camera = new RPiCamera(path).setEncoding(Encoding.PNG);
		} catch (FailedToRunRaspistillException e) {
			e.printStackTrace();
		}

		System.out.println("Taking snapshot...");

		File file = null;
		try {
			file = camera.takeStill("test.png", 594, 380);
			System.out.println(file.getAbsolutePath());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
