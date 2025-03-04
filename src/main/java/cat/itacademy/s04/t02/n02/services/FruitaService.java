package cat.itacademy.s04.t02.n02.services;

import cat.itacademy.s04.t02.n02.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n02.model.Fruita;
import cat.itacademy.s04.t02.n02.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {
    @Autowired
    private FruitaRepository repository;

    public Fruita add(Fruita fruita) {
        return repository.save(fruita);
    }

    public Fruita update(Fruita fruita) {
        if (fruita.getId() == 0 || !repository.existsById(fruita.getId())) {
            throw new FruitNotFoundException("The id is null or the fruit no exist");
        }
        return repository.save(fruita);
    }

    public void delete(int id) {
        if (id == 0 || !repository.existsById(id)) {
            throw new FruitNotFoundException("The id is null or the fruit no exist");
        }
        repository.deleteById(id);
    }

    public Fruita getOne(int id) {
        if (id == 0 || !repository.existsById(id)) {
            throw new IllegalArgumentException("The id is null or the fruit no exist");
        }
        return repository.findById(id).get();
    }

    public List<Fruita> getAll() {
        return repository.findAll();
    }
}