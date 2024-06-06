package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.service.VendaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class VendaWebController {

    private final VendaService vendaService;

    public VendaWebController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @RequestMapping("/vendas")
    public String getVendasPorData(Model model) {
        return "vendas";
    }

    @PostMapping("/vendas")
    public String postVendas(HttpServletRequest request, Model model) {
        LocalDate dataInicial = LocalDate.parse(request.getParameter("dataInicial"));
        LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"));

        List<Venda> vendas = vendaService.getByDataBetween(dataInicial, dataFinal);
        if (vendas.isEmpty()) {
            model.addAttribute("mensagem", "Não há vendas no intervalo de datas especificado.");
        } else {
            model.addAttribute("vendas", vendas);
        }

        return "vendas";
    }
}
