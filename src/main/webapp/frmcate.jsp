<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.cate"%>
<%
    cate  libro = (cate)request.getAttribute("libro");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        <form action="CateController" method ="post">
            <input type ="hidden" name ="id" value="${libro.id}"/>
            <table>
                
                <tr>
                <td>Categoria</td>
                <td><input type ="text" name="categoria" value="${libro.categoria}"/></td>
                </tr>
                <tr>
                <td></td>
                <td><input type ="submit"/></td>
                </tr>
            </table>
            
            </form>
  
    </body>
</html>

