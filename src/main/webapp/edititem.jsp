<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
body {
  
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>EDITIMAGE</title>
</head>
<body>













  <div style="text-align:right-centre; margin:5px auto 0px auto;padding: 10rem 6rem 7rem 20rem;">
<h3 style="font-size:60px"><em>IMAGE INFO</em></h3>
  <div class= "row">
  
  <c:forEach var="img" items="${item.base64Image}">
<div class="card col-2" style="width: 18rem;">

<img src="<c:out value="imageuploading/${item.id}/${img}"></c:out>" style="width:200px;height:200px;">

 
  
  <div class="card-body">
  <h5 class="card-title"><c:out value="${item.name}"></c:out></h5>
    <h6 class="card-subtitle mb-2 text-muted"><c:out value="${item.id}"></c:out></h6>
    <!--  <p class="card-text"> <a href="ImageRemoveServlet?itemid=<c:out value="${item.id}"></c:out>&itemname =<c:out value="${img}"></c:out>"> <button type="button" class="btn btn-danger">DELETE IMAGE</button></a></p>-->
    <a href="imageremove?itemid=<c:out value="${item.id}"></c:out>&itemname=<c:out value="${img}"></c:out>" class="btn btn-danger">delete!</a>

  </div>
</div>
</c:forEach>
</div>
<br>
<br>
<a href=imageadding?id=<c:out value="${item.id}"></c:out>> <button type="button" class="btn btn-info">ADD IMAGE</button> </a>
</div>










</body>
</html>