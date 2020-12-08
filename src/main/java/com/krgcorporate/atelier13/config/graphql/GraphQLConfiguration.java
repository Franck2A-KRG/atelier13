package com.krgcorporate.atelier13.config.graphql;

import com.krgcorporate.atelier13.domain.ActiveStatus;
import com.krgcorporate.atelier13.domain.TerminatedStatus;
import com.krgcorporate.atelier13.ws.graphql.directive.UppercaseDirective;
import graphql.kickstart.tools.SchemaParserDictionary;
import graphql.kickstart.tools.boot.SchemaDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class GraphQLConfiguration {

    /**
     * Fix issue https://github.com/graphql-java-kickstart/graphql-java-tools/issues/200
     */
    /*
    @Bean
    public SchemaParserDictionary getSchemaParser() {
        SchemaParserDictionary dictionary = new SchemaParserDictionary();
        dictionary.add(new HashMap<>() {{
            put("ActiveStatus", ActiveStatus.class);
            put("TerminatedStatus", TerminatedStatus.class);
        }});
        return dictionary;
    }
    */

    @Bean
    public SchemaDirective uppercaseDirective() {
        return new SchemaDirective("uppercase", new UppercaseDirective());
    }
}
