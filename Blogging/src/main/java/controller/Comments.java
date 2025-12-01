package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Comment;

@WebServlet("/comments")
public class Comments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;

	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		con = (Connection) config.getServletContext().getAttribute("dbConn");
		System.out.println("Inside topics serv connected with db...");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int cid = Integer.parseInt(request.getParameter("cid"));

		try {
			pstmt = con.prepareStatement("select * from comments where topicid=?");
			pstmt.setInt(1, cid);

			rs = pstmt.executeQuery();

			List<Comment> clist = new ArrayList<Comment>();

			while (rs.next()) {

				Comment c = new Comment(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));

				clist.add(c);
			}

			request.setAttribute("comments", clist);

			System.out.println("Data has been set to clist");

			RequestDispatcher rd = request.getRequestDispatcher("comments.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
