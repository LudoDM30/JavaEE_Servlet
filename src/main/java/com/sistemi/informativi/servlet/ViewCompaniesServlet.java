package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dao.CompanyDAO;
import com.sistemi.informativi.dao.CompanyDAOImpl;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.CompanyVO;

@WebServlet("/companies")
public class ViewCompaniesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<CompanyVO> companies = new ArrayList<>();
		
		CompanyDAO companyDAO = new CompanyDAOImpl();
		/*
		 * recupero di tutte le companies esistenti
		 * sul database, grazie all'invocazione del
		 * metodo del DAO findAllCompanies
		 */
		try {
			companies = companyDAO.findAllCompanies(SqlScript.sqlCompanySelect);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		if(!companies.isEmpty()) {
			/*
			 * inizializziamo la sessione e 
			 * serviamo in sessione l'ArrayList 
			 * restituito dallo strato DAO solo
			 * nel caso in cui l'ArrayList contenga
			 * esattamente delle informazioni e di
			 * conseguenza reindirizziamo l'utente
			 * ad una pagina web che faccia vedere 
			 * tutto il contenuto dell'ArrayList
			 */
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			
			response.sendRedirect(Page.companies);
		}else {
			//inutile salvare in sessione
			response.sendRedirect(Page.error);
		}
	}

}
