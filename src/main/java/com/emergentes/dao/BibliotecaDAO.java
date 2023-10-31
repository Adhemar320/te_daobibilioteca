
package com.emergentes.dao;

import com.emergentes.modelo.libros;
import java.util.List;


public interface BibliotecaDAO {
    public void insert(libros libro) throws Exception;
    public void update(libros libro) throws Exception;
    public void delete(int id) throws Exception;
    public List<libros> getAll()  throws Exception;
    public libros getById(int id) throws Exception;
}
