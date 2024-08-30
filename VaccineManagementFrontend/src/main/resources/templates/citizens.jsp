<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccine Management System</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        color: #333;
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        color: #333;
        margin-top: 20px;
    }
 
    button {
        display: block;
        width: 200px;
        margin: 20px auto;
        padding: 10px;
        font-size: 16px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
 
    button:hover {
        background-color: #0056b3;
    }
 
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
 
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
 
    th {
        background-color: #007bff;
        color: #fff;
    }
 
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
 
    tr:hover {
        background-color: #f1f1f1;
    }
 
    a.btn {
        display: inline-block;
        padding: 8px 16px;
        margin: 2px;
        font-size: 14px;
        text-align: center;
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 4px;
    }
 
    a.btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<h1>Citizens Table</h1>
<button onClick="window.location.href='showFormForadd'">
        Register New Citizen
</button>
<table>
<tr>
<th>REF. NO </th>
<th>FIRST NAME</th>
<th>MIDDLE NAME</th>
<th>LAST NAME</th>
<th>VIEW DETAILS</th>
<th>VACCINATION</th>
<th>DELETE CITIZEN</th>
</tr>
<tbody>
<tr th:each="citizen:${citizenDetails}">
<td th:text="${citizen.id}"></td>
<td th:text="${citizen.firstName}"></td>
<td th:text="${citizen.middleName}"></td>
<td th:text="${citizen.lastName}"></td>
<td>
<a th:href="@{/citizen-details/{id}(id=${citizen.id})}" class="btn">View</a>
</td>
<td>
<a th:href="@{/showFormForUpdate/{id}(id=${citizen.id})}" class="btn">Update</a>
</td>
<td>
<a th:href="@{/showFormForDelete/{id}(id=${citizen.id})}" class="btn">Delete</a>
</td>
</tr>
</tbody>
</table>
</body>
</html>