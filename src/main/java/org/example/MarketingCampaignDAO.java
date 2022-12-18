package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MarketingCampaignDAO {

    private final Connection connection;

    public MarketingCampaignDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() {
        try {

            Statement statement = connection.createStatement();
            statement.execute("create table if not exists marketing_campaign" +
                    "id int primary key auto_increment" +
                    "name varchar(200)" +
                    "start_date date" +
                    "budget double");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialized() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) form marketing_campaign");

            if (resultSet.next() && resultSet.getInt(1) == 0) {
                statement.execute("insert into marketing_campaign (name,start_date,budget) values " +
                        "('Name1','2022-12-18',1000),('Name2','2022-10-15',2000),('Name3','2021-10-20',500)");
                System.out.println("The table marketing_campaign was initialized!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(MarketingCampaign marketingCampaign) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("insert into marketing_campaign (name,start_date,budget) values" +
                   "("+marketingCampaign.getName()+""+
                    marketingCampaign.getStartDate() +
                    ""+marketingCampaign.getBudget()+");");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
