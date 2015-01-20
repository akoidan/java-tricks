package generic.mytest;

public class Camera extends Product<Camera>{
	int pixels;

	public int getPixels() {
		return pixels;
	}

	public void setPixels(int pixels) {
		this.pixels = pixels;
	}

	@Override
	int subCompare(Camera p) {
		return 0;
		
	}
	
}
