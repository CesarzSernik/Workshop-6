<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book edit form</title>
</head>
<body>
<h1>Edit a book!</h1><br>
<form name="bookEditForm" method="post" target="/books">
<%--    <label>ID--%>
<%--        <input type="number" name="id">--%>
<%--    </label><br>--%>
    <label> ISBN
        <input type="text" name="isbn">
    </label><br>
    <label>Title
        <input type="text" name="title">
    </label><br>
    <label>Author
        <input type="text" name="author">
    </label><br>
    <label>Publisher
        <input type="text" name="publisher">
    </label><br>
    <label>Type
        <input type="text" name="type">
    </label><br>
    <button type="submit">Create</button>
</form>
</body>
</html>
