/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.dummy.app;

import be.Company;

/**
 *
 * @author pgn
 */
public class CompanyCountryFilter implements ICompanyFilter
{

    private final String country;

    public CompanyCountryFilter(String country)
    {
        this.country = country;
    }
    
    @Override
    public boolean meetCriteria(Company company)
    {
        return company.getCountry().equalsIgnoreCase(country);
    }
    
}
