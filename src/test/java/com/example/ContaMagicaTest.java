package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testContaMagicaDeposito() {
        ContaMagica conta = new ContaMagica("217369-28", "Joao");
        conta.deposito(1000);
        assertEquals(1000, conta.getSaldo());
        conta.deposito(1000);
        assertEquals(2000, conta.getSaldo());
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
    void testContaMagicaDepositoInvalido() {
        assertThrows(IllegalValueException.class, () -> {
            ContaMagica conta = new ContaMagica("217369-28", "Joao");
            conta.deposito(-1);
        });
    }

}
