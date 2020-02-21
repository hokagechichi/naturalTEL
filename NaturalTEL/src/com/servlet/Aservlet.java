package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Item;
import com.google.gson.Gson;
import com.method.GsonUtils;
import com.service.JsonService;
import com.sun.accessibility.internal.resources.accessibility;

@WebServlet("/aservlet")
public class Aservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 請求編碼
		response.setContentType("text/html;charset=utf-8"); // 響應編碼

		String method = request.getParameter("method");
		JsonService jsonService = new JsonService();

		switch (method) {
		case "getBase64":
			// System.out.println("use base64...");
			try {

				List<Item> list = jsonService.getBase64();

				final Base64.Decoder decoder = Base64.getDecoder();

				PrintWriter pw = response.getWriter();

				for (Item item : list) {
					pw.append(item.getIdx() + ",");
					Map<String, String> map = GsonUtils
							.jsonToMap(new String(decoder.decode(item.getC_base64()), "UTF-8"));

					for (String key : map.keySet()) {
						pw.append(key + "&").append(map.get(key));
					}
					pw.append("<br>");

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		case "addBase64":{
			System.out.println("use addBase64...");
			String jsonString = request.getParameter("jsonString");
			System.out.println("jsonString = " + jsonString);
			int count = jsonService.addBase64(jsonString);
			if (count == 1) {
				request.setAttribute("info", "新增成功");
			} else {
				request.setAttribute("info", "新增失敗");
			}
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		}

		case "getAES256":
			System.out.println("use getAES256...");
			List<Item> list = jsonService.getAES256();
			PrintWriter pw = response.getWriter();

			for (Item item : list) {			
				Map<String, String> map = GsonUtils.jsonToMap(item.getC_aes256());
				if (map != null) {
					pw.append(item.getIdx() + ",");
					for (String key : map.keySet()) {
						pw.append(key + "&").append(map.get(key));
					}
					pw.append("<br>");
				}
			}

			break;
			
		case "addBase64AndAES256":
		{
			System.out.println("use addBase64AndAES256...");
			String jsonString = request.getParameter("jsonString");
			System.out.println("jsonString = " + jsonString);
			int count = jsonService.addBase64AndAES256(jsonString);
			if (count == 1) {
				request.setAttribute("info", "新增成功");
			} else {
				request.setAttribute("info", "新增失敗");
			}
			request.getRequestDispatcher("/index2.jsp").forward(request, response);
			break;
		}
		default:
			System.out.println("default...");
			break;
		}

	}

}
