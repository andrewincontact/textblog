package com.vpodobano.textblog.controller.page;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.vpodobano.textblog.Constants;
import com.vpodobano.textblog.controller.AbstractController;
import com.vpodobano.textblog.entity.Article;
import com.vpodobano.textblog.model.Items;
import com.vpodobano.textblog.model.Pagination;

@WebServlet("/search")
public class SearchController extends AbstractController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -305841009934591889L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getParameter("query");
		if (StringUtils.isNotBlank(query)) {
			int offset = getOffset(req, Constants.LIMIT_ARTICLES_PER_PAGE);
			Items<Article> items = getBusinessService().listArticlesBySearchQuery(query, offset, Constants.LIMIT_ARTICLES_PER_PAGE);
			req.setAttribute("list", items.getItems());
			req.setAttribute("count", items.getCount());
			req.setAttribute("searchQuery", query);
			Pagination pagination = new Pagination.Builder("/search?query=" + URLEncoder.encode(query, "utf8") + "&" , offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
			req.setAttribute("pagination", pagination);
			forwardToPage("search.jsp", req, resp);
		} else {
			resp.sendRedirect("/news");
		}
	}
}
