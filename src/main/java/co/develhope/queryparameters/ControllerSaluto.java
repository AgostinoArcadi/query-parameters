package co.develhope.queryparameters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1")
public class ControllerSaluto {

    @GetMapping("/ciao")
    public String ciao(
            @RequestParam String nome,
            @RequestParam String provincia
    ) {
        return "Ciao " + nome + ", com'è il tempo in " + provincia + "?";
    }

    @GetMapping("/calcola-eta")
    public Integer calcolaEta(@RequestParam(name = "data-nascita") String dataNascita) {
        Integer annoCorrente = LocalDate.now().getYear();
        Integer annoNascita = LocalDate.parse(dataNascita).getYear();
        return annoCorrente - annoNascita;
    }
}
