package org.example.homework.Commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.homework.Catalog.Catalog;
import org.example.homework.Exceptions.CommandException;
import org.example.homework.Exceptions.CustomException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReportFCommand extends CommandUtil {
    private final String outputPath;

    public ReportFCommand(Catalog catalog, String outputPath) {
        super(catalog);
        this.outputPath = outputPath;
    }

    /**
     * Metoda foloseste FreeMarker template (adaugat in dependencies)
     * si genereaza un raport HTML, bazat pe fisierul report.ftl(freemarker template) cu locatia in directorul src/main/resources/templates
     * Raportul generat contine numele catalogului si un tabel cu documentele incluse in el.
     * <p>
     * In interiorul acestei metode, se configureaza si se utilizeaza FreeMarker pt a genera un raport in format HTML. Incarc un fisier de sablon numit report.ftl dintr-un director templates si se pregatesc datele
     * ce urmeaza sa fie introduse in sablon.
     * Aceste date sunt stocate intr-un obiect de tip Map si includ o cheie- string „catalog”, care are ca valoare asociata catalogul.     * Apoi, se genereaza fisierul de iesire HTML folosind sablonul si datele pregatite, si se salveaza
     * intr-un fisier cu calea in variabila outputPath. Se deschide fisierul de iesire in browserul implicit utilizand metoda
     * Desktop.getDesktop().browse(outputFile.toURI()) din clasa Desktop
     */
    @Override
    public void implementCommand() throws CommandException {
        try {
            // configurez folosind FreeMarker template engine
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setClassForTemplateLoading(getClass(), "/templates");

            // Incarc template-ul
            Template template = cfg.getTemplate("report.ftl");

            // Pregatesc data ce urmeaza introdusa in template
            Map<String, Object> data = new HashMap<>();
            data.put("catalog", catalog);

            // Generez outputul HTML
            File outputFile = new File(outputPath);
            FileWriter writer = new FileWriter(outputFile);
            template.process(data, writer);
            writer.flush();
            writer.close();

            // Deschid fisierul output folosind Browserul default
            Desktop.getDesktop().browse(outputFile.toURI());

        } catch (IOException | TemplateException e) {
            throw new CommandException("Raport Command failed" + e.getMessage());
        }
    }
}
