
package com.emergentes.dao;

import com.emergentes.modelo.cate;
import java.util.List;


public interface CateDAO {
    public void insert(cate libro) throws Exception;
    public void update(cate libro) throws Exception;
    public void delete(int id) throws Exception;
    public List<cate> getAll()  throws Exception;
    public cate getById(int id) throws Exception;
}