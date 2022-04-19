package enums;

public enum CodecVideo {
	
	H264(0.009),
	MPEG4(0.02),
	DIVX(0.01);
	
	private double megabytes;
	
	private CodecVideo(double megabytes) {
		
		this.megabytes = megabytes;
		
	}

	public double getMegabytes() {
		return megabytes;
	}
	
	
}
