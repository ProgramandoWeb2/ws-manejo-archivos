package pe.edu.cibertec.ws_manejo_archivos.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
@Service
public class FileService {

    private static final String FILE_PATH = "prueba.txt";

    public void crearEscribirArchivo() throws IOException{
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            DataOutputStream dataOutputStream = new DataOutputStream(
                    fileOutputStream)){
            dataOutputStream.writeInt(2024);
            dataOutputStream.writeDouble(70000.6);
            dataOutputStream.writeUTF("Desarrollo de servicios web 2");
        }
    }

    public void abrirLeerArchivo() throws IOException{
        try(FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream)){
            int anio = dataInputStream.readInt();
            double precio = dataInputStream.readDouble();
            String nombreCurso = dataInputStream.readUTF();
            log.info("Año: " + anio);
            log.info("precio: "+ precio);
            log.info("curso: " + nombreCurso);
        }
    }

}
