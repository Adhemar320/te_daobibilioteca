<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.cate"%>
<%
    List<cate> libro =(List<cate>) request.getAttribute("libro");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Categoria</h1>
        <p><a href="CateController?action=add">Nuevo</a></p><!-- comment -->
        <table border="1">
            <tr>
                <th>Id</th>
                
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cate}">
            
            <tr>
                <td>${item.id}</td>
              
                <td>${item.categoria}</td>
                <td><a href="CateController?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="CateController?action=delete&id=${item.id}">Eliminar</a></td>
               
            </tr>
            </c:forEach>
                
        </table>
            
    </body>
</html>
