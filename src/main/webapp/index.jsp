<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/upload/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="multipartFile">
    <input type="submit">
</form>
</body>
</html>
