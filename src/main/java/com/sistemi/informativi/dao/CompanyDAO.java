package com.sistemi.informativi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.vo.CompanyVO;

public interface CompanyDAO {

	public int addCompany(String sqlCompanyInsert, CompanyDTO companyDto) throws ClassNotFoundException, SQLException;
	
	public ArrayList<CompanyVO> findAllCompanies(String sqlCompanySelect) throws ClassNotFoundException, SQLException;
	
	public int deleteCompany(String sqlDeleteCompany, String vatNumber) throws ClassNotFoundException, SQLException;
	
	public int updateCompany(String sqlUpdateCompany, CompanyDTO companyDTO) throws ClassNotFoundException, SQLException;
}
