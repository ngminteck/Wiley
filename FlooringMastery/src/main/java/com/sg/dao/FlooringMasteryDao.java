package com.sg.dao;

import com.sg.model.Order;
import com.sg.model.Product;
import com.sg.model.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FlooringMasteryDao
{
    private final Set<State> states = new LinkedHashSet<>();
    private final Set<Product> products = new LinkedHashSet<>();

    private final List<Order> orders = new ArrayList<>();

    private Integer orderNumber;

    FlooringMasteryDao()
    {
        LoadProductsData();
        LoadTaxesData();
    }

    private void LoadProductsData()
    {
        List<String> list = new ArrayList<>();

        String productPath = "Data/Products.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(productPath))) {

            list = br.lines().collect(Collectors.toList());
            System.out.println("Data loaded.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(this::DeSerializationProductData);
    }

    private void DeSerializationProductData(String string)
    {
        String[] data = string.split(",");

        if(data.length <= 2)
            return;

        double value1;
        try
        {
            value1 = Double.parseDouble(data[1]);
        }
        catch (NumberFormatException ignored)
        {
            return;
        }

        double value2;
        try
        {
            value2 = Double.parseDouble(data[2]);
        }
        catch (NumberFormatException ignored)
        {
            return;
        }

        String productType = data[0];
        BigDecimal costPerSquareFoot = new BigDecimal(value1);
        costPerSquareFoot = costPerSquareFoot.setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(value2);
        laborCostPerSquareFoot = laborCostPerSquareFoot.setScale(2, RoundingMode.HALF_UP);

        Product product = new Product(productType,costPerSquareFoot,laborCostPerSquareFoot );
        products.add(product);

    }
    private void LoadTaxesData()
    {
        List<String> list = new ArrayList<>();

        String taxesPath = "Data/Taxes.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(taxesPath))) {

            list = br.lines().collect(Collectors.toList());
            System.out.println("Data loaded.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(this::DeSerializationTaxesData);
    }

    private void DeSerializationTaxesData(String string)
    {
        String[] data = string.split(",");

        if(data.length <= 2)
            return;

        double value1;
        try
        {
            value1 = Double.parseDouble(data[2]);
        }
        catch (NumberFormatException ignored)
        {
            return;
        }

        String stateAbbreviation = data[0];
        String stateName = data[1];
        BigDecimal taxRate = new BigDecimal(value1);
        taxRate = taxRate.setScale(2, RoundingMode.HALF_UP);

        State state = new State(stateAbbreviation,stateName,taxRate);

        states.add(state);
    }


}
