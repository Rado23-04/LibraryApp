package Service;

import Modal.Author;
import Repository.CrudOperationAuthor;

public class ServiceAuthor {
    public static void Authorr(){

        CrudOperationAuthor authors = new CrudOperationAuthor();

        Author author = new Author(4,"John", 1999);
        authors.save(author);

        authors.findAll();
    }
}
