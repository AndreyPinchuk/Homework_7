package homework_7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private static String IMAGE_DESTINATION_FOLDER = "./image/";

    public void downLoadImage(String strImage){
        String strImageName = strImage.substring(strImage.lastIndexOf("/")+1);
        System.out.println("Saving: "+strImageName+", from: "+strImage);

        try {
            URL urlImage = new URL(strImage);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os = new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/"+strImageName);

            while ((n=in.read(buffer)) != -1){
                os.write(buffer,0,n);
            }

            os.close();
            System.out.println("Image saved");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
