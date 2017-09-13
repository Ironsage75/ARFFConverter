package converter;

import converter.model.ClassAttribute;
import converter.model.DateAttribute;
import converter.model.HeaderAttribute;

import java.io.*;
import java.util.ArrayList;

/**
 * Converts a datafile to an ARFF file
 * Created by amy on 3/09/2017.
 */
public class ARFFConverter {
    private BufferedReader br = null;
    private FileReader fr = null;

    public ARFFConverter() {
    }

    /**
     * Converts a file and its corresponding headers to an ARFF File
     * @param filename The original file containing the actual data
     * @param headers Manually input header information
     */
    public void convert(String filename, ArrayList<HeaderAttribute> headers){
        //Get the fileroot to use as the basename for the created ARFF file
        String fileroot = filename.substring(filename.lastIndexOf("\\")+1);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileroot + "ARFF.txt"), "utf-8"))) { // Creates the file
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            /**
             * The Following code writes the header of the file
             * "@RELATION" is the rootname of the file, such as "car", "iris" ...
             * "@ATTRIBUTE" are the different values in the data file, their name and type (numeric, string, class, date)
             * and extra information for types class and date
             */
            writer.write("@RELATION " + fileroot.substring(0, fileroot.lastIndexOf(".")) +"\n\n");
            for (HeaderAttribute h : headers) {
                //Check if it's a date attribute, in which case the dateformat has to be added
                if (h.getClass() == DateAttribute.class && ((DateAttribute) h).getDateFormat() != null){
                    writer.write("@ATTRIBUTE " + h.getAttributeName() + " " + h.getAttributeType() +" '"+ ((DateAttribute) h).getDateFormat() + "'\n");
                }
                //Check if it's a class attribute, in which case a list of possible classes has to be added
                else if(h.getClass() == ClassAttribute.class){
                    String[] classes = ((ClassAttribute) h).getClasses();
                    writer.write("@ATTRIBUTE " + h.getAttributeName() + " {");
                    for(int i =0; i < classes.length; i++) {
                        // If it's the last class, don't write a comma
                        if(i+1 == classes.length){
                            writer.write(classes[i].trim());
                        } else {
                            writer.write(classes[i].trim() + ", ");
                        }
                    }
                    writer.write("}\n");
                } else {
                    //For any other type (numerical, string)
                    writer.write("@ATTRIBUTE " + h.getAttributeName() + " " + h.getAttributeType() + "\n");
                }
            }
            writer.write("\n");
            writer.write("@DATA\n");
            /**
             * The following code writes the body of the file, the actual data, by reading from the original data file
             */
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                writer.write(currentLine + "\n");
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
