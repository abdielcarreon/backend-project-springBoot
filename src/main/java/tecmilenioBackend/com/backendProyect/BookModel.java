package tecmilenioBackend.com.backendProyect;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookModel {
    private int id;
    private String name;
    private String author;
};
