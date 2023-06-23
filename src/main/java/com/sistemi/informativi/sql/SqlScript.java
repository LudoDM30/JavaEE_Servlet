package com.sistemi.informativi.sql;

public interface SqlScript {

	final String sqlCompanyInsert = "insert into company(vat_number, business_name, address_location, employees_number) values (?,?,?,?)";
	
	final String sqlCompanySelect = "select * from company";
	
	final String sqlCompanyDelete = "delete from company where vat_number=?";
	
	final String sqlCompanyUpdate = "update company set business_name=?, address_location=?,employees_number=? where vat_number=?";
}
