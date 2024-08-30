<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Citizen Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    h2 {
        text-align: center;
        color: #333;
        margin-top: 20px;
    }
    .container {
        width: 80%;
        max-width: 800px;
        margin: 0 auto;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin: 10px 0 5px;
        font-weight: bold;
    }
    input[type="text"], input[type="number"], input[type="date"], input[type="tel"], input[type="email"], select {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        background-color: #007BFF;
        color: #fff;
        border: none;
        padding: 15px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .form-group {
        margin-bottom: 15px;
    }
</style>
</head>
<body>
    <h2>Citizen Registration</h2>
    <div class="container">
        <form action="window.location.href='citizens'" method="post">
            <div class="form-group">
                <label for="AadharNo">Aadhar number:</label>
                <input type="text" id="AadharNo" name="AadharNo" pattern="\d{12}" maxlength="12" placeholder="12 digits mandatory" title="Aadhar number must be exactly 12 digits" required>
            </div>
            <div class="form-group">
                <label for="FirstName">First Name:</label>
                <input type="text" id="FirstName" name="FirstName" required>
            </div>
            <div class="form-group">
                <label for="MiddleName">Middle Name:</label>
                <input type="text" id="MiddleName" name="MiddleName">
            </div>
            <div class="form-group">
                <label for="LastName">Last Name:</label>
                <input type="text" id="LastName" name="LastName" required>
            </div>
            <div class="form-group">
                <label for="Gender">Gender:</label>
                <select id="Gender" name="Gender" required>
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            <div class="form-group">
                <label for="DateOfBirth">Date of Birth:</label>
                <input type="date" id="DateOfBirth" name="DateOfBirth" required>
            </div>
            <div class="form-group">
                <label for="phoneNo">Phone No:</label>
                <input type="text" id="phoneNo" name="phoneNo" pattern="\d{10}" maxlength="10" placeholder="10 digits mandatory" title="Phone number must be exactly 10 digits" required>
            </div>
            <div class="form-group">
                <label for="Email">Email:</label>
                <input type="email" id="Email" name="Email">
            </div>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
