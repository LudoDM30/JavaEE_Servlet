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
import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.CompanyVO;

@WebServlet("/update")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<CompanyVO> companies = new ArrayList<>();
		int nRows = 0;
		/*
		 * recupero del contenuto eventualmente aggiornato di una riga
		 * della tabella html presente nella pagina companies.jsp
		 */
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		//conversione di employeesNumber da String a int per inserire l'informazione nell'oggetto DTO
		int empNumber = Integer.parseInt(employeesNumber);
		
		CompanyDAO companyDAO = new CompanyDAOImpl();
		
		CompanyDTO companyDTO = new CompanyDTO(vatNumber,businessName,addressLocation,empNumber);
		
		try {
			nRows= companyDAO.updateCompany(SqlScript.sqlCompanyUpdate, companyDTO);
			/*
			 * eseguiamo una operazione di lettura in maniera tale da avere una lista che contiene
			 * le companies aggiornate rispetto all'ultimo update effettuato
			 */
			companies = companyDAO.findAllCompanies(SqlScript.sqlCompanySelect);
			System.out.println(nRows);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!companies.isEmpty() && nRows > 0) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			response.sendRedirect(Page.companies);
			
			
			//registrazione corretta
		}
		else {
			response.sendRedirect(Page.error);
		}
		
		
	}

}