package generic.container;

public class Camera extends Product <Camera> {
	int pixel;

	public int getPixel() {
		return pixel;
	}

	public void setPixel(int pixel) {
		this.pixel = pixel;
	}

	@Override
	int subCompare(Camera p) {

		int pixelIn = ((Camera)p).getPixel();
		if (pixelIn>pixel) {return 1;} 
		if (pixelIn==pixel) {return 0;} else
			return -1;
	
	} 
		
	
	
}
