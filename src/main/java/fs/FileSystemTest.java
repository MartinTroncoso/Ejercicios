package fs;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class FileSystemTest {
	
	public int inicioBuffer;
	public int finBuffer;
	public byte[] C0 = new byte[4];
	public byte[] C1 = new byte[1];
	public byte[] C2 = new byte[5];
	
	public LowLevelFileSystem lowLevelFileSystem = Mockito.mock(LowLevelFileSystem.class);
	public Buffer buffer = new Buffer(0,0,C0);
	
	public String archivoLectura = "asdasd";
	public String archivoEscritura = "ArchivoAEscribir.txt";
	
	@Test
	public void leerTresCampos(){
		
		inicioBuffer = 0;
		finBuffer = 3;
		buffer = new Buffer(inicioBuffer,finBuffer,C0);
		FileSystemAPI fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
		int bytesALeer = fileSystem.leerBytesSincronicamente(archivoLectura);
		assertEquals(4,bytesALeer);
		
		inicioBuffer = 4;
		finBuffer = 4;
		buffer = new Buffer(inicioBuffer,finBuffer,C1);
		fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
		bytesALeer = fileSystem.leerBytesSincronicamente(archivoLectura);
		assertEquals(1,bytesALeer);
		
		inicioBuffer = 5;
		finBuffer = 9;
		buffer = new Buffer(inicioBuffer,finBuffer,C2);
		fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
		bytesALeer = fileSystem.leerBytesSincronicamente(archivoLectura);
		assertEquals(5,bytesALeer);
	}
	
//	@Test
//	public void escribirCampos() {
//		byte[] bloque = {0,16,0};  //0X0,0X10,0X0
//		
//		inicioBuffer = 0;
//		finBuffer = 3;
//		buffer = new Buffer(inicioBuffer,finBuffer,C0);
//		FileSystemAPI fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
//		fileSystem.escribirBytes(archivoEscritura);
//		
//		inicioBuffer = 4;
//		finBuffer = 6;
//		buffer = new Buffer(inicioBuffer,finBuffer,bloque);
//		fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
//		fileSystem.escribirBytes(archivoEscritura);
//		
//		inicioBuffer = 7;
//		finBuffer = 7;
//		buffer = new Buffer(inicioBuffer,finBuffer,C1);
//		fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
//		fileSystem.escribirBytes(archivoEscritura);
//		
//		inicioBuffer = 8;
//		finBuffer = 12;
//		buffer = new Buffer(inicioBuffer,finBuffer,C2);
//		fileSystem = new FileSystemAPI(lowLevelFileSystem,buffer);
//		fileSystem.escribirBytes(archivoEscritura);
//	}
}
