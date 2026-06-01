package visual.cryptography.technique.dao;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;

import sun.awt.image.ByteArrayImageSource;
import visual.cryptography.technique.bean.Bean;
import visual.cryptography.technique.dbconnection.DbConnection;
import visual.cryptography.technique.util.ImageEncDec;

public class ViewDAO extends DbConnection {
	Connection con  = null;
	PreparedStatement ps = null;
	ArrayList<Bean> al = new ArrayList<Bean>();
	public ViewDAO() {
		con=getConnection();
	}
	public ArrayList<Bean> adminViewNewUser()throws Exception {
		ps = con.prepareStatement("select uid,uname,email,dob,mobile,address from userdetails where status='in active'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setDob(rs.getString(4));
			b.setMobile(rs.getString(5));
			b.setAddress(rs.getString(6));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> adminViewUser()throws Exception {
		ps = con.prepareStatement("select uid,uname,email,dob,mobile,address from userdetails where status='active'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setDob(rs.getString(4));
			b.setMobile(rs.getString(5));
			b.setAddress(rs.getString(6));
			al.add(b);
		}
		return al;
	}
	public ArrayList<Bean> userSelectUser(int uid)throws Exception {
		System.out.println("the user id"+uid);
		ps = con.prepareStatement("select uid,uname from userdetails where status='active'");
	//	ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewSendedMessage(int uid)throws Exception {
		ps = con.prepareStatement("select mid,rid,rname,status from message where sid=?");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setRid(rs.getInt(2));
			b.setRname(rs.getString(3));
			b.setStatus(rs.getString(4));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewReceivedMessage(int uid)throws Exception {
		ps = con.prepareStatement("select mid,sid,sname,skey from message where rid=? and status='Received'");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setSid(rs.getInt(2));
			b.setSname(rs.getString(3));
			b.setKey(rs.getString(4));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewSendedImages(int mid)throws Exception {
		float scaleFactor =0.2f;
	    RescaleOp rescale;
	    BufferedImage buffer = null;
		ps = con.prepareStatement("select secretimage,encryptedimage,image1,image2,image3,sharedimage,encryptedkey from message where mid=?");
		ps.setInt(1, mid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setSecimage(rs.getBytes(1));
			byte[] sharedimage = rs.getBytes(2);
			String encodedKey = rs.getString(7);
			byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
			SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			byte[] decimage = ImageEncDec.decryptFile(originalKey, sharedimage);
			
			InputStream ips = new ByteArrayInputStream(decimage);
			 	buffer = ImageIO.read(ips);
			 	rescale = new RescaleOp(scaleFactor,10.0f, null);
				buffer=rescale.filter(buffer,null);
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(buffer, "jpg", baos);
				byte[] bytecontrast = baos.toByteArray();
				
			b.setEncimage(bytecontrast);
			b.setImage1(rs.getBytes(3));
			b.setImage2(rs.getBytes(4));
			b.setImage3(rs.getBytes(5));
			b.setSharedimage(rs.getBytes(6));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> adminViewMessageForAccept()throws Exception {
		ps = con.prepareStatement("select mid,sname,rname from message where status='waiting at admin'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setSname(rs.getString(2));
			b.setRname(rs.getString(3));
			al.add(b);
		}
		return al;
	}
	
	public byte[] userViewReceivedImages(int mid)throws Exception {
		Thread.sleep(5000);
		ps = con.prepareStatement("select encryptedimage,encryptedkey from message where mid=?");
		ps.setInt(1, mid);
		byte[] decimage = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			byte[] encImage = rs.getBytes(1);
			String encodedKey = rs.getString(2);
			byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
			SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			decimage = ImageEncDec.decryptFile(originalKey, encImage);
		}
		return decimage;
	}
	
	public ArrayList<Bean> adminViewAcceptedMessages()throws Exception {
		ps = con.prepareStatement("select mid,sid,rid,sname,rname from message where status='Received'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setSid(rs.getInt(2));
			b.setRid(rs.getInt(3));
			b.setSname(rs.getString(4));
			b.setRname(rs.getString(5));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> adminViewFeedback()throws Exception {
		ps = con.prepareStatement("select fid,name,email,feedback from feedback");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setMobile(rs.getString(4));
			al.add(b);
		}
		return al;
	}
}