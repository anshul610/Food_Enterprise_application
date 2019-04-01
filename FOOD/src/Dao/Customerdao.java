package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import Beans.Cartdisplay;
import Beans.Foodbean;
import Beans.Orderbean;
import Beans.Signupbean;
public class Customerdao {
	public Connection Start() {
		Connection con = null;
		try { Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappydb", "root", "");
		} catch (ClassNotFoundException | SQLException e) {System.out.println(e);}
		return con;
		}
	public int signupdetails(Signupbean sub) throws SQLException {
		
		int x = 0;
		try (Connection con = Start()) {
			System.out.println("------------> connected Signupdetalis");
			PreparedStatement ps = con.prepareStatement(
					"insert into zappysignup(fname,lname,email,phone,upwd,caddress)values(?,?,?,?,?,?)");
			ps.setString(1, sub.getFname());   System.out.println(sub.getFname());
			ps.setString(2, sub.getLname());    System.out.println(sub.getLname());
			ps.setString(3, sub.getEmail());   System.out.println();
			ps.setString(4, sub.getPhone());System.out.println(sub.getPhone());
			ps.setString(5, sub.getUpwd());System.out.println(sub.getUpwd());
			ps.setString(6, sub.getCaddress());System.out.println(sub.getCaddress());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println();
		}
		return x; 
		
	}// customer insert details 
	

	public int Duplicateemailcheck(String email) {
		int x = 0;
		try (Connection con = Start()) {
			System.out.println("------------> connected Duplicateemailcheck");
			PreparedStatement ps = con.prepareStatement("select * from zappysignup where email=?");
			ps.setString(1, email); System.out.println(email);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				x = 1;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return x;
	}// Customer duplicate emailcheck

	public int Clogincheck(String email, String upwd) throws SQLException {
		int x = 0;
		try (Connection con = Start()) {
			System.out.println("------------> connected  Clogincheck");
			PreparedStatement ps = con.prepareStatement("select * from zappysignup where email=? and upwd=?");
			ps.setString(1, email);System.out.println(email);
			ps.setString(2, upwd);System.out.println(upwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				x = 1;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return x;
	}// Customer logincheck

	public int deletecustomer(String email, String upwd) {
		int x = 0;
		try (Connection con = Start()) {
			System.out.println("------------> connected deletecustomer");
			PreparedStatement ps = con.prepareStatement("delete from  zappysignup where email=? and upwd=?");
			ps.setString(1, email);System.out.println(email);
			ps.setString(2, upwd);System.out.println(upwd);
			x = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return x;
	}// customer Delete
	
	public int Addcartdao(int pid, int quantity,String pname,String price,String email,String file) {
		int x = 0;
		try (Connection con = Start()) {
			System.out.println("------------> connected Add product in cart");
			
			PreparedStatement ps = con
					.prepareStatement("insert into addprocart(pid,quantity,email,pname,price,file)values(?,?,?,?,?,?)");
			ps.setInt(1, pid);System.out.println("1--"+pid);
			ps.setInt(2, quantity);System.out.println("2--"+quantity);
			ps.setString(3, email);System.out.println("3--"+email);
			ps.setString(4, pname);System.out.println("4--"+pname);
			ps.setString(5, price);System.out.println("5--"+price);
			ps.setString(6,file);System.out.println("6--"+file);
			x = ps.executeUpdate();System.out.println("---------->query excuted connected Addcartdao"  +x);
		} catch (SQLException ex) {System.out.println(ex);}
		return x;
	}// Add product to cart
	
	public int viewPid(int pid,String email) {
		try (Connection con = Start()) {
			int x=0;
			PreparedStatement ps = con.prepareStatement("select *from addprocart where pid=? and email=?");
			ps.setInt(1, pid);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return 0;}			
		} catch (SQLException e) {System.out.println(e);}
		return 1;
	}//Check Duplicate product in cart
	
	public int updateproductQuantity(int quantity, String email,int pid) {
		  int x=0;
				try(Connection con=Start()) {	
					System.out.println("updateproductQuantity");
			PreparedStatement ps=con.prepareStatement("update addprocart set quantity=quantity+? where email=? and pid=?");
			ps.setInt(1,quantity);System.out.println(quantity);
			ps.setString(2,email);System.out.println(email);
			ps.setInt(3, pid);
		     x=ps.executeUpdate();
		     System.out.println("---------->update quantity"  +x);
			 	}catch(SQLException ex){System.out.println(ex);}
				return x;
	}//close update product by image
		
	public ArrayList<Cartdisplay> viewCartItems(String email) {
		ArrayList<Cartdisplay> list = new ArrayList<Cartdisplay>();
		try (Connection con = Start()) {  
			System.out.println("------------> connected display user cart");
			PreparedStatement ps = con.prepareStatement("select * from addprocart where email=?");
			ps.setString(1, email);  System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {  
				Cartdisplay cad = new Cartdisplay();
				cad.setPid(rs.getInt("pid")); System.out.println(rs.getInt("pid"));
				cad.setQuantity(rs.getInt("quantity"));System.out.println(rs.getInt("quantity"));
				cad.setPname(rs.getString("pname"));System.out.println(rs.getString("pname"));
				cad.setPrice(rs.getString("price"));System.out.println(rs.getString("price"));
				cad.setFile(rs.getString("file"));System.out.println(rs.getString("file"));
				list.add(cad);
				}
		} catch (SQLException e) {System.out.println(e);}
		return list;
	}/// display user cart
	public int productremovecart(int pid) {
		int x = 0;
		try (Connection con = Start()) {
			System.out.println("------------> connected productremovecart");
			PreparedStatement ps = con.prepareStatement("delete from addprocart where pid=?");
			ps.setInt(1, pid); System.out.println("pid");
			x = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return x;
	}// customer product Delete
	

	public int orderplace(String email) {
		int x = 0; int orderstatus=0;	
		try (Connection con = Start()) {
			System.out.println("------------>connected orderplace");
			PreparedStatement ps = con.prepareStatement("select * from addprocart where email=?");
		ps.setString(1, email);System.out.println(email);
		ResultSet rs = ps.executeQuery();
			while(rs.next()){
			PreparedStatement ps_ord= con.prepareStatement("insert into placedorders(pid,quantity,email,price,orderstatus)values(?,?,?,?,?)");
			ps_ord.setInt(1, rs.getInt("pid"));
			ps_ord.setInt(2, rs.getInt("quantity"));
			ps_ord.setString(3, rs.getString("email"));
			ps_ord.setString(4, rs.getString("price"));
			ps_ord.setInt(5, orderstatus);
			x = ps_ord.executeUpdate();System.out.println("---Placed order query result------------>"  +	x );
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return x;
	}// order placed
	public int empty_cart_after_orderplaced(String email) {
		int x = 0;
		try (Connection con = Start()) {
			PreparedStatement ps = con.prepareStatement("delete from addprocart where email=?");
			ps.setString(1,email);
			x = ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return x;
	}// empty_cart_after_orderplaced

	public ArrayList<Orderbean> viewOrderStatus(String email) {
		ArrayList<Orderbean> list = new ArrayList<Orderbean>();
		try (Connection con = Start()) {  
			System.out.println("------------> connected Order Status cart");
			PreparedStatement ps = con.prepareStatement("select * from placedorders where email=?");
			ps.setString(1, email);  System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {  
				Orderbean oe = new Orderbean();
				oe.setOrderid(rs.getInt("orderid")); System.out.println(rs.getInt("orderid"));
				oe.setPid(rs.getInt("pid")); System.out.println(rs.getInt("pid"));
				oe.setQuantity(rs.getInt("quantity"));System.out.println(rs.getInt("quantity"));
				oe.setPrice(rs.getString("price"));System.out.println(rs.getString("price"));
				oe.setEmail(rs.getString("email"));System.out.println(rs.getString("email"));
				oe.setOrderstatus(rs.getInt("orderstatus"));System.out.println(rs.getString("orderstatus"));
			list.add(oe);
				}
		} catch (SQLException e) {System.out.println(e);}
		return list;
	}// view order status
	public String Forgotpassword(String email) {
		 String fpassword = null;
		try (Connection con = Start()) {
			System.out.println("------------> connected  Forgotpassword");
			PreparedStatement ps = con.prepareStatement("select upwd from zappysignup where email=?");
			ps.setString(1, email);System.out.println(email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   fpassword=rs.getString("upwd");
				System.out.println(fpassword);
				}
	} catch (SQLException e) {System.out.println(e);}
		return fpassword;
	}// Customer forgot Password

	}//Class Customer 

	 
	
	