package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private final TimeEntryRepository timeEntryRepository ;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity<TimeEntry>(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }
    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(name = "id") long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        if(entry != null )
            return new ResponseEntity<TimeEntry>( entry, HttpStatus.OK);
        else
            return new ResponseEntity<TimeEntry>( HttpStatus.NOT_FOUND);
    }
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>( timeEntryRepository.list() , HttpStatus.OK);
    }
    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable(name = "id") long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {
        TimeEntry updateEntry = timeEntryRepository.update(timeEntryId, timeEntryToUpdate);
        if(updateEntry != null )
            return new ResponseEntity<TimeEntry>( updateEntry, HttpStatus.OK);
        else
            return new ResponseEntity<TimeEntry>( HttpStatus.NOT_FOUND);
    }
    @RequestMapping("/time-entries/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
    }
}
