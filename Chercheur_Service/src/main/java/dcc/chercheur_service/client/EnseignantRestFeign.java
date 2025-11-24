package dcc.chercheur_service.client;


import dcc.chercheur_service.dto.ResponseDtoEnseignant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Enseignant-Service", configuration = FeignClientConfig.class")
public interface EnseignantRestFeign {

    @GetMapping("v1/enseignants/{id}")
    ResponseDtoEnseignant Enseignant_ByID(@PathVariable Long id);

}
