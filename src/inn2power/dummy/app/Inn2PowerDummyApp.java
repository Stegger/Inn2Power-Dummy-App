/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.dummy.app;

import be.Company;
import be.Relation;
import dal.CompanyDAO;
import dal.RelationDAO;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Inn2PowerDummyApp
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        List<Company> allCompanies;
        CompanyDAO companyDAO = new CompanyDAO();
        allCompanies = companyDAO.getAllCompanies();

//        FunWithFiltering fwf = new FunWithFiltering();
//
//        fwf.fun();

//        allCompanies.stream().forEach(new Consumer<Company>()
//        {
//            @Override
//            public void accept(Company t)
//            {
//                System.out.println(t.getName());
//            }
//
//        });
        List<Relation> allRs = new RelationDAO().getAllRelations();
        for (Relation r : allRs)
        {
            System.out.println(r.getSource().getName() + " --> " + r.getTarget().getName());
        }

    }

}
