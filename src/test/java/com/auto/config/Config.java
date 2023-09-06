package com.auto.config;

import com.auto.data.TestData;
import com.auto.pages.*;
import com.automation.core.config.CoreConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("file:src/test/resources/env/${env:dev}.properties")
@Import({CoreConfig.class})
public class Config {

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public CommonPage commonPage() {
        return new CommonPage();
    }


    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public HomePage homePage() {
        return new HomePage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public PropertyConfig propertyConfig() {
        return new PropertyConfig();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public TestData testData() {
        return new TestData();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public PDPage pdPage() {
        return new PDPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public NavigationPage navigationPage() {
        return new NavigationPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public MyAccountHomePage myAccountHomePage() {
        return new MyAccountHomePage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public HeaderPage headerPage() {
        return new HeaderPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public FooterPage footerPage() {
        return new FooterPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public MyOrdersPage myOrdersPage() {
        return new MyOrdersPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public OrderDetailsPage orderDetailsPage() {
        return new OrderDetailsPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public DataLayerPage dataLayerPage() {
        return new DataLayerPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public PaymentCardsPage paymentCardsPage() {
        return new PaymentCardsPage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public ContactPreferencePage contactPreferencePage() {
        return new ContactPreferencePage();
    }

    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public MyDeliveryAddressesPage myDeliveryAddressesPage() {
        return new MyDeliveryAddressesPage();
    }
    @Bean
    @Lazy
    @Scope("cucumber-glue")
    public MyPersonalDetailsPage myPersonalDetailsPage() {
        return new MyPersonalDetailsPage();
    }
}
