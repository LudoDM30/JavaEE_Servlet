package com.sistemi.informativi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.vo.CompanyVO;

public class CompanyDAOImpl implements CompanyDAO {
	
	@Override
	public int addCompany(String sqlCompanyInsert, CompanyDTO companyDTO) throws ClassNotFoundException, SQLException {
		
		System.out.println(companyDTO.getAddressLocation());
		
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sqlCompanyInsert);
		
		ps.setString(1, companyDTO.getVatNumber());
		ps.setString(2, companyDTO.getBusinessName());
		ps.setString(3,  companyDTO.getAddressLocation());
		ps.setInt(4, companyDTO.getEmployeesNumber());
		
		return ps.executeUpdate();
	}

	@Override
	public ArrayList<CompanyVO> findAllCompanies(String sqlCompanySelect) throws ClassNotFoundException, SQLException {
	
		CompanyVO companyVO = null;
		ArrayList<CompanyVO> companies = new ArrayList<>();
		
		ResultSet rs = ConnectionManager.getResultSet(sqlCompanySelect);
		
		while (rs.next()) {
			
			companyVO = new CompanyVO(rs.getString("vat_number"),
									  rs.getString("business_name"),
									  rs.getString("address_location"),
									  rs.getInt("employees_number")
									  );
			companies.add(companyVO);
		}
		return companies;
	}

	@Override
	public int deleteCompany(String sqlDeleteCompany, String vatNumber) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sqlDeleteCompany);
		ps.setString(1, vatNumber);
		
		return ps.executeUpdate();
	}

	@Override
	public int updateCompany(String sqlUpdateCompany, CompanyDTO companyDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sqlUpdateCompany);
		ps.setString(1, companyDTO.getBusinessName());
		ps.setString(2, companyDTO.getAddressLocation());
		ps.setInt(3, companyDTO.getEmployeesNumber());
		ps.setString(4, companyDTO.getVatNumber());
		
		return ps.executeUpdate();
	}
	
	
}
