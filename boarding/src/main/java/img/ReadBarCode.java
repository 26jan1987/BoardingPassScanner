package img;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadBarCode {

	public static void main(String[] args) throws IOException, NotFoundException, ChecksumException, FormatException {

		InputStream barCodeInputStream = new FileInputStream("D:/Shashank/DEMO_PDF_TO_IMG/images/BPass_4.jpg");
		System.out.println("1");
		BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);
		System.out.println(barCodeBufferedImage.getHeight());
		System.out.println(barCodeBufferedImage.getWidth());
		barCodeBufferedImage = barCodeBufferedImage.getSubimage(0, 0, 918, 689);
		System.out.println(barCodeBufferedImage.getHeight());
		System.out.println(barCodeBufferedImage.getWidth());
		System.out.println("2");
		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		System.out.println("3");
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		System.out.println("4");
		Reader reader = new MultiFormatReader();
		System.out.println("5");
		Result result = reader.decode(bitmap);
		System.out.println(result.getBarcodeFormat());
		System.out.println("Barcode text is " + result.getText());
	}

}
