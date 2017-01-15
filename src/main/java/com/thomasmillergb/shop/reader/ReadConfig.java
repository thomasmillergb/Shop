package com.thomasmillergb.shop.reader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Thomas on 15/01/2017.
 */
@Configuration
public class ReadConfig
{
    @Bean
    public Scanner scanner(){
        return new Scanner();
    }
}
