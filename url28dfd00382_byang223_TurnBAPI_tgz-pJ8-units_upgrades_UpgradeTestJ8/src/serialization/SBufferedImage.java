package serialization;

/**
 * BufferedImage isn't serializable, needed to make this file in order to make that possible
 * @author 
 * 
 */

import java.io.IOException;
import java.io.Serializable;
import java.awt.image.BufferedImage;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
 
public class SBufferedImage implements Serializable{
 
  private long          id;
  private String        name;
  private BufferedImage image;
 
  public long getId(){return id;}
  public void setId(long id){this.id=id;}
 
  public String getName(){return name;}
  public void setName(String str){this.name=str;}
 
  public BufferedImage getImage(){return image;}
  public void setImage(BufferedImage image){this.image=image;}
 
 
  private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(name);
		ImageWriter writer = (ImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
	        writer.setOutput(ImageIO.createImageOutputStream(out));
	        ImageWriteParam param = writer.getDefaultWriteParam();
	        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	        param.setCompressionQuality(0.85f);
	        writer.write(null, new IIOImage(image, null, null), param);
	}
 
  private void readObject(java.io.ObjectInputStream in)throws IOException, ClassNotFoundException{
    name=(String)in.readObject();
    image=ImageIO.read(ImageIO.createImageInputStream(in));
  }
}