package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    // GIbt alle Einträge zurück
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

//	@GetMapping
//	@ResponseStatus(HttpStatus.OK)
//	public List<Entry> getMyEntries(@PathVariable Long id) {
//		return entryService.findAllMine(id);
//	}

    // Erstellt einen neuen Eintrag
    // gibt den neuen Eintrag zurück
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry) {
        return entryService.createEntry(entry);
    }

    // Ändert einen bestehenden Eintrag
    // gibt den geänderte Eintrag zurück
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Entry updateEntry(@Valid @RequestBody Entry entry) {
        return entryService.updateEntry(entry);
    }

    // Löscht einen Eintrag anhand seiner id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
    }
}
