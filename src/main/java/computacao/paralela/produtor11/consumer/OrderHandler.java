package computacao.paralela.produtor11.consumer;

import computacao.paralela.produtor11.dto.Dados;
import computacao.paralela.produtor11.dto.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Deprecated
public class OrderHandler {

    public void processOrder(List<Dados> validOrders, Pedido pedido) {

        System.out.println("Printando os resultados");
        for (Dados dados : validOrders) {
            System.out.println(dados);
        }


        return;
    }

    private Dados findMinValidOrder(List<Dados> validOrders, Pedido pedido) {
        Dados minValidOrder = null;

        for(Dados dados : validOrders) {
            if (minValidOrder != null){
                if (dados.getQuantidadeColhida() >= pedido.getQuantidade() &&
                        dados.getQuantidadeColhida() <= minValidOrder.getQuantidadeColhida())
                    minValidOrder = dados;
            }
            else {
                if (dados.getQuantidadeColhida() >= pedido.getQuantidade()) minValidOrder = dados;
            }
        }
        return minValidOrder;
    }
}
