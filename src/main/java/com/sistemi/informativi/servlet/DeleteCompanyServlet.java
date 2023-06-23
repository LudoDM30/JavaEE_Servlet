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

@WebServlet("/delete")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<CompanyVO> companies = new ArrayList<>();
		int nRows = 0;
		/*
		 * recupero del valore assegnato al
		 * parametro vatNumber (corrispondente al
		 * nome della variabile dopo il ?)
		 * aggiunto all'url delete della richiesta 
		 * proveniente dalla pagina companies.jsp
		 */
		String vatNumber = request.getParameter("vatNumber");
		
		CompanyDAO companyDAO = new CompanyDAOImpl();
		
		try {
			nRows = companyDAO.deleteCompany(SqlScript.sqlCompanyDelete, vatNumber);
			/*
			 * dopo la cancellazione effetuiamo 
			 * l'operazione di lettura sulla tabella 
			 * per far si che successivamente la 
			 * pagina web possa visualizzare il corretto
			 * stato attuale del DB
			 * 
			 * l'ArrayList companies riflette in questo 
			 * momento esattamente il contenuto della tabella
			 * dopo la cancellazione
			 */
			companies = companyDAO.findAllCompanies(SqlScript.sqlCompanySelect);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(nRows > 0 && !companies.isEmpty()) {
			/*
			 * viene salvata in sessione la lista
			 * companies che contiene le companies
			 * esistenti sul DB dopo l'operazione di
			 * cancellazione
			 * 
			 * In tal modo la companies.jsp potrà
			 * recuperare dalla sessione la lista 
			 * e farà pertanto visualizzare all'utente
			 * l'esatto numero di companies esistenti,
			 * ovvero quelle di prima - l'ultima cancellazione
			 */
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			
			response.sendRedirect(Page.companies);
		}else {
			response.sendRedirect(Page.error);
		}
	}

}
