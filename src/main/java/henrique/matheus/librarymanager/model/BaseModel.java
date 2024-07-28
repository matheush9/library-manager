package henrique.matheus.librarymanager.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;
    protected ZonedDateTime dateTimeCreated;
    protected ZonedDateTime dateTimeModified;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(ZonedDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public ZonedDateTime getDateTimeModified() {
        return dateTimeModified;
    }

    public void setDateTimeModified(ZonedDateTime dateTimeModified) {
        this.dateTimeModified = dateTimeModified;
    }
}
