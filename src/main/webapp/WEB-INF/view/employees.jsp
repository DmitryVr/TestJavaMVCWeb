<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/stylecss.css"/>" rel="stylesheet">
    <title>Employees</title>
</head>
<body>

<div id="cssLeftMenu">
    <c:if test="${not empty listEmployees}">
        <h3 align="center">Кликните по сотруднику</h3></br>
        <table>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
            </tr>

            <c:forEach var="employeeVar" items="${listEmployees}">
                <tr class="cssTrColor" onclick="location.href='/getEmployeesById/${employeeVar.id}'"> <%--сделать строку кликабельной--%>
                    <td>${employeeVar.firstName}</td>
                    <td>${employeeVar.lastName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<div id="cssContent">
    <%--добавление нового сотрудника или редактирование старого или удаление--%>
    <c:set var="action" value="/addOrUpdateEmployee" />
    <%--Spring form--%>
    <form:form method="POST" commandName="employee" action="${action}">
        <table>
            <c:if test="${employee.id != 0}">
                <tr>
                    <th colspan="2">
                        <h3>Редактировать сотрудника</h3>
                    </th>
                </tr>
                <tr>
                    <th>
                        <form:label path="id">id:</form:label>
                    </th>
                    <th>
                        <form:input path="id" readonly="true" />
                    </th>
                </tr>
            </c:if>

            <c:if test="${employee.id == 0}">
                <tr>
                    <th colspan="2">
                        <h3>Добавить сотрудника</h3>
                    </th>
                </tr>
            </c:if>

            <tr>
                <td>
                    <form:label path="firstName">Имя сотрудника:</form:label>
                </td>
                <td>
                    <form:input path="firstName" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="lastName">Фамилия сотрудника:</form:label>
                </td>
                <td>
                    <form:input path="lastName" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="gender">Пол:</form:label>
                </td>
                <td>
                    <form:select path="gender.id" >
                        <form:option value="-1">Не выбрано</form:option>
                        <form:options items="${listGender}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="yearOfBirth">Год рождения:</form:label>
                </td>
                <td>
                    <form:input path="yearOfBirth" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="position">Должность:</form:label>
                </td>
                <td>
                    <form:select path="position.id" >
                        <form:option value="-1">Не выбрано</form:option>
                        <form:options items="${listPosition}" itemLabel="name" itemValue="id"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="comments">Комментарии:</form:label>
                </td>
                <td>
                    <form:textarea path="comments" />
                </td>
            </tr>

            <tr>
                <td>
                    <c:if test="${employee.id == 0}">
                        <input type="submit" value="Добавить" class="cssBtn">
                    </c:if>

                    <c:if test="${employee.id != 0}">
                        <input type="submit" value="Обновить" class="cssBtn">
                    </c:if>
                </td>

                <c:if test="${employee.id != 0}">
                    <td>
                        <a href="<c:url value='/deleteEmployee/${employee.id}'/>">Удалить</a>
                    </td>
                </c:if>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
