package cat.itacademy.s04.t02.n02.controllers;
import cat.itacademy.s04.t02.n02.model.Fruita;
import cat.itacademy.s04.t02.n02.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService service;

    @PostMapping("/add")
    public ResponseEntity<Fruita> add(@RequestBody Fruita fruita) {
        return ResponseEntity.ok(service.add(fruita));
    }

    @PutMapping("/update")
    public ResponseEntity<Fruita> update(@RequestBody Fruita fruita) {
        return ResponseEntity.ok(service.update(fruita));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOne(@PathVariable int id) {
        Fruita fruita = service.getOne(id);
        return (fruita != null) ? ResponseEntity.ok(fruita) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}