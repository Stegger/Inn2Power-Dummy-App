/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2power.dummy.app.dal;

import be.Company;
import dal.ICompanyDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pgn
 */
public class MyCompanyDAO implements ICompanyDAO
{

    @Override
    public List<Company> readCompaniesFromCSV(File file) throws IOException
    {
        List<Company> companies = new ArrayList<>();

        for (String line : Files.readAllLines(file.toPath(), StandardCharsets.ISO_8859_1))
        {
            try
            {
                String[] splitLine = line.split(",");
                int id = Integer.parseInt(splitLine[0]);
                String name = splitLine[1];
                String country = splitLine[2];
                String address = splitLine[3];
                String website = splitLine[4];
                String supplyChainCategoriy = "Hest";
                String buisnessRole = "Consultant";
                double lat = Double.parseDouble(splitLine[5]);
                double lng = Double.parseDouble(splitLine[6]);
                int isSME = Integer.parseInt(splitLine[7]);

                Company c = new Company(id, name, country, address, website, supplyChainCategoriy, buisnessRole, lat, lng, isSME);
                companies.add(c);
            } catch (NumberFormatException nfe)
            {
                System.out.println("Exception: " + nfe.getMessage());
            }
        }
        return companies;
    }

    @Override
    public List<Company> readCompaniesFromSer(File file) throws IOException
    {
        List<Company> companies = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            companies = (List<Company>) ois.readObject();
        } catch (ClassNotFoundException ex)
        {
            //Do nothing;
        }
        return companies;
    }

    public void writeCompaniesToSer(File file, List<Company> list) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(list);
        }
    }

    @Override
    public void writeCompaniesToSer(List<Company> list) throws IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
