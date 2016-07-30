package yakov.fain.lesson16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader{
    // Expands the zip file passed as argument 1, into the
    // directory provided in argument 2
    public static void main(String args[]) throws Exception{
        if(args.length != 2){
            System.err.println("zipreader zipfile outputdir");
            return;
        }

        // create a buffer to improve copy performance later.
        byte[] buffer = new byte[2048];

        // open the zip file stream
        InputStream theFile = new FileInputStream(args[0]);
        ZipInputStream stream = new ZipInputStream(theFile);
        String outdir = args[1];

        try {
            // now iterate through each item in the stream. The get next
            // entry call will return a ZipEntry for each file in the
            // stream
            ZipEntry entry;
            while((entry = stream.getNextEntry())!=null) {
                String s = String.format("Entry: %s len %d added %TD",
                                entry.getName(), entry.getSize(),
                                new Date(entry.getTime()));
                System.out.println(s);

                // Once we get the entry from the stream, the stream is
                // positioned read to read the raw data, and we keep
                // reading until read returns 0 or less.
                String outpath = outdir + "/" + entry.getName();
                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(outpath);
                    int len = 0;
                    while ((len = stream.read(buffer)) > 0)
                    {
                        output.write(buffer, 0, len);
                    }
                }
                finally {
                    // we must always close the output file
                    if(output!=null) output.close();
                }
            }
        }
        finally {
            // we must always close the zip file.
            stream.close();
        }
    }
}