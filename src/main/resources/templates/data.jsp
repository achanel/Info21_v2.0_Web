<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Data</title>
    </head>
<h1>Head</h1>
<div>
    <layout:block name="header">
        header
    </layout:block>
</div>
<h1>Contents</h1>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Theme</th>
        </tr>
        <c:forEach items="${themeList}" var="theme" varStatus="status">
            <tr>
                <td>${theme.id}</td>
                <td>${theme.theme}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="footer">
    <hr />
    <a href="https://github.com/kwon37xi/jsp-template-inheritance">jsp template inheritance example</a>
</div>
</html>