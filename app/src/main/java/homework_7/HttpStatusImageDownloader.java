package homework_7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private static String IMAGE_DESTINATION_FOLDER = "./image/";

    public void downLoadImage(int code){

        //ќтриманий код збираю в посиланн€ та в≥дправл€ю на перев≥рку статусу
        String strImage = new HttpStatusChecker().getStatusImage(code);

        String strImageName = strImage.substring(strImage.lastIndexOf("/")+1);
        System.out.println("Saving: "+strImageName+", from: "+strImage);

        try(OutputStream os = new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/"+strImageName)) {

            URL urlImage = new URL(strImage);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            while ((n=in.read(buffer)) != -1){
                os.write(buffer,0,n);
            }

            System.out.println("Image saved");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
