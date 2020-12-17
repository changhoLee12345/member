package co.syeon.border.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;
import co.syeon.common.BorderCommand;
import co.syeon.common.Paging;

// borderList Command.
public class BorderList implements BorderCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		BorderDao dao = new BorderDao();
		ArrayList<BorderVO> blist = dao.selectAll();
		request.setAttribute("list", blist);
		Paging paging = new Paging();
		paging.setTotalCount(100);
		request.setAttribute("params", paging);
		System.out.println(paging);

		return "jsp/border/borderList.jsp";
	}

}
