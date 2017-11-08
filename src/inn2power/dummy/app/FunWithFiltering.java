/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.dummy.app;

import be.Company;
import dal.CompanyDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class FunWithFiltering
{

    public void fun() throws IOException
    {
        List<Company> allCompanies = new CompanyDAO().getAllCompanies();

        //BAD IMPLEMENTATION:
//        for (Company company : allCompanies)
//        {
//            if(company.getCountry().equalsIgnoreCase("Denmark"))
//            {
//                if(company.getIsSME()==1)
//                {
//                    filteredList.add(company);
//                }
//            }
//        }
        List<ICompanyFilter> filters = new ArrayList<>();
        filters.add(new CompanyCountryFilter("Philippines"));
        List<Company> filteredList;
        filteredList = companyFiltering(allCompanies, filters);

        for (Company company : filteredList)
        {
            System.out.println(company.getName());
        }
    }

    public List<Company> companyFiltering(List<Company> allCompanies, List<ICompanyFilter> filters)
    {
        List<Company> filteredList = new ArrayList<>();
        for (Company company : allCompanies)
        {
            boolean isMatch = true;
            for (ICompanyFilter filter : filters)
            {
                if (!filter.meetCriteria(company))
                {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch)
            {
                filteredList.add(company);
            }
        }
        return filteredList;
    }

}
