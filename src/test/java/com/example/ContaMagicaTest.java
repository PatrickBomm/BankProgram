package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class ContaMagicaTest {

    // testes unitarios para a classe conta magica
    @Test
    void testContaMagica() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        assertEquals("Joao", conta.getNomeCorrentista());
        assertEquals("217369-28", conta.getNumeroConta());
        assertEquals(0, conta.getSaldo());
        assertEquals(Categoria.SILVER, conta.getCategoria());
    }

    // categorias

    @Test
    void testContaMagicaGold() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(50000);
        conta.deposito(1);
        assertEquals(Categoria.GOLD, conta.getCategoria());
    }

    @Test
    void testContaMagicaPlatinum() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(200000);
        conta.deposito(10000);
        conta.deposito(1);
        assertEquals(Categoria.PLATINUM, conta.getCategoria());
    }

    // nome e numero de conta

    @Test
    void testContaMagicaNomeInvalido() {
        assertThrows(IllegalNameException.class, () -> {
            ContaMagica conta = new ContaMagica("217369-28", "1");
        });
    }

    @Test
    void testContaMagicaNumeroInvalido() {
        assertThrows(IllegalNumberException.class, () -> {
            ContaMagica conta = new ContaMagica("1213412-99", "Joao");
        });
    }

    @Test
    void testContaMagicaNomeNull() {
        assertThrows(IllegalNameException.class, () -> {
            ContaMagica conta = new ContaMagica("217369-28", "a");
        });
    }


    // retirada

    @Test
    void testContaMagicaRetiradaInvalida() {
        assertThrows(IllegalValueException.class, () -> {
            ContaMagica conta = new ContaMagica("217369-28", "Joao");
            conta.deposito(1000);
            conta.retirada(-1);
        });
    }    
    
    @Test
    void testContaMagicaRetiradaInvalida2() {
        assertThrows(IllegalValueException.class, () -> {
            ContaMagica conta = new ContaMagica("217369-28", "Joao");
            conta.deposito(1000);
            conta.retirada(1001);
        });
    }
    
    @Test
    void testContaMagicaRetirada() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(1000);
        conta.deposito(1000);
        conta.retirada(1999);
        assertEquals(1, conta.getSaldo());
    }

    @Test
    void testContaMagicaRetirada2() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(200000);
        conta.deposito(10000);
        conta.deposito(1);
        conta.retirada(20001);
        assertEquals(190000.01, conta.getSaldo());
    }

    @Test
    void testContaMagicaRetirada3() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(100000);
        conta.deposito(10000);
        conta.deposito(1);
        conta.retirada(80000);
        assertEquals(108000.01, conta.getSaldo());
    }

    @Test
    void testContaMagicaRetirada4() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(100000);
        conta.deposito(100000);
        conta.deposito(1);
        assertEquals(Categoria.PLATINUM, conta.getCategoria());
        conta.retirada(80000);
        assertEquals(120001.01000000001, conta.getSaldo());
    }

    @Test
    void testContaMagicaRetirada5() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(100000);
        conta.deposito(10000);

        conta.retirada(80000);
        assertEquals(108000, conta.getSaldo());
    }


    // deposito

    @Test
    void testContaMagicaDepositoInvalido() {
        assertThrows(IllegalValueException.class, () -> {
            ContaMagica conta = new ContaMagica("217369-28", "Joao");
            conta.deposito(-1);
        });
    }

    @Test
    void testContaMagicaDeposito() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(1000);
        assertEquals(1000, conta.getSaldo());
        conta.deposito(1000);
        assertEquals(2000, conta.getSaldo());
    }

    @Test
    void testContaMagicaDeposito2() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(10000);
        conta.deposito(40001);
        conta.deposito(1);
        assertEquals(50002, conta.getSaldo());
    } 

    @Test
    void testContaMagicaDeposito3() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(200000);
        conta.deposito(10000);
        conta.deposito(1);
        conta.deposito(1);
        assertEquals(210002.03, conta.getSaldo());
    }

   
}
