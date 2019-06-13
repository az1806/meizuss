package com.jiaju.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiajiu.dao.MessageDao;
import com.jiajiu.dao.impl.MessageDaoImpl;
import com.jiaju.entity.Message;

public class MessageAdminServlet extends BaseServlet {

	public void search(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		MessageDao messdao = new MessageDaoImpl();
		String searchstate = request.getParameter("searchstate");
		
		List<Message> Searlist = messdao.queryMessageByState(searchstate);
		

		request.setAttribute("Searlist", Searlist);
		request.getRequestDispatcher("/tgls/messageManage/message_list.jsp")
				.forward(request, response);

	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDao mesdao = new MessageDaoImpl();
		int lyid = Integer.parseInt(request.getParameter("lyid"));
		int n = mesdao.delMessage(lyid);
		if (n > 0) {
			System.out.println("ÁôÑÔÉ¾³ı³É¹¦");
			List<Message> messages = new ArrayList<Message>();
			messages = mesdao.queryMessages();
			request.setAttribute("messages", messages);

			request.getRequestDispatcher("/tgls/messageManage/message_list.jsp")
					.forward(request, response);
		} else {

			System.out.println("ÁôÑÔÉ¾³ıÊ§°Ü");
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int lyid = Integer.parseInt(request.getParameter("lyid"));
		String state = request.getParameter("state");
		MessageDao messdao = new MessageDaoImpl();

		if (state.equals("Î´»Ø¸´")) {
			state = "ÒÑ»Ø¸´";
			int n = messdao.updateState(lyid, state);
			if (n > 0) {

				System.out.println("ÁôÑÔ×´Ì¬ĞŞ¸Ä³É¹¦");

				List<Message> messages = new ArrayList<Message>();

				messages = messdao.queryMessages();

				request.setAttribute("messages", messages);

				request.getRequestDispatcher(
						"/tgls/messageManage/message_list.jsp").forward(
						request, response);
			} else {
				System.out.println("ÁôÑÔ×´Ì¬ĞŞ¸ÄÊ§°Ü");

			}

		} else if (state.equals("ÒÑ»Ø¸´")) {
			state = "Î´»Ø¸´";
			int n = messdao.updateState(lyid, state);
			if (n > 0) {

				System.out.println("ÁôÑÔ×´Ì¬ĞŞ¸Ä³É¹¦");

				List<Message> messages = new ArrayList<Message>();

				messages = messdao.queryMessages();

				request.setAttribute("messages", messages);

				request.getRequestDispatcher(
						"/tgls/messageManage/message_list.jsp").forward(
						request, response);
			} else {
				System.out.println("ÁôÑÔ×´Ì¬ĞŞ¸ÄÊ§°Ü");

			}

		}

	}

}
