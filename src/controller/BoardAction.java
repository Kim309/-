package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDO.Bc;

public class BoardAction implements Action{//게시판  화면(게시글 목록 화면)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		AdminMenu adDAO= new AdminMenu();
		
		ArrayList<Bc> cateList= adDAO.getBoardCategory();
		req.setAttribute("cateList", cateList);
		
		
		//json문자열로 변환과정
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(cateList);
		req.setAttribute("json", jsonStr);
		
		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
