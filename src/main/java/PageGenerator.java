import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Created by faa11 on 24.12.2015.
 */
public class PageGenerator {
    public static final String HTML_DIR = "templates";
    public static PageGenerator pageGenerator;
    private final Configuration cfg;
    public  static PageGenerator instance(){
        if(pageGenerator == null)
            pageGenerator = new PageGenerator();

        return pageGenerator;
    }
    public String getPage(String filename, Map<String, Object> data){
        Writer stream = new StringWriter();
        try{
            Template template = cfg.getTemplate(HTML_DIR+ File.separator+filename);
            template.process(data, stream);
        }
        catch (IOException |TemplateException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }
    private PageGenerator() {cfg = new Configuration();}
}
