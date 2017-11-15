/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.dummy.app;

import be.Company;
import inn2power.dummy.app.dal.MyCompanyDAO;
import java.io.File;
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
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        
        File file = new File("companies.csv");
        
        MyCompanyDAO myCompanyDAO = new MyCompanyDAO();
        
        List<Company> allCompanies = myCompanyDAO.readCompaniesFromCSV(file);
        
        System.out.println("Companies in CSV: " + allCompanies.size());
        
        File saveFile = new File("Companies.ser");
        
        myCompanyDAO.writeCompaniesToSer(saveFile, allCompanies);
        
        List<Company> savedCompanies = myCompanyDAO.readCompaniesFromSer(saveFile);
        
        System.out.println("Saved companies count: " + savedCompanies.size());
        
        
        
//        List<Company> allCompanies;
//        CompanyDAO companyDAO = new CompanyDAO();
//        allCompanies = companyDAO.getAllCompanies();
//
//        Company c = allCompanies.get(2);
//        RelationalLogic rc = new RelationalLogic();
//
//        int sizeOne = rc.getRelationalNetwork(c, 1).size();
//        int sizeTwo = rc.getRelationalNetwork(c, 2).size();
//        int sizeThree = rc.getRelationalNetwork(c, 3).size();
//
//        System.out.println("Size one: " + sizeOne);
//        System.out.println("Size two: " + sizeTwo);
//        System.out.println("Size three: " + sizeThree);

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
//        List<Relation> allRs = new RelationDAO().getAllRelations();
//        for (Relation r : allRs)
//        {
//            System.out.println(r.getSource().getName() + " --> " + r.getTarget().getName());
//        }
    }

}
