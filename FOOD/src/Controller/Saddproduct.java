package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Beans.Foodbean;
import Dao.DbDao;

@WebServlet("/Saddproduct")
public class Saddproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath;
	private int maxFileSize = 1000 * 4096;
	private int maxMemSize = 1000 * 4096;
	private File file;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);// true
		if (!isMultipart) {
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);// Location to save data that is larger than maxMemSize.
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);
		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request); // formfied-2 Non FormField-1 // Process the uploaded file
															// items
			Iterator i = fileItems.iterator();
			String category = null;
			String pname = null;
			String price = null;
			String description = null;
			String filename = null;

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (fi.isFormField()) {// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					if (fieldName.equals("category")) {
						category = fi.getString();
						System.out.println(category);
					}
					if (fieldName.equals("pname")) {
						pname = fi.getString();
						System.out.println(pname);
					}
					if (fieldName.equals("price")) {
						price = fi.getString();
						System.out.println(price);
					}
					if (fieldName.equals("description")) {
						description = fi.getString();
						System.out.println(description);
					}
				} else {
					String fieldName = fi.getFieldName();
					if (fieldName.equals("file")) {
						ServletConfig sc = getServletConfig(); // String field=fi.getString();
						// String contentType = fi.getContentType();
						filename = fi.getName(); // boolean isInMemory = fi.isInMemory();
						// long sizeInBytes = fi.getSize();
						File f = new File(sc.getServletContext().getRealPath("/") + "imgupload/"); // create folder
						if (!f.exists())
							f.mkdir();
						// Write the file
						long l = System.currentTimeMillis();// 1 jan 1970 00:00 AM ---->till ms 8574389573498734
						System.out.println(l);
						String s = l + "";
						String sub = s.substring(8);
						file = new File(sc.getServletContext().getRealPath("/") + "imgupload/" + sub + filename);
						fi.write(file);
						filename = file.getName();
						out.println("Uploaded Filename: " + filename + "<br>");
						System.out.println("PATH=" + file.getPath());

					}
				}
				Foodbean e = new Foodbean();
				e.setCategory(category);
				e.setPname(pname);
				e.setPrice(price);
				e.setDescription(description);
				e.setFile(filename);
				DbDao dd = new DbDao();
				try {

					int x = dd.insertprod(e);
					if (x!=0) {
						RequestDispatcher rd = request.getRequestDispatcher("Addproduct.jsp");
						request.setAttribute("msg", "Product Inserted Successfully");
						rd.forward(request, response);
					}

				} catch (SQLException exx) {
					exx.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
