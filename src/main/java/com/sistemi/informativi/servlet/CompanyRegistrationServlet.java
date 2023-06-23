package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/registration")
public class CompanyRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nRows = 0;
		
		/*
		 * recupero del contenuto informativo 
		 * della richiesta Http proveniente
		 * dal Client (recupero del body della richiesta)
		 * 
		 * !!Occorre invocare di volta in volta il metodo
		 * request.getParameter passando in input il name
		 * del campo html rappresentato dalla pagina web
		 * dalla quale viene inviata la richiesta
		 */
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		
		System.out.println(addressLocation);
		/*
		 * conversione di employeesNumber da String a Int
		 * per inserire l'informazione nell'Oggetto DTO
		 */
		int empNumber = Integer.parseInt(employeesNumber);
		
		CompanyDAO companyDAO = new CompanyDAOImpl();
		
		/*
		 * valorizzazione di un oggetto DTO con le 
		 * informazioni provenienti dal Client
		 */
		CompanyDTO companyDTO = new CompanyDTO(vatNumber, businessName, addressLocation, empNumber);
		
		try {
			nRows = companyDAO.addCompany(SqlScript.sqlCompanyInsert, companyDTO);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//END FLUSSO DI REQUEST
		
		//START FLUSSO DI RESPONSE
		
		if(nRows > 0) {
			//Inizializzazione di HttpSession
			HttpSession session = request.getSession();
			/*
			 * storage di una reference all'oggetto DTO
			 * che contiene tutte le informazioni inviate
			 * dal client in fase di richiesta, che saranno
			 * cosi rese disponibili al flusso di risposta
			 * In tal modo la correctRegistration.jsp
			 * potrà recuperare le informazioni che servono
			 * per la risposta
			 */
			session.setAttribute(Key.companyDTO, companyDTO);
			
			response.sendRedirect(Page.correctRegistration);
			// Registrazione corretta per la company
		}else {
			response.sendRedirect(Page.error);
		}
	}
}
