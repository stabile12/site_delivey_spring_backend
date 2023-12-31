package com.burguer.produtos.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutosAMQPConfiguration {

    @Bean
    public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
        return new RabbitAdmin(conn);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);

        return rabbitTemplate;
    }

    @Bean
    public Queue filaDetalhesPedidos() {
        return QueueBuilder
                .durable("avaliacoes-produtos")
                .build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange("avaliacoes.ex")
                .build();
    }

    @Bean
    public Binding bindAvaliacoes(FanoutExchange fanoutExchange, Queue filaDetalhesPedidos) {
        return BindingBuilder.bind(filaDetalhesPedidos)
                .to(fanoutExchange);
    }

    @Bean
    public Queue filaNumeroDeCompras() {
        return QueueBuilder
                .durable("compras-produtos")
                .build();
    }

    @Bean
    public FanoutExchange fanoutExchangeNumeroDeCompras() {
        return ExchangeBuilder
                .fanoutExchange("compras.ex")
                .build();
    }

    @Bean
    public Binding bindNumeroDeCompras(FanoutExchange fanoutExchangeNumeroDeCompras, Queue filaNumeroDeCompras) {
        return BindingBuilder.bind(filaNumeroDeCompras)
                .to(fanoutExchangeNumeroDeCompras);
    }
}
