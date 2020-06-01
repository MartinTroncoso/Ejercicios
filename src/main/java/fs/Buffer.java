package fs;

public class Buffer{

	public int inicioBuffer;
	public int finBuffer;
	public byte[] bytesBuffer;
	
	public Buffer(int inicioBuffer, int finBuffer, byte[] bytesBuffer) {
		this.inicioBuffer = inicioBuffer;
		this.finBuffer = finBuffer;
		this.bytesBuffer = bytesBuffer;
	}
	
	public int getInicio() {
		return inicioBuffer;
	}
	
	public int getFin() {
		return finBuffer;
	}
	
	public byte[] getBytes() {
		return bytesBuffer;
	}

}
