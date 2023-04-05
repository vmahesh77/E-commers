<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://static1.makeuseofimages.com/wp-content/uploads/2019/05/windows-7-upgrade.jpg');
}
width="100";
</style>
<meta charset="ISO-8859-1">
<title>add image</title>
</head>
<body>

<div style="text-align:centre; margin:5px auto 0px auto;padding: 10rem 4rem 3rem 4rem;">
<h3 style="font-size:30px"><em>ADD NEW IMAGE</em></h3>
<c:set var="item" value="${items}"> </c:set>
<form action="uploadimage" method="post" enctype="multipart/form-data">





<input type="text" value="${item.id}" name="Id" readonly="readonly" "please enter itemid" >
<br>
<input type="text"  value="${item.name}" name="itemName"  readonly="readonly" placeholder="please enter itemname"  >
<br>
<input type="text"  value="${item.price}" name="itemPrice" readonly="readonly" placeholder="please enter itemprice"  >
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="image" placeholder="image" >
<br>
<input type="submit" value="click here to add image ">
</form>
</div>
</div>
</body>
</html>