package org.gouveia;

import org.gouveia.iphone.Iphone;

public class Main {
    public static void main(String[] args) {

        Iphone iphone = new Iphone();

        iphone.selecionarMusica("The Seven Angels - Avantasia");
        iphone.tocar();
        iphone.pausar();

        iphone.ligar("81 91111-2222");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.exibirPagina("https://www.dio.me/");
        iphone.adicionarNovaAba();
        iphone.atualizarPagina();
    }
}