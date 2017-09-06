import model.HeaderAttribute;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by amy on 3/09/2017.
 */
public class ARFFConverter {
    private BufferedReader br = null;
    private FileReader fr = null;

    public ARFFConverter() {
    }

    public void convert(String filename, ArrayList<HeaderAttribute> headers){
        String fileroot = filename.substring(filename.lastIndexOf("\\")+1);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt"), "utf-8"))) {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            writer.write("@RELATION " + fileroot.substring(0, fileroot.lastIndexOf(".")) +"\n\n");
            for (HeaderAttribute h : headers) {
                writer.write("@ATTRIBUTE " + h.getAttributeName() + " " + h.getAttributeType() + "\n");
            }
            writer.write("\n");

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                //System.out.println(currentLine);
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) { br.close(); }
                if (fr != null) { fr.close(); }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
