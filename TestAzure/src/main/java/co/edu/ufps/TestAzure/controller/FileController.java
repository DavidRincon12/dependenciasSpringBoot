package co.edu.ufps.TestAzure.controller;

import co.edu.ufps.TestAzure.service.AzureBlobStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private AzureBlobStorageService storageService;

    // Endpoint para subir un archivo
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String blobUrl = storageService.uploadFile(file);
            return ResponseEntity.ok("Archivo subido exitosamente: " + blobUrl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al subir el archivo: " + e.getMessage());
        }
    }

    // Endpoint para eliminar un archivo
    @DeleteMapping("/{fileName}")
    public ResponseEntity<?> deleteFile(@PathVariable String fileName) {
        try {
            storageService.deleteFile(fileName);
            return ResponseEntity.ok("Archivo eliminado correctamente: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el archivo: " + e.getMessage());
        }
    }
}
