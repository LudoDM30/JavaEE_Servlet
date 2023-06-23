package com.sistemi.informativi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;

@WebServlet("/toupdate")
public class ToUpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * recupero di tutte le informazioni della riga
		 * della tabella della pagina companies.jsp rispetto
		 * alla quale l'utente ha cliccato sul tasto update
		 * 
		 * Tali dati devono essere recuperati esattamente
		 * nello stesso modo in cui erano presenti nella pagina
		 * di provenienza (companies.jsp)
		 */
		
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		
		int emplNumber = Integer.parseInt(employeesNumber);
		
		CompanyDTO companyDTO = new CompanyDTO(vatNumber, businessName, addressLocation, emplNumber);
		
		
		if(companyDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.companyDTO, companyDTO);
			response.sendRedirect(Page.updateCompany);
		}else {
			response.sendRedirect(Page.error);
		}
	}

}
