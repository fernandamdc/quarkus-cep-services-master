package com.manoelcampos.cepservice;

import javax.enterprise.context.Dependent;
import javax.ws.rs.client.WebTarget;

@Dependent
public class WidnetCepService extends AbstractCepService {
    /**
     * Instancia o serviço de CEP, definindo a URL base para acesso.
     * O construtor é protegido, pois, não queremos que quem for utilizar
     * as subclasses desta, possa indicar o domínio.
     * Classes filhas como {@link ViaCepService} são utilizadas para acesso
     * a um serviço específico, cujo domínio é definida pela própria subclasse.
     * Quem for utilizar tal subclasse não deve ter permissão para alterar o domínio.
     *
     * @return
     */
    public WidnetCepService() {
        super("https://apps.widenet.com.br/");
    }

    @Override
    protected WebTarget buildPath(String cep) {
       // https://apps.widenet.com.br/busca-cep/api/cep.json?code=77021090
        return getTarget().path("busca-cep/api/cep.json").queryParam("code", cep);
    }
}
