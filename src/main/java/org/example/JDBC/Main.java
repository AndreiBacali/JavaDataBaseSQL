package org.example.JDBC;

import java.sql.SQLException;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        MarketingCampaign marketingCampaign=new MarketingCampaign(null,"Name4",new Date(2022-12-18) ,3754d);
        MarketingCampaignDAO marketingCampaignDAO=new MarketingCampaignDAO(DataBaseConnection.getConnection());
        marketingCampaignDAO.create(marketingCampaign);
    }
}
