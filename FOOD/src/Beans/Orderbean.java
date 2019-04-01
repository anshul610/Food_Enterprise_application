package Beans;

public class Orderbean {
int pid,quantity,orderstatus,orderid;
String email,price;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}

public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getOrderstatus() {
	return orderstatus;
}
public void setOrderstatus(int orderstatus) {
	this.orderstatus = orderstatus;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

}
