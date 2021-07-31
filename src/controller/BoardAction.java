package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDO.Bc;

public class BoardAction implements Action{//�Խ���  ȭ��(�Խñ� ��� ȭ��)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		AdminMenu adDAO= new AdminMenu();
		
		ArrayList<Bc> cateList= adDAO.getBoardCategory();
		req.setAttribute("cateList", cateList);
		
		
		//json���ڿ��� ��ȯ����
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(cateList);
		req.setAttribute("json", jsonStr);
		
		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
