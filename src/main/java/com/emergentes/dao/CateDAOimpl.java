package com.emergentes.dao;

import com.emergentes.modelo.cate;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CateDAOimpl extends ConexionBD implements CateDAO {

    @Override
    public void insert(cate libro) throws Exception {
        String sql = "insert into categoria(categoria) values(?)";

        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ps.setString(1, libro.getCategoria());

        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(cate libro) throws Exception {
        String sql = "update categoria set categoria=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
      
        ps.setString(1, libro.getCategoria());

        ps.setInt(2, libro.getId());

        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from categoria where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<cate> getAll() throws Exception {
        List<cate> lista = null;
        String sql = "select * from categoria";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<cate>();

        while (rs.next()) {
            cate lib = new cate();

            lib.setId(rs.getInt("id"));
           
            lib.setCategoria(rs.getString("categoria"));

            lista.add(lib);
        }
        this.desconectar();

        return lista;
    }

    @Override
    public cate getById(int id) throws Exception {
        cate lib = new cate();
        try {
            String sql = "select * from categoria where id =?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lib.setId(rs.getInt("id"));
                
                lib.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e ;

        } finally{
            this.desconectar();
        }

        
        return lib;
    }

}
