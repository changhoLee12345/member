package co.syeon.border.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;
import co.syeon.common.BorderCommand;

// borderList Command.
public class BorderList implements BorderCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		BorderDao dao = new BorderDao();

		String searchPage = (String) request.getAttribute("searchPage");
		String searchCondition = (String) request.getAttribute("searchCondition");
		String searchKeyword = (String) request.getAttribute("searchKeyword");

		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("page", searchPage);
		searchMap.put("keyword", searchKeyword);
		searchMap.put("condition", searchCondition);

		ArrayList<BorderVO> blist = dao.searchAll(searchMap);// dao.selectAll();
		request.setAttribute("list", blist);

		return "jsp/border/borderList.jsp";
	}

}
