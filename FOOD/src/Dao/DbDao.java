package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Foodbean;
import Beans.Orderbean;
import Beans.Signupbean;
	public class DbDao {
		public Connection Start() {
			Connection con=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappydb", "root", "");
			}catch(ClassNotFoundException | SQLException e) {System.out.println(e);}
			return con;}
	
		public int logincheck(String uid,String pwd) throws SQLException {
			int x=0;
			try (Connection con=Start()){
				PreparedStatement ps= con.prepareStatement("select * from login where uid=? and pwd=?");
				ps.setString(1, uid);
				ps.setString(2, pwd);
				ResultSet rs= ps.executeQuery();
				if(rs.next())
					x=1;
			}catch(SQLException e) {System.out.println(e);} //System.out.println(x);System.out.println(uid);	System.out.println(pwd);
			return x;	
		}// Admin logincheck     
		  
		   public int insertprod(Foodbean e) throws SQLException {
			  int x=0;
			   try (Connection con=Start()){
				   PreparedStatement ps= con.prepareStatement("insert into product(category,pname,price,description,image) values(?,?,?,?,?)");
				    ps.setString(1,e.getCategory() );
					ps.setString(2,e.getPname());
					ps.setString(3,e.getPrice());
					ps.setString(4,e.getDescription());
					ps.setString(5,e.getFile());
			     	x=ps.executeUpdate();
			   }catch(SQLException ex) {System.out.println(ex);}
			return x;
		   }//Admin insert product
		   
		   public ArrayList<Foodbean>  viewAllProduct() {
		 	  ArrayList<Foodbean> list=new ArrayList<Foodbean>();
		 	  try(Connection con=Start()) {
		 			PreparedStatement ps=con.prepareStatement("select * from product");
		 			 ResultSet rs=ps.executeQuery();
		 				while(rs.next()){
		 				 Foodbean e=new Foodbean();
		 				 e.setPid(rs.getInt("pid"));
		 				 e.setCategory(rs.getString("category"));
		 				 e.setPname(rs.getString("pname"));
		 				 e.setPrice(rs.getString("price"));
		 				 e.setDescription(rs.getString("description"));
		 				 e.setFile(rs.getString("image"));
		                   list.add(e);
		 			     }
		 				}catch(SQLException e){System.out.println(e);}
		 	  return list;
		   }//Admin view products(display block) 
		   
		   public int deleteproduct(String pname) {
		 	  int x=0;
		 		try(Connection con=Start()) {
		 	PreparedStatement ps=con.prepareStatement("delete from product where pname=?");
		 	ps.setString(1,pname);
		 	   x=ps.executeUpdate();
		 		}catch(SQLException ex){System.out.println(ex);}
				return x;
		   }//Admin Delete product
		 
		   public int updateproduct(Foodbean e) {
				  int x=0;
				  try(Connection con=Start()) {
	PreparedStatement ps=con.prepareStatement("update product set category=?,pname=?,price=?,description=? where pid=?");
					ps.setString(1, e.getCategory());
					ps.setString(2,e.getPname());
					ps.setString(3,e.getPrice());
					ps.setString(4,e.getDescription());
					ps.setInt(5,e.getPid());
					 x=ps.executeUpdate();
					 	}catch(SQLException ex) {System.out.println(ex);}
						return x;
			}//update product without image
		  
		   public int updateproductbyimage(Foodbean e) {
				  int x=0;
						try(Connection con=Start()) {
							
					PreparedStatement ps=con.prepareStatement("update product set image=? where pid=?");
					ps.setString(1,e.getFile());
					ps.setInt(2, e.getPid());
				     x=ps.executeUpdate();
					 	}catch(SQLException ex){System.out.println(ex);}
						return x;
			}//close update product by image
		   public Foodbean viewProductbyId(int pid) {
			   Foodbean e=new Foodbean();
		 		try(Connection con=Start()) {
		 			PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
		 			ps.setInt(1, pid);
		 			 ResultSet rs=ps.executeQuery();
		 				while(rs.next()) {
		 				e.setPid(rs.getInt("pid"));
		 				e.setPname(rs.getString("pname"));
		 				e.setCategory(rs.getString("category"));
		 				e.setPrice(rs.getString("price"));
		 				e.setDescription(rs.getString("description"));
		 				e.setFile(rs.getString("image"));
		 				
		 			     }
		 				}catch(SQLException ex){System.out.println(e);}
		 	  return e;
		   }
		   
		   public ArrayList<Signupbean> viewAllUsers() {
				ArrayList<Signupbean> list = new ArrayList<Signupbean>();
				try (Connection con = Start()) {
					PreparedStatement ps = con.prepareStatement("select * from zappysignup");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Signupbean e = new Signupbean();
						e.setFname(rs.getString("fname"));
						e.setLname(rs.getString("lname"));
						e.setEmail(rs.getString("email"));
						e.setPhone(rs.getString("phone"));
						e.setUpwd(rs.getString("upwd"));
						e.setCaddress(rs.getString("caddress"));
						list.add(e);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
				return list;
			}// display block for Admin can view registerd user
		   
		   public ArrayList<Foodbean> viewProductonindex() {
				ArrayList<Foodbean> list = new ArrayList<Foodbean>();
				try (Connection con = Start()) {
					PreparedStatement ps = con.prepareStatement("select * from product");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Foodbean fb = new Foodbean();
						fb.setPid(rs.getInt("pid"));
						fb.setPname(rs.getString("pname"));
						
						fb.setFile(rs.getString("image"));
						fb.setPrice(rs.getString("price"));
						list.add(fb);
					}
				} catch (SQLException e) {
					System.out.println(e);
				}return list;
			}// view product on index page
		   public ArrayList<Orderbean> viewAllPendingOrder() {
				ArrayList<Orderbean> list = new ArrayList<Orderbean>();
				try (Connection con = Start()) {
					PreparedStatement ps = con.prepareStatement("select * from placedorders where orderstatus=0");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Orderbean oe = new Orderbean();
						oe.setOrderid(rs.getInt("orderid"));
						oe.setPid(rs.getInt("pid"));
						oe.setQuantity(rs.getInt("quantity"));
						oe.setEmail(rs.getString("email"));
						oe.setPrice(rs.getString("price"));
				list.add(oe);						
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
				return list;
			}// display order placed by admin 
	/*	public int dispatch_user_order(String email) {
			 int x=0;
		 		try(Connection con=Start()) {
		 			System.out.println("Connected dispatch block");
		 	PreparedStatement ps=con.prepareStatement("select * from  placedorders where email=?");
		 	ps.setString(1,email);
		 	   ResultSet rs=ps.executeQuery();System.out.println("placedorder query for email"+ rs);
		 	   while(rs.next()) {
		 		  PreparedStatement ps1=con.prepareStatement("select caddress from zappysignup where email=?");
				 	ps.setString(1,email);
				 	   ResultSet rs1=ps.executeQuery();System.out.println("for address from signhup" + rs1);
				 	   while(rs1.next()) {
		 		   PreparedStatement ps2=con.prepareStatement("insert into dispatch(orderid,pid,quantity,price,email,caddress) values(?,?,?,?,?,?)");
				 	  ps2.setInt(1, rs.getInt("orderid"));
				 	  ps2.setInt(2,rs.getInt("pid"));
				 	  ps2.setInt(3, rs.getInt("quantity"));
				 	  ps2.setString(4, rs.getString("price"));
				 	  ps2.setString(5, rs.getString("email"));
				 	  ps2.setString(6, rs.getString("caddress"));
				 	   x=ps2.executeUpdate();System.out.println("dispatch" +x);
				 	   }
		 	   }
		 		}catch(SQLException ex){System.out.println(ex);}
				return x;		
		}*/

		public int dispatch_user_order(int orderid) throws SQLException {
			int x=0;
			try(Connection con=Start()) {
	 			System.out.println("Connected dispatch block");
	 	PreparedStatement ps=con.prepareStatement("select * from  placedorders where orderid=?");
	 	ps.setInt(1,orderid);
	 	   ResultSet rs=ps.executeQuery();
	 	   while(rs.next()) {
	 		  PreparedStatement ps1=con.prepareStatement("update placedorders set orderstatus=? where orderid=?"); 
	 		   ps1.setInt(1, 1);
	 		   ps1.setInt(2, rs.getInt("orderid"));
	 		  int y= ps1.executeUpdate();
	 	   }
			return x;
		}
		}//end of dispatch_user_order
		public	String  email_dispatch_user_order(int  orderid)throws SQLException  {
			String sendemail = null;
			try (Connection con = Start()) {
				System.out.println("------------> String  email_dispatch_user_order");
				PreparedStatement ps = con.prepareStatement("select email from placedorders where orderid=?");
				ps.setInt(1, orderid);System.out.println(orderid);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					sendemail=rs.getString("email");
					System.out.println(sendemail);
					}
		} catch (SQLException e) {System.out.println(e);}
			return sendemail;
				
		}//end of email_dispatch_user_order
		   
		
		public ArrayList<Orderbean> viewOrderHistroy() {
			ArrayList<Orderbean> list = new ArrayList<Orderbean>();
			try (Connection con = Start()) {  
				System.out.println("------------> connected Order Status cart");
				PreparedStatement ps = con.prepareStatement("select * from placedorders");
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
		}

	} 

