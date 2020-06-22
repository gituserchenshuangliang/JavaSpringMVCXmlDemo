<html>
<head>
    <title>Index</title>
    <meta charset="UTF-8">
    <script src="js/jQuery.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<h1 align="center">Index-JSP-Page</h1>
<form action="add" method="post">
    <table cellpadding="2">
        <tr>
            <td>角色ID：</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td>角色名称：</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>备注：</td>
            <td><input type="text" name="note"/></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<form action="upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><input type="file" name="A"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<form action="upload2" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><input type="file" name="B"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<form action="advice" method="post" enctype="text/plain">
    <table  cellpadding="2">
        <tr>
            <td>日期</td>
            <td><input id="date " name="date" type="date" value="2017-06-01" /></td>
        </tr>
        <tr>
            <td>数字</td>
            <td><input id="amount " name="amount" type="number" value="123,000.00" /></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input type="submit" value="提交" /></td>
        </tr>
    </table>
</form>
<hr>
<h1 align="center" id="msg"></h1>
<input type="button" value="jQuery" id="A" align="right"/>
</body>
<script src="js/app.js" type="text/javascript" charset="UTF-8"></script>
</html>
