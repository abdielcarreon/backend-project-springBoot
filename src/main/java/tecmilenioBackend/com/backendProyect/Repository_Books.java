package tecmilenioBackend.com.backendProyect;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class Repository_Books {

    @Autowired
    private JpaRepositoryBooks jparepobooks;

    public BookModel searchByID(final int id){
        Optional<BookEntity> out = jparepobooks.findById(id);
        if(out.isEmpty()) return null;
        return getBookModel(out.get());
    }

    public BookModel insert(final BookModel bookmodel){
        BookEntity entity = jparepobooks.save(getBookEntity(bookmodel));
        return getBookModel(entity);
    }


    private static BookModel getBookModel(BookEntity entity){
        return new BookModel(
            entity.getId(),
            entity.getName(),
            entity.getAuthor()
        );
    }

    private static BookEntity getBookEntity(BookModel model){
        return new BookEntity(
            model.getId(),
            model.getName(),
            model.getAuthor()
        );
    }
}