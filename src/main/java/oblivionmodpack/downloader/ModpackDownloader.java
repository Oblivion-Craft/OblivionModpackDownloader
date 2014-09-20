package oblivionmodpack.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;


/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class ModpackDownloader 
{
    public static void main(String[] args)
    {
        try
        {
            URL website = new URL("http://bit.ly/CutenessFrickingOverloadPowerOver9000");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\CatsAreCute.jpg");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("Successfully downloaded the Cutest Picture Ever!");
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
