package org.example.homework.Catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.homework.Document.Document;
import org.example.homework.Exceptions.InvalidCatalogException;

import java.io.File;
import java.io.IOException;

/**
 * Clasa include operatiile ce pot fi facute asupra unui obiect de tip Catalog
 */
public class CatalogUtil {
    /**
     * @param catalog    - catalogul pe care dorim sa il salvam(serializam)
     * @param path-calea in care se va salva documentul .json
     * @throws IOException- este posibil ca incercarea de a scrie in locatia path
     *                      sa arunce o exceptie input output
     */
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    /**
     * @param path-calea obiectului ce urmeaza deserializat
     * @throws InvalidCatalogException - indiferent de exceptia de la incarcarea fisierului(nu e fisierul bun, e corupt binar
     *                                 nu mai poate fi facuta deserializarea, am modificat signatura clasei catalorg etc, pot sa revin dupa exceptie deci o facem checked
     *                                 astfel try catch  throw new InvalidCatalogException() este obligatorie aici
     * @return-un obiect de tip Catalog
     */
    public static Catalog load(String path) throws InvalidCatalogException {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
            return catalog;
        } catch (IOException e) {
            throw new InvalidCatalogException("Error loading catalog: " + e.getMessage());
        }
    }

    /**
     * afiseaza detaliile unui document primit ca parametru
     *
     * @param doc-documentul ce va fi vizualizat
     */
    public static void view(Document doc) throws IOException {
        doc.open();
    }
}
