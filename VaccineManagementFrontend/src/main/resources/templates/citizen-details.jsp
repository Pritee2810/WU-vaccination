<!DOCTYPE html>
<html xmlns:th="
http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Citizen Details</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #007bff;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px 0;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .details {
            display: flex;
            flex-wrap: wrap;
            gap: 10px; /* Space between items */
        }
        .details .detail-item {
            flex: 1 1 calc(33.333% - 20px); /* Three columns with space between */
            padding: 10px;
            background-color: #f8f9fa;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .details .detail-item label {
            font-weight: bold;
            color:gray;
        }
        .details .detail-item p {
            margin: 0;
            margin-bottom:30px;
        }
        @media (max-width: 768px) {
            .details .detail-item {
                flex: 1 1 100%; /* Single column on smaller screens */
            }
        }
</style>
</head>
<body>
<div class="container">
<h1>Citizen Details</h1>
<hr>
<a class="button" href="registeredcitizens">Back to Citizens List</a>
<div class="details">
<div class="detail-item">
<label>ID:</label>
<p th:text="${citizen.id}"></p>
</div>
<div class="detail-item">
<label>Aadhar No:</label>
<p th:text="${citizen.aadharNo}"></p>
</div>
<div class="detail-item">
<label>First Name:</label>
<p th:text="${citizen.firstName}"></p>
</div>
<div class="detail-item">
<label>Middle Name:</label>
<p th:text="${citizen.middleName}"></p>
</div>
<div class="detail-item">
<label>Last Name:</label>
<p th:text="${citizen.lastName}"></p>
</div>
<div class="detail-item">
<label>Gender:</label>
<p th:text="${citizen.gender}"></p>
</div>
<div class="detail-item">
<label>Date of Birth:</label>
<p th:text="${citizen.dateOfBirth}"></p>
</div>
<div class="detail-item">
<label>Phone No:</label>
<p th:text="${citizen.phoneNo}"></p>
</div>
<div class="detail-item">
<label>Email:</label>
<p th:text="${citizen.eMail}"></p>
</div>
<div class="detail-item">
<label>Vaccine Name:</label>
<p th:text="${citizen.vaccineName}"></p>
</div>
<div class="detail-item">
<label>First Dose:</label>
<p th:text="${citizen.firstDose}"></p>
</div>
<div class="detail-item">
<label>Second Dose:</label>
<p th:text="${citizen.secondDose}"></p>
</div>
<div class="detail-item">
<label>Booster Dose:</label>
<p th:text="${citizen.boosterDose}"></p>
</div>
<div class="detail-item">
<label>Status:</label>
<p th:text="${citizen.status}"></p>
</div>
</div>
</div>
</body>
</html>