package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Loja loja = new Loja("TechStore", "Eletrônicos", "Juiz de Fora");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.cadastrar(loja);
        loja.lancarPromocao();
        assertEquals("Cliente 1, promoção lançada na Loja{nome='TechStore', categoria='Eletrônicos', cidade='Juiz de Fora'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Loja loja = new Loja("TechStore", "Eletrônicos", "Juiz de Fora");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.cadastrar(loja);
        cliente2.cadastrar(loja);
        loja.lancarPromocao();
        assertEquals("Cliente 1, promoção lançada na Loja{nome='TechStore', categoria='Eletrônicos', cidade='Juiz de Fora'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, promoção lançada na Loja{nome='TechStore', categoria='Eletrônicos', cidade='Juiz de Fora'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Loja loja = new Loja("TechStore", "Eletrônicos", "Juiz de Fora");
        Cliente cliente = new Cliente("Cliente 1");
        loja.lancarPromocao();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteLojaA() {
        Loja lojaA = new Loja("TechStore", "Eletrônicos", "Juiz de Fora");
        Loja lojaB = new Loja("ModaStore", "Vestuário", "Belo Horizonte");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.cadastrar(lojaA);
        cliente2.cadastrar(lojaB);
        lojaA.lancarPromocao();
        assertEquals("Cliente 1, promoção lançada na Loja{nome='TechStore', categoria='Eletrônicos', cidade='Juiz de Fora'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
