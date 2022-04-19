package enums;

public enum FormatoAudio {

	MP3(1),
	AAC(0.7),
	FLAC(5);
	
	private double megabytes;
	
	private FormatoAudio(double megabytes) {
		
		this.megabytes = megabytes;
		
	}

	public double getMegabytes() {
		return megabytes;
	}
	
}
