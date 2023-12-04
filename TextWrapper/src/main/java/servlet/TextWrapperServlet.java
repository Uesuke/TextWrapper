package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TextWrapperLogic;
import model.WrappingBox;

/**
 * Servlet implementation class PrintWrapperServlet
 */
@WebServlet("/TextWrapperServlet")
public class TextWrapperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String former = request.getParameter("former");
		String latter = request.getParameter("latter");
//		String[] eraseOrNot = request.getParameterValues("eraseOrNot");
//		boolean executesEraser = eraseOrNot != null;
		String[] insertsOrNot = request.getParameterValues("insertOrNot");
		boolean executesInserter = insertsOrNot != null;
		String content = request.getParameter("content");

		WrappingBox wb = new WrappingBox(former, latter, executesInserter, content);
		
		//入力値に基づいた処理結果をリストに格納
		TextWrapperLogic twl = new TextWrapperLogic();
		twl.execute(wb);
		
		//結果リストをリクエストスコープに保存
		request.setAttribute("outputList", wb.getOutputList());
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
