package thisIsTheGroupId;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import io.nayuki.qrcodegen.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QrCode qr0 = QrCode.encodeText(args[0], io.nayuki.qrcodegen.QrCode.Ecc.MEDIUM);
        BufferedImage img = qr0.toImage(4,10); 
        try{ 
            ImageIO.write(img, "png", new File(args[1]));
        } catch(IOException e) { 
            e.printStackTrace();
        }
        
        System.out.println( args[0] );
    }
}

/*
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import io.nayuki.qrcodegen.*;

// Simple operation
QrCode qr0 = QrCode.encodeText("Hello, world!", QrCode.Ecc.MEDIUM);
BufferedImage img = qr0.toImage(4, 10);
ImageIO.write(img, "png", new File("qr-code.png"));

// Manual operation
List<QrSegment> segs = QrSegment.makeSegments("3141592653589793238462643383");
QrCode qr1 = QrCode.encodeSegments(segs, QrCode.Ecc.HIGH, 5, 5, 2, false);
for (int y = 0; y < qr1.size; y++) {
    for (int x = 0; x < qr1.size; x++) {
        (... paint qr1.getModule(x, y) ...)
    }
}
*/
