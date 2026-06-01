package visual.cryptography.technique.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import visual.cryptography.technique.bean.Bean;
import visual.cryptography.technique.dbconnection.DbConnection;

public class SecurityDAO extends DbConnection {
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Bean> al = new ArrayList<Bean>();
	int i = 0;
	public SecurityDAO() {
		con = getConnection();
	}
	public int  register(Bean b)throws Exception {
		ps = con.prepareStatement("insert into userdetails(uname,email,password,mobile,dob,address,status)values(?,?,?,?,?,?,'in active')");
		ps.setString(1, b.getUname());
		ps.setString(2, b.getEmail());
		ps.setString(3, b.getPassword());
		ps.setString(4, b.getMobile());
		String da = b.getDob();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(sd.parse(da).getTime());
		ps.setDate(5, date);
		ps.setString(6, b.getAddress());
		i= ps.executeUpdate();
		return i;
	}
	
	public ArrayList<Bean> login(Bean b)throws Exception {
		ps = con.prepareStatement("select uid,uname,email from userdetails where email=? and password=? and status='active'");
		ps.setString(1, b.getEmail());
		ps.setString(2, b.getPassword());
		ResultSet rs= ps.executeQuery();
		while(rs.next()) 
		{
			Bean login = new Bean();
			login.setUid(rs.getInt(1));
			login.setUname(rs.getString(2));
			login.setEmail(rs.getString(3));
			al.add(login);
		}
		return al;
	}
	public int  adminAcceptNewUser(int uid)throws Exception {
		ps = con.prepareStatement("update userdetails set status='active' where uid=?");
		ps.setInt(1,uid);
		i=ps.executeUpdate();
		return i;
	}
	
	public int  userSendMessage(Bean b)throws Exception {
		ps = con.prepareStatement("insert into message(sid,rid,sname,rname,image1,image2,image3,secretimage,skey,encryptedimage,encryptedkey,sharedimage,status)values(?,?,?,?,?,?,?,?,?,?,?,?,'waiting at admin')");
		ps.setInt(1, b.getSid());
		ps.setInt(2, b.getRid());
		ps.setString(3, b.getSname());
		ps.setString(4, b.getRname());
		ps.setBytes(5, b.getImage1());
		ps.setBytes(6, b.getImage2());
		ps.setBytes(7, b.getImage3());
		ps.setBytes(8, b.getSecimage());
		ps.setString(9, b.getKey());
		ps.setBytes(10, b.getEncimage());
		ps.setString(11, b.getEnckey());
		ps.setBytes(12, b.getSharedimage());
		i= ps.executeUpdate();
		return i;
	}
	
	public int adminAcceptUserMessage(int mid)throws Exception {
		ps = con.prepareStatement("update message set status='Received' where mid=?");
		ps.setInt(1, mid);
		i=ps.executeUpdate();
		return i;
	}
	
	public int feedback(Bean b)throws Exception {
		ps = con.prepareStatement("insert into feedback(name,email,feedback)values(?,?,?)");
		ps.setString(1, b.getUname());
		ps.setString(2, b.getEmail());
		ps.setString(3, b.getMobile());
		i=ps.executeUpdate();
		return i;
	}
}