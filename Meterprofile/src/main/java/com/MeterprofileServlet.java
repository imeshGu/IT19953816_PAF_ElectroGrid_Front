package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.dao.MeterprofileDao;
import com.pojo.Meterprofile;

/**
 * Servlet implementation class MeterprofileServlet
 */
@WebServlet("/MeterprofileServlet")
public class MeterprofileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MeterprofileDao meterDao;

	public MeterprofileServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = meterDao.registerMeterprofile(request.getParameter("id"), request.getParameter("name"),
				request.getParameter("connection_type"), request.getParameter("estimated_power_consumption"),
				request.getParameter("owner"), request.getParameter("initialized_date"),
				request.getParameter("initialized_emp"), request.getParameter("location"));

		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = meterDao.updateMeterprofile(paras.get("id").toString(), paras.get("name").toString(),
				paras.get("connection_type").toString(), paras.get("estimated_power_consumption").toString(),
				paras.get("owner").toString(), paras.get("initialized_date").toString(),
				paras.get("initialized_emp").toString(), paras.get("location").toString());

		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = meterDao.deleteMeterprofile(paras.get("id").toString());
		response.getWriter().write(output);

	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
