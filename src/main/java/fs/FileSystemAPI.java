package fs;

import java.util.function.Consumer;

import SuperFileSystem.exceptions.ArchivoNoExistenteException;
import SuperFileSystem.exceptions.LecturaErroneaException;

public class FileSystemAPI {
	public LowLevelFileSystem sistema;
	public Buffer buffer;
	
	public FileSystemAPI(LowLevelFileSystem sistema, Buffer buffer){
		this.sistema = sistema;
		this.buffer = buffer;
	}
	
	public int abrirArchivo(String nombreArchivo) {
		int valorDeRetorno = sistema.openFile(nombreArchivo);
		if(valorDeRetorno == -1) {
			throw new ArchivoNoExistenteException("No se pudo abrir el archivo.");
		}
		
		return valorDeRetorno;
	}
	
	public void cerrarArchivo(int identificadorArchivo) {
		sistema.closeFile(identificadorArchivo);
	}
	
	public int leerBytesSincronicamente(String nombreArchivo) {
		int identificadorArchivo = this.abrirArchivo(nombreArchivo);
		int bytesALeer = sistema.syncReadFile(identificadorArchivo, buffer.getBytes(), buffer.getInicio(), buffer.getFin());
		if(bytesALeer == -1) {
			throw new LecturaErroneaException("No se pudo leer el archivo.");
		}
		
		this.cerrarArchivo(identificadorArchivo);
		return bytesALeer;
	}
	
	public void escribirBytes(String nombreArchivo){
		int identificadorArchivo = this.abrirArchivo(nombreArchivo);
		sistema.syncWriteFile(identificadorArchivo, buffer.getBytes(), buffer.getInicio(), buffer.getFin());
		cerrarArchivo(identificadorArchivo);
	}
	
	public void leerBytesAsincronicamente(String nombreArchivo, Consumer<Integer> continuacion){
		int identificadorArchivo = this.abrirArchivo(nombreArchivo);
		sistema.asyncReadFile(identificadorArchivo, buffer.getBytes(), buffer.getInicio(), buffer.getFin(), continuacion);
		cerrarArchivo(identificadorArchivo);
	}
}

