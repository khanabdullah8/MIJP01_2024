package visual.cryptography.technique.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.Buffer;

import sun.awt.image.ByteArrayImageSource;
import visual.cryptography.technique.bean.Bean;
import visual.cryptography.technique.dao.SecurityDAO;
import visual.cryptography.technique.util.ContentEncrypt;
import visual.cryptography.technique.util.GenerateImage;
import visual.cryptography.technique.util.ImageEncDec;

@WebServlet("/SendMessageServlet_user")
public class SendMessageServlet_user extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = new Bean();
		ContentEncrypt cc = new ContentEncrypt("passPhrase");
		SecretKey secretKey = null;
		byte[] encryptedimage = null;
		String encodedKey = null;
		BufferedImage getrandomimg = null;
		BufferedImage secretimage = null;
		BufferedImage sharedimage1 = null;
		BufferedImage sharedimage2 = null;
		BufferedImage sharedimage3 = null;
		
		byte[] secretimagebytes = null;
		HttpSession ses = request.getSession();
		int uid = (Integer)ses.getAttribute("uid");
		System.out.println("login Uid---->"+uid);
		String sname = (String)ses.getAttribute("uname");
		String mail = (String)ses.getAttribute("email");
		try {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		List li = fileUpload.parseRequest(request);
		
		FileItem user=(FileItem) li.get(0);
		
		String receiver = user.getString();
		String[] data = receiver.split(",");
		int ruid = Integer.parseInt(data[0]);
		String runame = data[1];
		
		FileItem cimage1=(FileItem) li.get(1);
		FileItem cimage2=(FileItem) li.get(2);
		FileItem cimage3=(FileItem) li.get(3);
		FileItem simage=(FileItem) li.get(4);
		
		 byte[] imagebyte1 = cimage1.get();
		 byte[] imagebyte2 = cimage2.get();
		 byte[] imagebyte3 = cimage3.get();
		 byte[] simagebyte = simage.get();
		 
		 InputStream is1 = new ByteArrayInputStream(imagebyte1);
		 InputStream is2 = new ByteArrayInputStream(imagebyte2);
		 InputStream is3 = new ByteArrayInputStream(imagebyte3);
		 InputStream sis = new ByteArrayInputStream(simagebyte);
		 
		 BufferedImage imagebuffer1 = ImageIO.read(is1);
		 int width1 = imagebuffer1.getWidth();
		 int height1 = imagebuffer1.getHeight();
		 
		 BufferedImage imagebuffer2 = ImageIO.read(is2);
		 int width2 = imagebuffer2.getWidth();
		 int height2 = imagebuffer2.getHeight();
		 
		 BufferedImage imagebuffer3 = ImageIO.read(is3);
		 int width3 = imagebuffer3.getWidth();
		 int height3 = imagebuffer3.getHeight();
		 
		 BufferedImage sisbuffer = ImageIO.read(sis);
		 int width = sisbuffer.getWidth();
		 int height = sisbuffer.getHeight();
		 
		 Random rand = new Random();
		 Long lo =(long)rand.nextInt(1000000000);
		 String key = lo.toString();
		 
		 
		 String  ekey = cc.encrypt(key);
		 if(ekey!=null) 
		 {
			 Thread.sleep(6000);
			 KeyGenerator keygen = KeyGenerator.getInstance("AES");
			 keygen.init(128);
			 secretKey = keygen.generateKey();
			 encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
			 encryptedimage = ImageEncDec.encryptFile(secretKey, simagebyte);
			 if(encryptedimage!=null) 
			 {
				 /*InputStream eimage = new ByteArrayInputStream(encryptedimage);
				 BufferedImage eimagebuffer = ImageIO.read(eimage);*/
				 
				 
			     getrandomimg = GenerateImage.getRandomizedImage(width,height);
				 sharedimage1 = GenerateImage.getRandomizedImage(width1,height1);
				 sharedimage2 = GenerateImage.getRandomizedImage(width2,height2);
				 sharedimage3 = GenerateImage.getRandomizedImage(width3,height3);
				 
				 secretimage = GenerateImage.secretImage(sharedimage1, sharedimage2, sharedimage3, getrandomimg);
				 if(secretimage!=null) 
				 {
					 	ByteArrayOutputStream baos = new ByteArrayOutputStream();
				        ImageIO.write(secretimage,"png", baos);
				        secretimagebytes = baos.toByteArray();
				 }
			 }
			 
		 }else
		 {
			 System.out.println("Key is null");
		 }
		 
		 if(secretimagebytes!=null) {
		 
			 /*String path ="D:\\image1.jpg";
			 File fi = new File(path);
		     ImageIO.write(secretimage, "jpg", fi);*/
		 
			 b.setSid(uid);
			 b.setSname(sname);
			 b.setRid(ruid);
			 b.setRname(runame);
			 b.setImage1(imagebyte1);
			 b.setImage2(imagebyte2);
			 b.setImage3(imagebyte3);
			 b.setSecimage(simagebyte);
			 b.setKey(key);//key
			 b.setEncimage(encryptedimage);
			 b.setEnckey(encodedKey);//encrypted key
			 b.setSharedimage(secretimagebytes);
			 
			 int i = new SecurityDAO().userSendMessage(b);
			 
			 if(i!=0) {
			 RequestDispatcher rd = request.getRequestDispatcher("sendMessage_user.jsp?status=Secret Image sended Successfully");
			 rd.include(request, response);
			 }
			 else 
			 {
				 RequestDispatcher rd = request.getRequestDispatcher("sendMessage_user.jsp?status=Faild to Send");
				 rd.include(request, response);
			 }
			 
		 }else 
		 {
			 RequestDispatcher rd = request.getRequestDispatcher("sendMessage_user.jsp?status=Image Should be in .jpg or .png or .jpeg format");
			 rd.include(request, response);
		 }
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("sendMessage_user.jsp?status=Some Internal Error");
			 rd.include(request, response);
		}
	}
}