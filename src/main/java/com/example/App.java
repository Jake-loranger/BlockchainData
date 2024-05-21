package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.models.ASAAsset;
import com.example.models.ASALiquidityPool;
import com.example.models.AssetData;
import com.example.models.ExchangeData;
import com.example.util.CoinAPI;
import com.example.util.VestigeAPI;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }

    @Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

    public void printData() {
        CoinAPI coinAPI = new CoinAPI();
        VestigeAPI vestigeAPI = new VestigeAPI(); 

        /* MARKDOWN - Prints asset data (price, name, volume, etc.) for the specified asset */
            // AssetData assetData = coinAPI.getAssetData("SOL");
            // assetData.display();
        

        /* MARKDOWN - Prints exchange data (lowest ask price, highest bid price) for the specified asset\ */
            // String[] exchangeIDs = {"KRAKEN", "COINBASE", "GEMINI", "ITBIT"};
            // for (String exchangeID: exchangeIDs) {
            //     ExchangeData exchangeData = coinAPI.getExchangeData("SOL", exchangeID);
            //     exchangeData.display();
            // }

        /* MARKDOWN - Prints asset data for the specified ASA Asset on Algorand */
            // ASAAsset asaAssetData = vestigeAPI.getASAData("chip");
            // asaAssetData.display();

        /* MARKDOWN - Prints exchange data for a specific ASA/ALGO combination */
            // ArrayList<ASALiquidityPool> liquidityPools = vestigeAPI.getASAExchangeData(asaAssetData);
            // for (ASALiquidityPool liquidityPool: liquidityPools) {
            //     liquidityPool.display();
            // }
    }
}