package es.daw.simpson.service;

import es.daw.simpson.model.Personaje;
import es.daw.simpson.repository.PersonajeRepository;

import java.util.List;

//El servicio si se conecta al repositorio
public class PersonajeService {
    //En Spring no usaremos new. Inyectaremos el repository con @Autowired
    private final PersonajeRepository personajeRepository = new PersonajeRepository();

    public List<Personaje> buscar() {
        return personajeRepository.findAll();
    }

}
