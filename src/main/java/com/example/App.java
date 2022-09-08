package com.example;

public final class App {

    public static void main(String[] args) {
        ContaMagica conta = new ContaMagica("123114-12", "Joao");
        System.out.println(conta.getSaldo());
        conta.deposito(1000);
        System.out.println(conta.getSaldo());
        conta.deposito(1000);
        System.out.println(conta.getSaldo());
        conta.retirada(1999);
        System.out.println(conta.getSaldo());

    }
}
