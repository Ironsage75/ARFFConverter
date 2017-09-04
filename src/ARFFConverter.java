import java.io.*;

/**
 * Created by amy on 3/09/2017.
 */
public class ARFFConverter {
    private String filename = null;
    private String[] headers = null;
    private BufferedReader br = null;
    private FileReader fr = null;
    private FileWriter fw = null;

    public ARFFConverter(String filename, String[] headers) {
        this.filename = filename;
        this.headers = headers;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public void convert(){
        String fileroot = this.filename.substring(filename.lastIndexOf("\\"), filename.lastIndexOf("."));
        try {
            fr = new FileReader(this.filename);
            br = new BufferedReader(fr);
            fw = new FileWriter("../" + fileroot + "ARFF.txt");

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) { br.close(); }
                if (fr != null) { fr.close(); }
                if (fw != null) { fw.close(); }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
